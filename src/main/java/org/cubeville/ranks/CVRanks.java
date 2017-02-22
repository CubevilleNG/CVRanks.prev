package org.cubeville.ranks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.cubeville.commons.commands.CommandParser;
import org.cubeville.ranks.commands.ToggleCommand;
import org.cubeville.ranks.events.EventManager;

public class CVRanks extends JavaPlugin {
	
	RankManager rm;
	EventManager em;
	static CVRanks instance;
    private CommandParser commandParser;

	public void onEnable() {
		instance = this;
		
		rm = new RankManager();
		em = new EventManager(this);
		
		em.registerEvents();
		rm.registerRanks();
		
        commandParser = new CommandParser();
        commandParser.addCommand(new ToggleCommand());
	}

	public void onDisable() {
		
	}
	
	public static CVRanks getInstance() {
		return instance;
	} 
	
	public RankManager getRankManager() {
		return rm;
	}
	
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("cvranks")) {
            return commandParser.execute(sender, args);
        }
        return false;
    }

}
