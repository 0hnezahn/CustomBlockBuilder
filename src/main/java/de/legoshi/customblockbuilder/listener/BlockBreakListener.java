package de.legoshi.customblockbuilder.listener;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    public void onBreak(BlockBreakEvent e) {

        if(!(e.getPlayer().hasPermission("permission.break"))) {

            e.setCancelled(true);

        }

    }
}
