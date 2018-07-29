package net.senmori.launchme.targets;

import org.bukkit.Location;

/**
 * Represents a {@link Target} that is invalid, or otherwise doesn't exist.
 */
public final class EmptyTarget extends Target {
    private static Location EMPTY_LOCATION = new Location( null, Double.NaN, Double.NaN, Double.NaN, Float.NaN, Float.NaN );

    @Override
    public String getName() {
        return "null";
    }

    @Override
    public Location getLocation() {
        return EMPTY_LOCATION;
    }

    @Override
    public boolean isValid() {
        return false;
    }
}
