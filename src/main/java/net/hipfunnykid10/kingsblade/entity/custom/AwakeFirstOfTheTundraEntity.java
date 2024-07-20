package net.hipfunnykid10.kingsblade.entity.custom;

import com.mojang.serialization.Dynamic;
import net.hipfunnykid10.kingsblade.entity.ModEntities;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.MobEntity;
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
import net.minecraft.util.Unit;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class AwakeFirstOfTheTundraEntity extends AnimalEntity {

    public final AnimationState awakenAnimationState = new AnimationState();
    private int awakenAnimationTimeout = 0;
    private int tickage = 0;
    public AwakeFirstOfTheTundraEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }


    private void setupAnimationStates() {
        if (this.awakenAnimationTimeout <= 0) {
            this.awakenAnimationTimeout = this.random.nextInt(40) + 80;
        }else {
            this.awakenAnimationTimeout--;
       }
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
    public void tick() {
        super.tick();
        tickage += 1;
        if(this.getWorld().isClient()){
            switch (this.getPose()) {
                case EMERGING:
                    this.addDigParticles(this.awakenAnimationState);
                    this.setPose(EntityPose.STANDING);
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
        if(tickage >= 500){
            this.goalSelector.add(1, new WanderAroundFarGoal(this,10));
            this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class,20f));
            this.goalSelector.add(3, new LookAroundGoal(this));
        }
            this.goalSelector.add(0, new SwimGoal(this));
    }
    public static DefaultAttributeContainer.Builder createFirstOfTheTundraAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 250)
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
