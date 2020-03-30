package dev.mrshawn.satisfaction.factions;

import dev.mrshawn.satisfaction.factions.players.FPlayer;
import dev.mrshawn.satisfaction.utils.Debug;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Faction {

	private UUID uuid;
	private String name;
	private String description;
	private UUID owner;
	private List<FPlayer> members;
	private double power;
	private double maxPower;

	public Faction(String name, UUID owner) {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.owner = owner;
		members = new ArrayList<>();
	}

	public void addMember(FPlayer player) {
		members.add(player);
		updatePower();
	}

	public void updatePower() {
		maxPower = 0;
		power = 0;
		for (FPlayer fp : members) {
			power += fp.getPower();
			maxPower += fp.getMaxPower();
		}

		if (power > maxPower) {
			power = maxPower;
		}

		for (FPlayer fp : members) {
			Debug.debugFaction(this, Bukkit.getPlayer(fp.getUuid()));
		}
	}

	public void addPower(double amount) {
		for (FPlayer fp : members) {
			fp.addPower(amount);
		}
		updatePower();
	}

	public boolean isRaidable() {
		return power <= 0;
	}

	public boolean atMaxPower() {
		return power == maxPower;
	}

	public boolean oneOn() {
		for (FPlayer fp : members) {
			if (fp.isOnline()) {
				return true;
			}
		}
		return false;
	}

}
