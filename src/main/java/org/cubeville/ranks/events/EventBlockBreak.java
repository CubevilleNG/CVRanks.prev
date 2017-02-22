package org.cubeville.ranks.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.cubeville.ranks.CVRanks;

public class EventBlockBreak implements Listener {
	
	@EventHandler (priority=EventPriority.MONITOR)
	public void onBlockBreak(BlockBreakEvent e) {
		CVRanks.getInstance().getRankManager().runBlockBreakEvent(e);
	}

}
