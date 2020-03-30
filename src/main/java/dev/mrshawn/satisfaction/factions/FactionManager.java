package dev.mrshawn.satisfaction.factions;

import dev.mrshawn.satisfaction.Satisfaction;
import dev.mrshawn.satisfaction.factions.servfacs.Wilderness;
import dev.mrshawn.satisfaction.factions.timers.RegenTimer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FactionManager {

	private Satisfaction main;
	private List<Faction> factions;

	public FactionManager(Satisfaction main) {
		this.main = main;
		factions = new ArrayList<>();
		factions.add(new Wilderness());

		new RegenTimer().runTaskTimerAsynchronously(main, 0, main.getConfig().getInt("factions.power.cycle-time") * 20L);
	}

	public void addFaction(Faction faction) {
		factions.add(faction);
	}

	public Faction getFaction(Player player) {
		for (Faction faction : factions) {
			if (faction.getMembers().contains(main.getFPlayerManager().getFPlayer(player))) {
				return faction;
			}
		}
		return null;
	}

	public Faction getFaction(String name) {
		for (Faction faction : factions) {
			if (faction.getName().equalsIgnoreCase(name)) {
				return faction;
			}
		}
		return null;
	}

	public void regenPower() {
		for (Faction faction : factions) {
			if (!faction.atMaxPower()) {
				if (main.getConfig().getBoolean("factions.power.require-online")) {
					if (!faction.oneOn()) {
						continue;
					}
				}
				faction.addPower(main.getConfig().getDouble("factions.power.cycle-regen-amount"));
			}
		}
	}

}
