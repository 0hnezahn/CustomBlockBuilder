package de.legoshi.customblockbuilder.listener;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    public void onPlace(BlockPlaceEvent e) {

        if (!(e.getPlayer().hasPermission("permission.place"))) {

            e.setCancelled(true);

        }

    }

}
