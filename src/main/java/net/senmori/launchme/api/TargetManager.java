package net.senmori.launchme.api;

import net.senmori.launchme.targets.Target;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

public interface TargetManager {

    Target getTarget(NamespacedKey key);

    Target getTarget(Location location);

    void registerTarget(Target target);
}
