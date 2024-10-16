package host.plas.justcompasses.events;

import host.plas.justcompasses.JustCompasses;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class BukkitListener implements Listener {
    public BukkitListener() {
        Bukkit.getPluginManager().registerEvents(this, JustCompasses.getInstance());
        JustCompasses.getInstance().logInfo("Registered MainListener!");
    }
}
