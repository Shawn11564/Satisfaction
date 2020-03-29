package dev.mrshawn.satisfaction;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Satisfaction extends JavaPlugin {

	@Getter
	private static Satisfaction instance;

	@Override
	public void onEnable() {
		// Plugin startup logic

	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
