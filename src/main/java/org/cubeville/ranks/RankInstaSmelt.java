package org.cubeville.ranks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class RankInstaSmelt extends RankToggleable implements RankBlockBreak {
	
	public RankInstaSmelt() {
		super("cubeville.instasmelt", "InstaSmelt", new HashSet<>(Arrays.asList("Smelt","IS")));
	}

	@Override
	public void runRankEvent(BlockBreakEvent event) {
		if (!this.playerHasPermission(event.getPlayer())) return;
		if (!activePlayers.contains(event.getPlayer().getUniqueId())) return;
		if (event.getBlock().getType() == Material.IRON_ORE) {
			event.getBlock().setType(Material.AIR);
			event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
			event.setCancelled(true);
		}
	}

	public static Set<Material> SmeltableBlocks = new HashSet<>(Arrays.asList(Material.IRON_ORE,Material.GOLD_ORE));
}
