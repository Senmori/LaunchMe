package net.senmori.launchme.targets;

import org.bukkit.Location;

public class BasicTarget extends Target{

    private final String name;
    private final Location location;
    public BasicTarget(String name, Location location) {
        super();
        this.name = name;
        this.location = location;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}
