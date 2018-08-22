package net.senmori.launchme.targets.impl;

import net.senmori.launchme.targets.Target;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

public class BasicTarget implements Target {

    private final NamespacedKey name;
    private final Location location;
    public BasicTarget(NamespacedKey name, Location location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public NamespacedKey getName() {
        return name;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}
