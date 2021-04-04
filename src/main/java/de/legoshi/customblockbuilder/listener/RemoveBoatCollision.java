package de.legoshi.customblockbuilder.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCollisionEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;

public class RemoveBoatCollision implements Listener {

    @EventHandler
    public void onBoatCollision(VehicleEntityCollisionEvent e) {

        e.setCancelled(true);

    }

}
