package org.cubeville.ranks.events;

import org.bukkit.plugin.PluginManager;
import org.cubeville.ranks.CVRanks;

public class EventManager {
	
    private CVRanks plugin;

    public EventManager(CVRanks plugin) {
        this.plugin = plugin;
    }
    
    PluginManager pm;

    public void registerEvents() {
    	pm = plugin.getServer().getPluginManager();
		pm.registerEvents(new EventBlockBreak(), plugin);
	}

}
