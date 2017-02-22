package org.cubeville.ranks.commands;

import org.cubeville.commons.commands.CommandParameterType;
import org.cubeville.ranks.CVRanks;
import org.cubeville.ranks.Rank;
import org.cubeville.ranks.RankToggleable;

public class CommandParameterRankToggle implements CommandParameterType {

	@Override
	public boolean isValid(String value) {
		for (Rank rank:CVRanks.getInstance().getRankManager().getRanks()) {
			if (rank instanceof RankToggleable) {
				for (String rankName: rank.getAliases()) {
					if (value.equalsIgnoreCase(rankName)) return true;
				}
			}
		}
		return false;
	}

	@Override
	public String getInvalidMessage(String value) {
		return value + "is no valid toggleable rank!";
	}

	@Override
	public Object getValue(String value) {
		for (Rank rank:CVRanks.getInstance().getRankManager().getRanks()) {
			if (rank instanceof RankToggleable) {
				for (String rankName: rank.getAliases()) {
					if (value.equalsIgnoreCase(rankName)) return rank;
				}
			}
		}
		return null;
	}

}
