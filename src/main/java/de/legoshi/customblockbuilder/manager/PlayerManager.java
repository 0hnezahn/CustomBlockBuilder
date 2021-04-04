package de.legoshi.customblockbuilder.manager;

import de.legoshi.customblockbuilder.Main;
import de.legoshi.customblockbuilder.utils.PlayerObject;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerManager {

    HashMap<Player, PlayerObject> playerPlayerObjectHashMap;

    public PlayerManager() {
        this.playerPlayerObjectHashMap = new HashMap<>();
    }

    public HashMap<Player, PlayerObject> getPlayerPlayerObjectHashMap() {
        return playerPlayerObjectHashMap;
    }

    public void loadPlayer(Player player) {

       PlayerManager pm = Main.getInstance().playerManager;
       pm.getPlayerPlayerObjectHashMap().put(player, new PlayerObject());


    }

}
