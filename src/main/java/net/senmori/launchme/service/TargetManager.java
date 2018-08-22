package net.senmori.launchme.service;

import net.senmori.launchme.targets.Target;
import org.bukkit.NamespacedKey;

public interface TargetManager {

    Target getTarget(NamespacedKey key);

    boolean registerTarget(Target target);
}
