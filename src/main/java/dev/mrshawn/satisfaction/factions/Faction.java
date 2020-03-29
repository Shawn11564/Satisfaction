package dev.mrshawn.satisfaction.factions;

import dev.mrshawn.satisfaction.factions.players.FPlayer;

import java.util.List;
import java.util.UUID;

public class Faction {

	private UUID uuid;
	private String name;
	private String description;
	private UUID owner;
	private List<FPlayer> members;

}
