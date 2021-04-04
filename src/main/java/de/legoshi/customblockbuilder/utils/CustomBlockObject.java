package de.legoshi.customblockbuilder.utils;

import de.legoshi.customblockbuilder.manager.CustomBlockManager;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Boat;

import java.util.ArrayList;

public class CustomBlockObject extends CustomBlockManager {

    ArrayList<ArmorStand> armorStandArrayList;
    Boat boat;
    Location location;


    public CustomBlockObject() {

        this.armorStandArrayList = new ArrayList<>();

    }

    public ArrayList<ArmorStand> getArmorStandArrayList() {
        return armorStandArrayList;
    }

    public void setArmorStandArrayList(ArrayList<ArmorStand> armorStandArrayList) {
        this.armorStandArrayList = armorStandArrayList;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
