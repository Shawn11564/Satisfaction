package dev.mrshawn.satisfaction.factions.players;

import dev.mrshawn.satisfaction.Satisfaction;
import dev.mrshawn.satisfaction.factions.Faction;
import dev.mrshawn.satisfaction.factions.ranks.FRank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FPlayer {

	private UUID uuid;
	private Faction faction;
	private FRank rank;
	private int blocks;
	private int bpm;
	private double maxPower;
	private double power;

	public FPlayer(UUID uuid, Faction faction, FRank rank, int blocks, int bpm, double maxPower, double power) {
		this.uuid = uuid;
		this.faction = faction;
		this.rank = rank;
		this.blocks = blocks;
		this.bpm = bpm;
		this.maxPower = maxPower;
		this.power = power;
	}

	public FPlayer(UUID uuid, int blocks, int bpm, double maxPower, double power) {
		this.uuid = uuid;
		this.blocks = blocks;
		this.bpm = bpm;
		this.maxPower = maxPower;
		this.power = power;
		faction = Satisfaction.getInstance().getFactionManager().getFaction("Wilderness");
	}

	public void addPower(double power) {
		this.power += power;
	}

	public void addMaxPower(double power) {
		this.maxPower += power;
	}

	public void addBlocks(int blocks) {
		this.blocks += blocks;
	}

	public void addBPM(int bpm) {
		this.bpm += bpm;
	}
}
