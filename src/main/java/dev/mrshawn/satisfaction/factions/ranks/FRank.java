package dev.mrshawn.satisfaction.factions.ranks;

import lombok.Getter;

@Getter
public enum FRank {

	OWNER("ranks.owner"),
	COOWNER("ranks.co-owner"),
	OFFICER("ranks.officer"),
	MEMBER("ranks.member"),
	GUEST("ranks.guest");

	private String path;

	FRank(String path) {
		this.path = path;
	}
}
