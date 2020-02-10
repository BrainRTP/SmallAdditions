package si.zbe.smalladd.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ArmorEvent implements Listener {
    @EventHandler
    public void onArmorClick(PlayerInteractEvent e) {
        if (!e.getPlayer().hasPermission("smalladd.tool.armor"))
            return;

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player p = e.getPlayer();
            ItemStack hand = p.getInventory().getItemInMainHand();
            hand.setItemMeta(hand.getItemMeta());

            if (isHelmet(hand.getType())) {
                if (p.getInventory().getHelmet() != null) {
                    ItemStack helmet = p.getInventory().getHelmet();
                    helmet.setItemMeta(helmet.getItemMeta());

                    p.getInventory().setHelmet(hand);
                    p.getInventory().setItemInMainHand(helmet);
                }
            } else if (isChestplate(hand.getType())) {
                if (p.getInventory().getChestplate() != null) {
                    ItemStack chestplate = p.getInventory().getChestplate();
                    chestplate.setItemMeta(chestplate.getItemMeta());

                    p.getInventory().setChestplate(hand);
                    p.getInventory().setItemInMainHand(chestplate);
                }
            } else if (isLeggings(hand.getType())) {
                if (p.getInventory().getLeggings() != null) {
                    ItemStack leggings = p.getInventory().getLeggings();
                    leggings.setItemMeta(leggings.getItemMeta());

                    p.getInventory().setLeggings(hand);
                    p.getInventory().setItemInMainHand(leggings);
                }
            } else if (isBoots(hand.getType())) {
                if (p.getInventory().getBoots() != null) {
                    ItemStack boots = p.getInventory().getBoots();
                    boots.setItemMeta(boots.getItemMeta());

                    p.getInventory().setBoots(hand);
                    p.getInventory().setItemInMainHand(boots);
                }
            }
        }
    }

    boolean isHelmet(Material m) {
        return m == Material.LEATHER_HELMET || m == Material.IRON_HELMET || m == Material.CHAINMAIL_HELMET || m == Material.GOLDEN_HELMET || m == Material.DIAMOND_HELMET;
    }

    boolean isChestplate(Material m) {
        return m == Material.LEATHER_CHESTPLATE || m == Material.IRON_CHESTPLATE || m == Material.CHAINMAIL_CHESTPLATE || m == Material.GOLDEN_CHESTPLATE || m == Material.DIAMOND_CHESTPLATE;
    }

    boolean isLeggings(Material m) {
        return m == Material.LEATHER_LEGGINGS || m == Material.IRON_LEGGINGS || m == Material.CHAINMAIL_LEGGINGS || m == Material.GOLDEN_LEGGINGS || m == Material.DIAMOND_LEGGINGS;
    }

    boolean isBoots(Material m) {
        return m == Material.LEATHER_BOOTS || m == Material.IRON_BOOTS || m == Material.CHAINMAIL_BOOTS || m == Material.GOLDEN_BOOTS || m == Material.DIAMOND_BOOTS;
    }
}
