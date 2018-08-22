package net.senmori.launchme.targets;

import net.senmori.launchme.api.Target;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

/**
 * Represents a {@link Target} that is invalid, or otherwise doesn't exist.
 */
public final class EmptyTarget implements Target {

    @Override
    public NamespacedKey getKey() {
        return null;
    }

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public boolean isValid() {
        return false;
    }
}
