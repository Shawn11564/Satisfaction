package dev.mrshawn.satisfaction;

import co.aikar.commands.PaperCommandManager;
import dev.mrshawn.satisfaction.commands.FactionCMD;
import dev.mrshawn.satisfaction.factions.FactionManager;
import dev.mrshawn.satisfaction.factions.players.FPlayerManager;
import dev.mrshawn.satisfaction.listeners.JoinEvent;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Satisfaction extends JavaPlugin {

	@Getter
	private static Satisfaction instance;

	private FactionManager factionManager;
	private FPlayerManager fPlayerManager;

	@Override
	public void onEnable() {
		instance = this;
		factionManager = new FactionManager(this);
		fPlayerManager = new FPlayerManager(this);
		registerCommands();
		registerEvents();
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new JoinEvent(this), this);
	}

	private void registerCommands() {
		PaperCommandManager pcm = new PaperCommandManager(this);
		pcm.registerCommand(new FactionCMD(this));
	}
}
