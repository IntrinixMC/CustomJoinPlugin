package me.intrinix.customjoinplugin;

import me.intrinix.customjoinplugin.events.PlayerJoin;
import me.intrinix.customjoinplugin.events.PlayerLeave;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomJoinPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();


        new PlayerJoin(this);
        new PlayerLeave(this);
    }
}
