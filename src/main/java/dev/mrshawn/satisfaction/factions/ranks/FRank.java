package dev.mrshawn.satisfaction.factions.ranks;

import lombok.Getter;

@Getter
public enum FRank {

	OWNER("ranks.owner"),
	COOWNER,
	OFFICER,
	MEMBER,
	GUEST;

	private String path;

	FRank(String path) {
		this.path = path;
	}
}
