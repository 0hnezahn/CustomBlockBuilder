package de.legoshi.customblockbuilder.commands;

import de.legoshi.customblockbuilder.Main;
import de.legoshi.customblockbuilder.manager.CustomBlockManager;
import de.legoshi.customblockbuilder.utils.CustomBlockObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Objects;

public class Blockcreate implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        if (!(sender.hasPermission("permission.create"))) {
            sender.sendMessage("No Perms Noob");
            return true;
        }

        Player player = ((Player) sender).getPlayer();

        if (args.length == 3) {

            CustomBlockObject cbo;
            CustomBlockManager cbm = Main.getInstance().customBlockManager;
            double x1;
            double y1;
            double z1;

            try {

                x1 = Double.parseDouble(args[0]);
                y1 = Double.parseDouble(args[1]);
                z1 = Double.parseDouble(args[2]);

            } catch(NumberFormatException ex) {

                player.sendMessage("Wrong input NOOB");
                return true;

            }

            cbo = createBlock(player, x1, y1, z1);
            cbm.getCustomBlockManagerHashMap().get(player).add(cbo);

        } else {

            player.sendMessage("/blockcreate x y z");

        }

        return false;
    }

    public CustomBlockObject createBlock(Player player, double x2, double y2, double z2) {

        ArrayList<ArmorStand> armorStandArrayList = new ArrayList<>();
        CustomBlockObject cbo = new CustomBlockObject();

        Location locationboat;
        Location locationarmorstand1;
        Location locationarmorstand2;
        Location locationarmorstand3;

        Location locationarmorstand4;
        Location locationarmorstand5;
        Location locationarmorstand6;

        Location locationarmorstand7;
        Location locationarmorstand8;
        Location locationarmorstand9;

        locationboat = new Location(player.getWorld(), x2 - 0.9875, y2 - 0.5625, z2 - 0.9875);

        locationarmorstand1 = new Location(player.getWorld(), x2 - 0.612, y2 - 2, z2 - 0.612);
        locationarmorstand2 = new Location(player.getWorld(), x2 - 1.112, y2 - 2, z2 - 0.612);
        locationarmorstand3 = new Location(player.getWorld(), x2 - 1.362, y2 - 2, z2 - 0.612);

        locationarmorstand4 = new Location(player.getWorld(), x2 - 0.612, y2 - 2, z2 - 1.112);
        locationarmorstand5 = new Location(player.getWorld(), x2 - 1.112, y2 - 2, z2 - 1.112);
        locationarmorstand6 = new Location(player.getWorld(), x2 - 1.362, y2 - 2, z2 - 1.112);

        locationarmorstand7 = new Location(player.getWorld(), x2 - 0.612, y2 - 2, z2 - 1.362);
        locationarmorstand8 = new Location(player.getWorld(), x2 - 1.112, y2 - 2, z2 - 1.362);
        locationarmorstand9 = new Location(player.getWorld(), x2 - 1.362, y2 - 2, z2 - 1.362);

        Boat boat = Objects.requireNonNull(player.getLocation().getWorld()).spawn(locationboat, Boat.class);
        ArmorStand as1 = Objects.requireNonNull(player.getLocation().getWorld()).spawn(locationarmorstand1, ArmorStand.class);
        ArmorStand as2 = Objects.requireNonNull(player.getLocation().getWorld()).spawn(locationarmorstand2, ArmorStand.class);
        ArmorStand as3 = Objects.requireNonNull(player.getLocation().getWorld()).spawn(locationarmorstand3, ArmorStand.class);

        ArmorStand as4 = Objects.requireNonNull(player.getLocation().getWorld()).spawn(locationarmorstand4, ArmorStand.class);
        ArmorStand as5 = Objects.requireNonNull(player.getLocation().getWorld()).spawn(locationarmorstand5, ArmorStand.class);
        ArmorStand as6 = Objects.requireNonNull(player.getLocation().getWorld()).spawn(locationarmorstand6, ArmorStand.class);

        ArmorStand as7 = Objects.requireNonNull(player.getLocation().getWorld()).spawn(locationarmorstand7, ArmorStand.class);
        ArmorStand as8 = Objects.requireNonNull(player.getLocation().getWorld()).spawn(locationarmorstand8, ArmorStand.class);
        ArmorStand as9 = Objects.requireNonNull(player.getLocation().getWorld()).spawn(locationarmorstand9, ArmorStand.class);
        ItemStack itemStack = new ItemStack(Material.STAINED_CLAY);

        as1.setGravity(false);
        as1.setVisible(false);
        as1.setHelmet(itemStack);

        as2.setGravity(false);
        as2.setVisible(false);
        as2.setHelmet(itemStack);

        as3.setGravity(false);
        as3.setVisible(false);
        as3.setHelmet(itemStack);

        as4.setGravity(false);
        as4.setVisible(false);
        as4.setHelmet(itemStack);

        as5.setGravity(false);
        as5.setVisible(false);
        as5.setHelmet(itemStack);

        as6.setGravity(false);
        as6.setVisible(false);
        as6.setHelmet(itemStack);

        as7.setGravity(false);
        as7.setVisible(false);
        as7.setHelmet(itemStack);

        as8.setGravity(false);
        as8.setVisible(false);
        as8.setHelmet(itemStack);

        as9.setGravity(false);
        as9.setVisible(false);
        as9.setHelmet(itemStack);

        boat.setGravity(false);

        armorStandArrayList.add(as1);
        armorStandArrayList.add(as2);
        armorStandArrayList.add(as3);
        armorStandArrayList.add(as4);
        armorStandArrayList.add(as5);
        armorStandArrayList.add(as6);
        armorStandArrayList.add(as7);
        armorStandArrayList.add(as8);
        armorStandArrayList.add(as9);

        cbo.setArmorStandArrayList(armorStandArrayList);
        cbo.setBoat(boat);

        Location l = new Location(Bukkit.getWorld(player.getLocation().getWorld().getName()), x2, y2, z2);
        cbo.setLocation(l);

        return cbo;

    }

}


