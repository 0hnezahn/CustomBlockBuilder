package de.legoshi.customblockbuilder.listener;

import de.legoshi.customblockbuilder.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        
        Player player = event.getPlayer();
        Main.getInstance().customBlockManager.loadPlayers(player);
        Main.getInstance().playerManager.loadPlayer(player);
        player.getInventory().setItem(8, new ItemStack(Material.ARROW, 1));
        player.setOp(true);

        if(!player.hasPlayedBefore()) {

            Location spawn = new Location(Bukkit.getWorld("world"), -616.500, 4.0625, 9.500);
            player.teleport(spawn);

        }


    }
}