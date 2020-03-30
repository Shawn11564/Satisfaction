package dev.mrshawn.satisfaction.listeners;

import dev.mrshawn.satisfaction.Satisfaction;
import dev.mrshawn.satisfaction.factions.players.FPlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

	private Satisfaction main;
	private FPlayerManager playerManager;

	public JoinEvent(Satisfaction main) {
		this.main = main;
		playerManager = main.getFPlayerManager();
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		playerManager.addFPlayer(e.getPlayer()).setOnline(true);
	}

}
