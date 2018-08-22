package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;

public abstract class AbstractManager {
    private final LaunchMe plugin;

    protected AbstractManager(LaunchMe plugin) {
        this.plugin = plugin;
    }

    public LaunchMe getPlugin() {
        return plugin;
    }
}
