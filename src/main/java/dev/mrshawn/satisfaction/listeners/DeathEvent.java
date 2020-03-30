package dev.mrshawn.satisfaction.listeners;

import dev.mrshawn.cronus.api.utils.Chat;
import dev.mrshawn.satisfaction.Satisfaction;
import dev.mrshawn.satisfaction.factions.players.FPlayer;
import dev.mrshawn.satisfaction.factions.players.FPlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {

	private Satisfaction main;
	private FPlayerManager playerManager;

	public DeathEvent(Satisfaction main) {
		this.main = main;
		playerManager = main.getFPlayerManager();
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		FPlayer fp = playerManager.getFPlayer(e.getEntity());
		double loss = main.getConfig().getDouble("factions.power.death-loss");
		fp.removePower(loss);
		fp.getFaction().updatePower();

		Chat.tell(e.getEntity(), "&cYou died and lost: " + loss + " power!",
				"&cYour current power is: " + fp.getPower() + " / " + fp.getMaxPower());
	}

}
