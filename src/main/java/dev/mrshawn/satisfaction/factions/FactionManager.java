package dev.mrshawn.satisfaction.factions;

import dev.mrshawn.cronus.api.utils.Chat;
import dev.mrshawn.satisfaction.Satisfaction;
import dev.mrshawn.satisfaction.factions.servfacs.Wilderness;
import org.bukkit.Bukkit;
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
	}

	public void addFaction(Faction faction) {
		factions.add(faction);
		Chat.tell(Bukkit.getPlayer("DonCheadle"), String.valueOf(factions));
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

}
