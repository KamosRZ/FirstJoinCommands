package bg.hollyweed.firstjoincommands.commands;

import bg.hollyweed.firstjoincommands.FirstJoinCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommandExecutor implements CommandExecutor {

    private final FirstJoinCommands PLUGIN;

    public ReloadCommandExecutor(FirstJoinCommands plugin) {
        this.PLUGIN = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PLUGIN.onReload();
        String RELOAD_MESSAGE = "Plugin and configuration have been reloaded!";
        sender.sendMessage(ChatColor.GREEN + RELOAD_MESSAGE);
        return true;
    }
}
