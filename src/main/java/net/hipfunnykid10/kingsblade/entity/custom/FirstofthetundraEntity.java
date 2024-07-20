package net.hipfunnykid10.kingsblade.entity.custom;

import com.mojang.serialization.Dynamic;
import net.hipfunnykid10.kingsblade.entity.ModEntities;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Unit;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class FirstOfTheTundraEntity extends AnimalEntity {

    public final AnimationState awakenAnimationState = new AnimationState();
    private int awakenAnimationTimeout = 0;
    private int tickage = 0;
    public FirstOfTheTundraEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this, this.isInPose(EntityPose.EMERGING) ? 1 : 0);
    }

    private void setupAnimationStates() {
        if (this.awakenAnimationTimeout <= 0) {
            this.awakenAnimationTimeout = this.random.nextInt(40) + 80;
        }else {
            this.awakenAnimationTimeout--;
       }
    }
    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        if (POSE.equals(data)) {
            switch (this.getPose()) {
                case EMERGING:
                    this.awakenAnimationState.start(this.age);
                    break;
            }
        }
    }

    @Override
    protected Brain<?> deserializeBrain(Dynamic<?> dynamic) {
        return TundraBrain.create(this, dynamic);
    }

    @Override
    public Brain<FirstOfTheTundraEntity> getBrain() {
        return (Brain<FirstOfTheTundraEntity>)super.getBrain();
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f;
        if (this.getPose() == EntityPose.EMERGING) {
            f = Math.min(posDelta * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 1f);
    }

    private void addDigParticles(AnimationState animationState) {
        if ((float)animationState.getTimeRunning() < 4500.0F) {
            Random random = this.getRandom();
            BlockState blockState = this.getSteppingBlockState();
            if (blockState.getRenderType() != BlockRenderType.INVISIBLE) {
                for (int i = 0; i < 30; i++) {
                    double d = this.getX() + (double) MathHelper.nextBetween(random, -0.7F, 0.7F);
                    double e = this.getY();
                    double f = this.getZ() + (double)MathHelper.nextBetween(random, -0.7F, 0.7F);
                    this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState), d, e, f, 0.0, 0.0, 0.0);
                }
            }
        }
    }

    public EntityData initialize(
            ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt
    ) {
        this.getBrain().remember(MemoryModuleType.DIG_COOLDOWN, Unit.INSTANCE, 1200L);
        if (spawnReason == SpawnReason.COMMAND) {
            this.setPose(EntityPose.EMERGING);
            this.getBrain().remember(MemoryModuleType.IS_EMERGING, Unit.INSTANCE, (long) TundraBrain.EMERGE_DURATION);
        } else if (spawnReason == SpawnReason.SPAWN_EGG) {
            this.setPose(EntityPose.EMERGING);
            this.getBrain().remember(MemoryModuleType.IS_EMERGING, Unit.INSTANCE, (long) TundraBrain.EMERGE_DURATION);
        }

        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    public void remove(Entity.RemovalReason reason) {
        if (!this.getWorld().isClient && this.isDead()) {
            Text text = this.getCustomName();
            boolean bl = this.isAiDisabled();
            int k = 2 + this.random.nextInt(3);

            for (int l = 0; l < k; l++) {
                //float g = ((float)(l % 2) - 0.5F) * f;
                //float h = ((float)(l / 2) - 0.5F) * f;
                FirstOfTheTundraEntity firstOfTheTundraEntity = (FirstOfTheTundraEntity) this.getType().create(this.getWorld());
                if (firstOfTheTundraEntity != null) {
                    firstOfTheTundraEntity.setCustomName(text);
                    firstOfTheTundraEntity.setInvulnerable(this.isInvulnerable());
                    //firstOfTheTundraEntity.refreshPositionAndAngles(this.getX() + (double)g, this.getY() + 0.5, this.getZ() + (double)h, this.random.nextFloat() * 360.0F, 0.0F);
                    firstOfTheTundraEntity.getWorld().spawnEntity(firstOfTheTundraEntity);
                }
            }
        }

        super.remove(reason);
    }

    @Override
    public void tick() {
        super.tick();
        tickage += 1;
        if(this.getWorld().isClient()){
            switch (this.getPose()) {
                case EMERGING:
                    this.addDigParticles(this.awakenAnimationState);
                    this.setPose(EntityPose.STANDING);
                    damage(getRecentDamageSource(),1);
                    break;
            }
       }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return this.isDiggingOrEmerging() && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) ? true : super.isInvulnerableTo(damageSource);
    }

    boolean isDiggingOrEmerging() {
        return this.isInPose(EntityPose.EMERGING);
    }
    public void ServerTickEvents(){
        tickage += 1;
    }



    @Override
    protected void initGoals() {
            this.goalSelector.add(0, new SwimGoal(this));
    }
    public static DefaultAttributeContainer.Builder createFirstOfTheTundraAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.1f)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,100);

    }
    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.FIRST_OF_THE_TUNDRA.create(world);
    }

    public AnimationState getAwakenAnimationState() {
        return awakenAnimationState;
    }
}
