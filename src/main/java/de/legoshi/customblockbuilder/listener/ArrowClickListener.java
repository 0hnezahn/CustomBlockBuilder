package de.legoshi.customblockbuilder.listener;

import de.legoshi.customblockbuilder.Main;
import de.legoshi.customblockbuilder.commands.Blockcreate;
import de.legoshi.customblockbuilder.manager.CustomBlockManager;
import de.legoshi.customblockbuilder.utils.CustomBlockObject;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class ArrowClickListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {

        Player p = (Player) e.getPlayer();
        Action a = e.getAction();

        if (e.hasItem()) {

            CustomBlockManager cbm = Main.getInstance().customBlockManager;

            //for Item Arrow
            if (e.getItem().getType().equals(Material.ARROW)) {

                if ((Action.RIGHT_CLICK_AIR == a)) {

                    if (cbm.getCustomBlockManagerHashMap().get(p).size() > 0) {

                        int num = cbm.getCustomBlockManagerHashMap().get(p).size() - 1;
                        CustomBlockObject customBlockObject = cbm.getCustomBlockManagerHashMap().get(p).get(num);

                        for (ArmorStand armorStand : customBlockObject.getArmorStandArrayList()) {

                            armorStand.remove();

                        }

                        cbm.getCustomBlockManagerHashMap().get(p).get(num).getBoat().remove();
                        cbm.getCustomBlockManagerHashMap().get(p).remove(num);
                        p.sendMessage("Deleted last block");

                    } else {

                        p.sendMessage("No Blocks to delete");

                    }

                }

            }

            if (e.getItem().getType().equals(Material.REDSTONE)) {

                double amount = Main.getInstance().playerManager.getPlayerPlayerObjectHashMap().get(p).getAmount();

                if (cbm.getCustomBlockManagerHashMap().get(p).size() > 0) {

                    int num = cbm.getCustomBlockManagerHashMap().get(p).size() - 1;
                    CustomBlockObject customBlockObject = cbm.getCustomBlockManagerHashMap().get(p).get(num);

                    //remove every entity from server
                    for (ArmorStand armorStand : customBlockObject.getArmorStandArrayList()) {

                        armorStand.remove();

                    }
                    cbm.getCustomBlockManagerHashMap().get(p).get(num).getBoat().remove();

                    //create new entity at shifted spot
                    CustomBlockObject cbo = cbm.getCustomBlockManagerHashMap().get(p).get(num);

                    Location l = cbo.getLocation();

                    double x1 = l.getX();
                    double y1 = l.getY();
                    double z1 = l.getZ();

                    if (p.isSneaking()) {

                        if(a == Action.RIGHT_CLICK_AIR) {
                            y1 = y1 + amount;
                        } else if (a == Action.LEFT_CLICK_AIR) {
                            y1 = y1 - amount;
                        }

                    } else {

                        if (facingCheck(p.getLocation().getYaw()).equals("+x"))
                            x1 = x1 + amount;
                        if (facingCheck(p.getLocation().getYaw()).equals("+z"))
                            z1 = z1 + amount;
                        if (facingCheck(p.getLocation().getYaw()).equals("-x"))
                            x1 = x1 - amount;
                        if (facingCheck(p.getLocation().getYaw()).equals("-z"))
                            z1 = z1 - amount;

                    }

                    cbm.getCustomBlockManagerHashMap().get(p).remove(num);

                    cbo = Main.getInstance().blockcreate.createBlock(p, x1, y1, z1);
                    cbm.getCustomBlockManagerHashMap().get(p).add(num, cbo);

                    p.sendMessage("Moved last block");

                } else {

                    p.sendMessage("No Blocks to move");

                }


            }
        }

    }


    public String facingCheck(double facing) {

        if ((facing < 0.0 && facing > -45.0) || (facing < -315.0 && facing > -360.0)
            || (facing > 315.0 && facing < 360.0) || (facing > 0.0 && facing < 45.0)) {

            return "+z";

        } else if ((facing > 45.0 && facing < 135.0) || (facing > -315.0 && facing < -225.0)) {

            return "-x";

        } else if ((facing > -225.0 && facing < -135.0) || (facing > 135.0 && facing < 225.0)) {

            return "-z";

        } else if ((facing > 225.0 && facing < 315.0) || (facing > -135.0 && facing < -45.0)) {

            return "+x";
        }

        return "err";

    }

}
