package org.cubeville.ranks.commands;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.entity.Player;
import org.cubeville.commons.commands.Command;
import org.cubeville.commons.commands.CommandExecutionException;
import org.cubeville.commons.commands.CommandParameterBoolean;
import org.cubeville.commons.commands.CommandResponse;
import org.cubeville.ranks.RankToggleable;

public class ToggleCommand extends Command {

	public ToggleCommand() {
		super("toggle");
		addBaseParameter(new CommandParameterRankToggle());
		addBaseParameter(new CommandParameterBoolean("enable","disable"));
	}

	@Override
	public CommandResponse execute(Player player, Set<String> flags, Map<String, Object> parameters,
	        List<Object> baseParameters) throws CommandExecutionException {
		RankToggleable rank = (RankToggleable) baseParameters.get(0);
		boolean enable = (boolean) baseParameters.get(1);
		if (!rank.playerHasPermission(player)) throw new CommandExecutionException("&cYou don't have access to &6" + rank.getName() + "&c!");
		if (!enable) {
			rank.removePlayer(player);
			return new CommandResponse("&6" + rank.getName() + " &cdisabled!");
		} else {
			rank.addPlayer(player);
			return new CommandResponse("&6" + rank.getName() + " &cenabled!");
		}
	}

}
