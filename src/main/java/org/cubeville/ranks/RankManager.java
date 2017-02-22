package org.cubeville.ranks;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.event.block.BlockBreakEvent;

public class RankManager {
	
	public Set<Rank> ranks;
	
	public RankManager() {
		ranks = new HashSet<>();
	}
	
	public void register(Rank rank) {
		ranks.add(rank);
	}
	
	public void runBlockBreakEvent(BlockBreakEvent e) {
		for (Rank rank: ranks) {
			if (rank instanceof RankBlockBreak) ((RankBlockBreak) rank).runRankEvent(e);
		}
	}
	
	public void registerRanks() {
		ranks.add(new RankInstaSmelt());
	}
	
	public Set<Rank> getRanks() {
		return ranks;
	}

}
