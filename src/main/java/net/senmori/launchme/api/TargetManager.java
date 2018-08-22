package net.senmori.launchme.api;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;

public interface TargetManager {

    Target getTarget(NamespacedKey key);

    Target getTarget(Location location);

    void registerTarget(Target target);
}
