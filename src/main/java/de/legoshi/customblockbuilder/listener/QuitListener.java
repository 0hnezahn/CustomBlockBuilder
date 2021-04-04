package de.legoshi.customblockbuilder.listener;

import de.legoshi.customblockbuilder.Main;
import de.legoshi.customblockbuilder.utils.CustomBlockObject;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        Player p = event.getPlayer();

        Main.getInstance().customBlockManager.getCustomBlockManagerHashMap().remove(p);
        Main.getInstance().playerManager.getPlayerPlayerObjectHashMap().remove(p);

    }
}