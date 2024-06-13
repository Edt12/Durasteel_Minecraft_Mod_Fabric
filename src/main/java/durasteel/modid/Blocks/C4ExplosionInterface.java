package durasteel.modid.Blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockLocating;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import static net.minecraft.entity.damage.DamageSource.*;

public interface C4ExplosionInterface {

	public default void customExplosion(World world, BlockPos pos, int power) {
		if (!world.isClient) {
			world.playSound(null,pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.BLOCKS);
			world.removeBlock(pos, false);
			//power be radius
			System.out.println(pos + " Old Pos");
			int x = pos.getX();
			int firstHalfY = pos.getY();
			int secondHalfY = pos.getY() + power;

			int z = pos.getZ();
			int counter = 0;
			firstHalfY -= power;
			pos = new BlockPos(x, firstHalfY, z);
			System.out.println(pos + " New pos");
			ArrayList<BlockPos> firstHalfPrevRemoved = new ArrayList<>();
			ArrayList<BlockPos> secondHalfPrevRemoved = new ArrayList<>();
			while (counter <= power * 2) {
				pos = new BlockPos(x, firstHalfY, z);
				if (counter == 0) {
					world.removeBlock(pos, false);
					firstHalfPrevRemoved.add(pos);


				} else if (counter == 1) {
					world.removeBlock(pos, false);

					pos = new BlockPos(firstHalfPrevRemoved.get(0).getX() + 1, pos.getY(), firstHalfPrevRemoved.get(0).getZ());
					firstHalfPrevRemoved.add(pos);
					world.removeBlock(pos, false);

					pos = new BlockPos(firstHalfPrevRemoved.get(0).getX() - 1, pos.getY(), firstHalfPrevRemoved.get(0).getZ());
					world.removeBlock(pos, false);
					firstHalfPrevRemoved.add(pos);

					pos = new BlockPos(firstHalfPrevRemoved.get(0).getX(), pos.getY(), firstHalfPrevRemoved.get(0).getZ() - 1);
					world.removeBlock(pos, false);
					firstHalfPrevRemoved.add(pos);

					pos = new BlockPos(firstHalfPrevRemoved.get(0).getX(), pos.getY(), firstHalfPrevRemoved.get(0).getZ() + 1);
					world.removeBlock(pos, false);
					firstHalfPrevRemoved.add(pos);

				} else if (counter < power) {
					HashSet<BlockPos> firstHalfPrevRemovedTemp = new HashSet<>();
					for (int i = 0; i < firstHalfPrevRemoved.size(); i++) {
						firstHalfPrevRemovedTemp.add(firstHalfPrevRemoved.get(i));
					}
					for (int j = 0; j < firstHalfPrevRemoved.size(); j++) {
						firstHalfPrevRemovedTemp.add(new BlockPos(firstHalfPrevRemoved.get(j).getX() + 1, firstHalfY, firstHalfPrevRemoved.get(j).getZ()));
						firstHalfPrevRemovedTemp.add(new BlockPos(firstHalfPrevRemoved.get(j).getX() - 1, firstHalfY, firstHalfPrevRemoved.get(j).getZ()));
						firstHalfPrevRemovedTemp.add(new BlockPos(firstHalfPrevRemoved.get(j).getX(), firstHalfY, firstHalfPrevRemoved.get(j).getZ() + 1));
						firstHalfPrevRemovedTemp.add(new BlockPos(firstHalfPrevRemoved.get(j).getX(), firstHalfY, firstHalfPrevRemoved.get(j).getZ() - 1));


					}
					firstHalfPrevRemoved.addAll(firstHalfPrevRemovedTemp);
					for (int i = 0; i < firstHalfPrevRemoved.size(); i++) {
						pos = new BlockPos(firstHalfPrevRemoved.get(i).getX(), firstHalfY, firstHalfPrevRemoved.get(i).getZ());
						world.removeBlock(pos, false);
					}
					System.out.println("Before Power");
				} else if (counter >= power) {
					System.out.println("After Power");
					HashSet<BlockPos> secondHalfPrevRemovedTemp = new HashSet<>();

					if (counter == power) {
						pos = new BlockPos(pos.getX(), pos.getY() + power * 2, pos.getZ());
						world.removeBlock(pos, false);
						secondHalfPrevRemoved.add(pos);
					} else if (counter == power + 1) {
						world.removeBlock(pos, false);

						pos = new BlockPos(secondHalfPrevRemoved.get(0).getX() + 1, secondHalfY, secondHalfPrevRemoved.get(0).getZ());
						secondHalfPrevRemoved.add(pos);

						world.removeBlock(pos, false);

						pos = new BlockPos(secondHalfPrevRemoved.get(0).getX() - 1, secondHalfY, secondHalfPrevRemoved.get(0).getZ());
						world.removeBlock(pos, false);
						secondHalfPrevRemoved.add(pos);

						pos = new BlockPos(secondHalfPrevRemoved.get(0).getX(), secondHalfY, secondHalfPrevRemoved.get(0).getZ() - 1);
						world.removeBlock(pos, false);
						secondHalfPrevRemoved.add(pos);

						pos = new BlockPos(secondHalfPrevRemoved.get(0).getX(), secondHalfY, secondHalfPrevRemoved.get(0).getZ() + 1);

						world.removeBlock(pos, false);
						secondHalfPrevRemoved.add(pos);

					} else {

						for (int j = 0; j < secondHalfPrevRemoved.size() - 1; j++) {
							secondHalfPrevRemovedTemp.add(new BlockPos(secondHalfPrevRemoved.get(j).getX() + 1, secondHalfY, secondHalfPrevRemoved.get(j).getZ()));
							secondHalfPrevRemovedTemp.add(new BlockPos(secondHalfPrevRemoved.get(j).getX() - 1, secondHalfY, secondHalfPrevRemoved.get(j).getZ()));
							secondHalfPrevRemovedTemp.add(new BlockPos(secondHalfPrevRemoved.get(j).getX(), secondHalfY, secondHalfPrevRemoved.get(j).getZ() + 1));
							secondHalfPrevRemovedTemp.add(new BlockPos(secondHalfPrevRemoved.get(j).getX(), secondHalfY, secondHalfPrevRemoved.get(j).getZ() - 1));

						}
						secondHalfPrevRemoved.addAll(secondHalfPrevRemovedTemp);
						for (int i = 0; i < secondHalfPrevRemoved.size() - 1; i++) {
							pos = new BlockPos(secondHalfPrevRemoved.get(i).getX(), secondHalfY, secondHalfPrevRemoved.get(i).getZ());
							world.removeBlock(pos, false);

						}


					}
					secondHalfY -= 1;
				}

				firstHalfY += 1;
				counter++;


			}
			System.out.println("damaging entities");
			System.out.println(firstHalfPrevRemoved.size() + "First Half Removed Size");
			System.out.println(secondHalfPrevRemoved.size() + "Second Half Removed Size");
			//Damaging entities
			for (int a = 0; a < firstHalfPrevRemoved.size(); a++) {
				List<LivingEntity> entityList = world.getEntitiesByClass(LivingEntity.class,new Box(firstHalfPrevRemoved.get(a)), entity -> true);

				for (LivingEntity entity: entityList){
					System.out.println(entity + " Entity First");
				}
				System.out.println("Counter " + a);
				for (int j = 0; j < entityList.size(); j++) {
					System.out.println(entityList.get(j) + " Entity First 2");
					entityList.get(j).damage(world.getDamageSources().explosion(null), 100);
				}
			}
			for (int b = 0; b < secondHalfPrevRemoved.size(); b++) {
				List<LivingEntity> entityList2 = world.getEntitiesByClass(LivingEntity.class,new Box(secondHalfPrevRemoved.get(b)),entity -> true);
				for (LivingEntity entity: entityList2){
					System.out.println(entity + " Entity Second");
				}
				System.out.println("Counter " + b);
				for (int p = 0;p < entityList2.size(); p++) {
					System.out.println(entityList2.get(p) + "Entity Second 2");
					entityList2.get(p).damage(world.getDamageSources().explosion(null), 100);
				}


			}

		}
	}

}