package de.legoshi.customblockbuilder;

import de.legoshi.customblockbuilder.commands.BlockShiftCommand;
import de.legoshi.customblockbuilder.commands.Blockcreate;
import de.legoshi.customblockbuilder.listener.*;
import de.legoshi.customblockbuilder.manager.CustomBlockManager;
import de.legoshi.customblockbuilder.manager.PlayerManager;
import de.legoshi.customblockbuilder.utils.CustomBlockObject;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main instance;
    public CustomBlockObject customBlockObject;
    public CustomBlockManager customBlockManager;
    public Blockcreate blockcreate;
    public PlayerManager playerManager;

    @Override
    public void onEnable() {

        instance = this;

        customBlockObject = new CustomBlockObject();
        customBlockManager = new CustomBlockManager();
        blockcreate = new Blockcreate();
        playerManager = new PlayerManager();

        commandRegistration();
        listenerRegistration();

        reload();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void listenerRegistration() {

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BlockBreakListener(), this);
        pm.registerEvents(new BlockPlaceListener(), this);
        pm.registerEvents(new ArrowClickListener(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new RemoveBoatCollision(), this);
        pm.registerEvents(new VehicleEnter(), this);

    }

    public void reload() {

        for(Player all : Bukkit.getOnlinePlayers()) {

            customBlockManager.loadPlayers(all);
            playerManager.loadPlayer(all);

        }

    }

    private void commandRegistration() {

        getCommand("create").setExecutor(new Blockcreate());
        getCommand("m").setExecutor(new BlockShiftCommand());

    }

    public static Main getInstance() {

        return instance;

    }

}
