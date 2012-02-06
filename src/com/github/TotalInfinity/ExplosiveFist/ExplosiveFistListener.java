package com.github.TotalInfinity.ExplosiveFist;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ExplosiveFistListener implements Listener{
    
    World world = null;
    Player player = null;
    public Map<Player, Boolean> canPunch = new HashMap();
    
    public ExplosiveFistListener (JavaPlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerPunch(PlayerInteractEvent event){
        if (canPunch.get(player)) {
            if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
                 if (event.hasItem() == false) {
                    world = event.getClickedBlock().getWorld();
                    world.createExplosion(event.getClickedBlock().getLocation(), 2);
                 }
            }
        }
    }
    
    @EventHandler
    public void playerLogin(PlayerLoginEvent event) {
        player = event.getPlayer();
        if (!canPunch.containsKey(player)) {
            canPunch.put(player, false);
        }
    }
}