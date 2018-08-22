package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.TargetManager;
import net.senmori.launchme.registries.IRegistry;
import net.senmori.launchme.registries.RegistryManager;
import net.senmori.launchme.api.Target;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

public class DefaultTargetManager extends AbstractManager implements TargetManager {

    private final IRegistry<Target> targetRegistry = RegistryManager.ACTIVE.getRegistry( Target.class );

    protected DefaultTargetManager(LaunchMe plugin) {
        super( plugin );
    }

    @Override
    public Target getTarget(NamespacedKey key) {
        return targetRegistry.getValue( key );
    }

    @Override
    public Target getTarget(Location location) {
        return targetRegistry.getValue( location );
    }

    @Override
    public void registerTarget(Target target) {
        targetRegistry.register( target );
    }
}
