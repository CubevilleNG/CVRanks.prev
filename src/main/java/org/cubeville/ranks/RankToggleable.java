package org.cubeville.ranks;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.entity.Player;

public class RankToggleable extends Rank {

	Set<UUID> activePlayers;
	
	public RankToggleable(String perm, String title, Collection<String> names) {
		super(perm, title, names);
		activePlayers = new HashSet<>();
	}

	public boolean containsPlayer(Player player) {
		return activePlayers.contains(player.getUniqueId());
	}
	
	public void addPlayer(Player player) {
		activePlayers.add(player.getUniqueId());
	}
	
	public void removePlayer(Player player) {
		activePlayers.remove(player.getUniqueId());
	}

}
