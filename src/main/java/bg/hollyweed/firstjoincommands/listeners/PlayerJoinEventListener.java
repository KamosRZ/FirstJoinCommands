package bg.hollyweed.firstjoincommands.listeners;

import bg.hollyweed.firstjoincommands.FirstJoinCommands;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public final class PlayerJoinEventListener implements Listener {

    private final Configuration CONFIG;
    public PlayerJoinEventListener(FirstJoinCommands plugin) {
        this.CONFIG = plugin.getConfig();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {
            List<String> commands = CONFIG.getStringList("commands");
            commands.forEach((command) -> {
                runCommands(command, player.getName());
            });
        }
    }

    private void runCommands(String command, String playerName) {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        if (command.contains("%player%")) {
            command = command.replace("%player%", playerName);
        }
        Bukkit.dispatchCommand(console, command);
    }
}
