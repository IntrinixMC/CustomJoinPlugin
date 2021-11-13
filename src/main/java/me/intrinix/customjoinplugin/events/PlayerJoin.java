package me.intrinix.customjoinplugin.events;

import me.intrinix.customjoinplugin.CustomJoinPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerJoin implements Listener
{

    CustomJoinPlugin plugin;

    public PlayerJoin(CustomJoinPlugin plugin)
    {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onPlayerLeave(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();

        String defaultJoinMessage = "[ + ] %player%";
        defaultJoinMessage = defaultJoinMessage.replaceAll("%player%", player.getDisplayName());

        String newJoinMessage = plugin.getConfig().getString("join-message");

        if(newJoinMessage != null)
        {

            newJoinMessage = newJoinMessage.trim();
            newJoinMessage = ChatColor.translateAlternateColorCodes('&', newJoinMessage);

            if(newJoinMessage.contains("%player%"))
            {
                newJoinMessage = newJoinMessage.replaceAll("%player%", player.getDisplayName());
            }

            if(!newJoinMessage.isEmpty())
            {
                event.setJoinMessage(newJoinMessage);
            }
            else
            {
                event.setJoinMessage(defaultJoinMessage);
            }
        }

    }
}
