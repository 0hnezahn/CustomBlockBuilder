package de.legoshi.customblockbuilder.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;

public class VehicleEnter implements Listener {

    @EventHandler
    public void onEnter(VehicleEnterEvent e) {

        e.setCancelled(true);

    }

}
