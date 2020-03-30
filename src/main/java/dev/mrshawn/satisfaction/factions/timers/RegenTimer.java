package dev.mrshawn.satisfaction.factions.timers;

import dev.mrshawn.satisfaction.Satisfaction;
import org.bukkit.scheduler.BukkitRunnable;

public class RegenTimer extends BukkitRunnable {

	@Override
	public void run() {
		Satisfaction.getInstance().getFactionManager().regenPower();
	}

}
