package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.manager.TargetManager;
import net.senmori.launchme.api.Target;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

import java.util.Collection;
import java.util.Collections;

public class TargetManagerImpl extends RegisteredManager<Target> implements TargetManager {

    protected TargetManagerImpl(LaunchMe plugin) {
        super( plugin, Target.class );
    }

    @Override
    public Target getTarget(NamespacedKey key) {
        return getRegistry().getValue( key );
    }

    @Override
    public Target getTarget(Location location) {
        return getRegistry().getValue( location );
    }

    @Override
    public void registerTarget(Target target) {
        getRegistry().register( target );
    }

    @Override
    public Collection<Target> getRegisteredTargets() {
        return Collections.unmodifiableCollection(getRegistry().getValues());
    }
}
