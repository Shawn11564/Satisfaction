package dev.mrshawn.satisfaction.utils;

import dev.mrshawn.cronus.api.utils.Chat;
import dev.mrshawn.satisfaction.factions.Faction;
import org.bukkit.entity.Player;

public class Debug {

	public static void debugFaction(Faction faction, Player player) {
		String uuid = String.valueOf(faction.getUuid());
		String name = faction.getName();
		String desc = faction.getDescription();
		String owner = String.valueOf(faction.getOwner());
		String members = String.valueOf(faction.getMembers());
		double power = faction.getPower();
		double maxPower = faction.getMaxPower();

		Chat.tell(player, "UUID: " + uuid,
				"Name: " + name,
				"Description: " + desc,
				"Owner: " + owner,
				"Members: " + members,
				"Power: " + power,
				"Max Power: " + maxPower);
	}

}
