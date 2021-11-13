package me.intrinix.customjoinplugin.events;

import me.intrinix.customjoinplugin.CustomJoinPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    CustomJoinPlugin plugin;

    public PlayerLeave(CustomJoinPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();

        String newQuitMessage = plugin.getConfig().getString("leave-message");

        if(newQuitMessage != null)
        {
            newQuitMessage = newQuitMessage.trim();
            newQuitMessage = ChatColor.translateAlternateColorCodes('&', newQuitMessage);
            newQuitMessage = newQuitMessage.replaceAll("%player%", player.getDisplayName());
            if(!newQuitMessage.isEmpty())
            {
                event.setQuitMessage(newQuitMessage);
            }
            else
            {
                event.setQuitMessage(ChatColor.DARK_RED + "[ + ] " + player.getDisplayName());
            }
        }

    }


}
