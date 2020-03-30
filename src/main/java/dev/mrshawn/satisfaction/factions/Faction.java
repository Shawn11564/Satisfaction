package dev.mrshawn.satisfaction.factions;

import dev.mrshawn.satisfaction.factions.players.FPlayer;
import lombok.Getter;
import lombok.Setter;

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

	public Faction(String name, UUID owner) {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.owner = owner;
		members = new ArrayList<>();
	}

	public void addMember(FPlayer player) {
		members.add(player);
	}

}
