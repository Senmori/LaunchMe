package net.senmori.launchme.api.manager;

import net.senmori.launchme.api.Target;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

import java.util.Collection;

public interface TargetManager {

    Target getTarget(NamespacedKey key);

    Target getTarget(Location location);

    void registerTarget(Target target);

    Collection<Target> getRegisteredTargets();
}
