package net.senmori.launchme.targets.impl;

import net.senmori.launchme.targets.Target;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class BasicTarget implements Target {

    private final NamespacedKey name;
    private final Location location;

    public BasicTarget(@NotNull NamespacedKey name, @NotNull Location location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public NamespacedKey getKey() {
        return name;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}
