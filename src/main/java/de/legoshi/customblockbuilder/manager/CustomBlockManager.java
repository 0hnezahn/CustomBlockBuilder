package de.legoshi.customblockbuilder.manager;

import de.legoshi.customblockbuilder.Main;
import de.legoshi.customblockbuilder.utils.CustomBlockObject;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomBlockManager extends ArrayList<CustomBlockManager> {

    HashMap<Player, ArrayList<CustomBlockObject>> customBlockManagerHashMap;

    public CustomBlockManager() {
        this.customBlockManagerHashMap = new HashMap<>();
    }

    public HashMap<Player, ArrayList<CustomBlockObject>> getCustomBlockManagerHashMap() {
        return customBlockManagerHashMap;
    }

    public void loadPlayers(Player player) {

        CustomBlockManager customBlockManager = Main.getInstance().customBlockManager;
        customBlockManager.getCustomBlockManagerHashMap().put(player, new ArrayList<>());


    }


}
