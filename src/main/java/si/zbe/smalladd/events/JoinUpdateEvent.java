package si.zbe.smalladd.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import si.zbe.smalladd.Main;
import si.zbe.smalladd.Messages;
import si.zbe.smalladd.UpdateChecker;

public class JoinUpdateEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!e.getPlayer().hasPermission("smalladd.admin"))
            return;

        if (!Main.plugin.getConfig().getBoolean("UpdateNotification"))
            return;

        (new UpdateChecker(Main.plugin, 74452)).getVersion(version -> {
            if (!Main.plugin.getDescription().getVersion().equalsIgnoreCase(version)) {
                e.getPlayer().sendMessage(ChatColor.GREEN + "[SmallAdditions] " + Messages.getString("SA.UpdateFound"));
                e.getPlayer().sendMessage(ChatColor.GREEN + "                 " + ChatColor.RED + Main.plugin.getDescription().getVersion() + ChatColor.WHITE
                        + " -> " + ChatColor.GREEN + version);
                e.getPlayer().sendMessage(ChatColor.AQUA + "https://www.spigotmc.org/resources/smalladditions.74452/");
            }
        });
    }
}
