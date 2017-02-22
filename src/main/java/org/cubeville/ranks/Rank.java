package org.cubeville.ranks;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.entity.Player;

public class Rank {

	String permission;
	Set<String> aliases;
	String title;
	
	public Rank(String perm, String title, Collection<String> names) {
		permission = perm;
		this.title = title;
		names.add(title);
		aliases = new HashSet<>(names);
	}
	
	public boolean playerHasPermission(Player player)  {
		return player.hasPermission(permission);
	}
	
	public Set<String> getAliases() {
		return aliases;
	}
	
	public String getName() {
		return title;
	}
}
