package dev.mrshawn.satisfaction.factions.players;

import dev.mrshawn.satisfaction.Satisfaction;
import dev.mrshawn.satisfaction.factions.Faction;
import dev.mrshawn.satisfaction.factions.ranks.FRank;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FPlayerManager {

	private Satisfaction main;
	private List<FPlayer> players;

	public FPlayerManager(Satisfaction main) {
		this.main = main;
		players = new ArrayList<>();
	}

	public void addFPlayer(Player player) {
		FPlayer fp = new FPlayer(player.getUniqueId(), 0, 0, 0, 0);
		players.add(fp);
	}

	public void setFaction(Player player, Faction faction) {
		FPlayer fp = getFPlayer(player);
		fp.setFaction(faction);
		fp.setRank(FRank.MEMBER);
	}

	public void setFaction(Player player, Faction faction, FRank fRank) {
		FPlayer fp = getFPlayer(player);
		fp.setFaction(faction);
		fp.setRank(fRank);
	}

	public FPlayer getFPlayer(Player player) {
		for (FPlayer fp : players) {
			if (fp.getUuid() == player.getUniqueId()) {
				return fp;
			}
		}
		return null;
	}
}
