package bg.hollyweed.firstjoincommands;

import bg.hollyweed.firstjoincommands.commands.ReloadCommandExecutor;
import bg.hollyweed.firstjoincommands.listeners.PlayerJoinEventListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class FirstJoinCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
        getLogger().info("FirstJoinCommands has been disabled!");
    }

    public void onReload() {
        HandlerList.unregisterAll(this);
        this.reloadConfig();
        registerListeners();
        getLogger().info("FirstJoinCommands has been reloaded!");
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(this), this);
    }

    private void registerCommands() {
        this.getCommand("firstjoincommandsreload").setExecutor(new ReloadCommandExecutor(this));
    }
}
