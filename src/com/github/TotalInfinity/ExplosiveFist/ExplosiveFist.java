package com.github.TotalInfinity.ExplosiveFist;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ExplosiveFist extends JavaPlugin{
    
    public static void main(String[] args){

    }
    
    private ExplosiveFistListener punchListener = null;
    static final Logger log = Logger.getLogger("Minecraft");
    public Player player = null;
    
    @Override
    public void onEnable() {
        punchListener = new ExplosiveFistListener(this);
    }
    
    @Override
    public void onDisable() {
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(cmd.getName().equalsIgnoreCase("ef") && args.length == 0 && sender instanceof Player){
            player = (Player)sender;
            if (punchListener.canPunch.get(player)) {
                punchListener.canPunch.put(player, false);
                player.sendMessage("ExplosiveFist disabled!");
            } else {
                punchListener.canPunch.put(player, true);
                player.sendMessage("ExplosiveFist enabled!");
            }
    	    return true;
    	}
    	    return false; 
    }
    
}