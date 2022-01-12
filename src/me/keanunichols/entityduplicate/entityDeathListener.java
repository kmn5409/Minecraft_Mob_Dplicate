package me.keanunichols.entityduplicate;

import java.util.Random;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class entityDeathListener implements Listener {
	public boolean getRandomBoolean() {
	    Random random = new Random();
	    return random.nextBoolean();
	}
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public Location createEntityLocation(Location eLocation){
		Location nLocation = eLocation.add(getRandomNumber(0,3),getRandomNumber(0,3),getRandomNumber(0,3));
		return nLocation;
	}
	
	

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		int random_number;
		if(getRandomBoolean()){
			if(event.getEntity() instanceof LivingEntity && (event.getEntity().getKiller() instanceof Player) && !(event.getEntity().getType() == EntityType.ENDER_DRAGON )){
				random_number = getRandomNumber(1,5);
				for(int i=0; i<random_number; i++) {
					event.getEntity().getWorld().spawnEntity(createEntityLocation(event.getEntity().getLocation()), event.getEntityType());
				}
			}
		}
	}

}

