package de.legoshi.customblockbuilder.commands;

import de.legoshi.customblockbuilder.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlockShiftCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = ((Player) sender).getPlayer();

        if (args.length != 1) {

            player.sendMessage("/m <amount>");

        }

        try {

            Main.getInstance().playerManager.getPlayerPlayerObjectHashMap().get(player).setAmount(Double.parseDouble(args[0]));

        } catch (NumberFormatException ex) {

            player.sendMessage("Wrong input NOOB");
            return true;

        }

        player.sendMessage("Amount set: " + args[0]);

        return false;
    }
}
