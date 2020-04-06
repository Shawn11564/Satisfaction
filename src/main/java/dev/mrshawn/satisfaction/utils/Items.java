package dev.mrshawn.satisfaction.utils;

import dev.mrshawn.cronus.api.items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFactory;

import java.util.Arrays;

public class Items {

	public static void giveClaimWand(Player player) {
		if (hasOpenSlot(player)) {
			ItemBuilder wand = new ItemBuilder(Material.WOODEN_HOE);
			wand.setName("&eClaim Wand");
			wand.setLore(Arrays.asList(
					"&6Left click &7the ground to select point 1",
					"&6Right click &7the ground to select point 2",
					"&6Shift + Right Click &7the air to claim!"));
			player.getInventory().addItem(wand.build());
		}

	}

	public static boolean hasOpenSlot(Player player) {
		return player.getInventory().firstEmpty() != -1;
	}

}
