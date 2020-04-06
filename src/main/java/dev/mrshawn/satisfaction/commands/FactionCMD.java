package dev.mrshawn.satisfaction.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import dev.mrshawn.cronus.api.utils.Chat;
import dev.mrshawn.satisfaction.Satisfaction;
import dev.mrshawn.satisfaction.factions.Faction;
import dev.mrshawn.satisfaction.factions.FactionManager;
import dev.mrshawn.satisfaction.factions.players.FPlayer;
import dev.mrshawn.satisfaction.factions.players.FPlayerManager;
import dev.mrshawn.satisfaction.factions.ranks.FRank;
import dev.mrshawn.satisfaction.utils.Debug;
import dev.mrshawn.satisfaction.utils.Items;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("f|faction|factions")
public class FactionCMD extends BaseCommand {

	private Satisfaction main;
	private FactionManager factionManager;
	private FPlayerManager playerManager;

	public FactionCMD(Satisfaction main) {
		this.main = main;
		factionManager = main.getFactionManager();
		playerManager = main.getFPlayerManager();
	}

	@Default
	@CatchUnknown
	@Subcommand("help")
	void onHelp(CommandSender sender) {
		Chat.tell(sender, "&a/f create <name>");
	}

	@Subcommand("create")
	@CommandPermission("satisfaction.create")
	void onCreate(Player player, String[] args) {
		if (!main.wrap(player).hasFaction()) {
			if (args.length >= 1) {
				Faction faction = new Faction(args[0], player.getUniqueId());
				faction.addMember(playerManager.getFPlayer(player));
				factionManager.addFaction(faction);
				playerManager.setFaction(player, faction, FRank.OWNER);
				Chat.tell(player, "&aCreated new faction: &6" + faction.getName());
			} else {
				Chat.tell(player, "&cUsage: /f create <name>");
			}
		} else {
			Chat.tell(player, "&cYou already have a faction!");
		}
	}

	@Subcommand("who")
	void onGet(Player player) {
		Debug.debugFaction(playerManager.getFPlayer(player).getFaction(), player);
	}

	@Subcommand("claim")
	void onClaim(Player player, String[] args) {
		FPlayer fp = main.wrap(player);

		if (fp.hasFaction()) {
			Items.giveClaimWand(player);
		} else {
			Chat.tell(player, "&cYou must be in a faction to claim land!");
		}

	}

}
