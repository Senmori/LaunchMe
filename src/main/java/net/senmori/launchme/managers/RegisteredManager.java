package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.registries.IRegistry;
import net.senmori.launchme.registries.RegistryManager;
import org.bukkit.Keyed;

public class RegisteredManager<V extends Keyed> extends AbstractManager implements IRegistered {

    private Class<? extends Keyed> type;
    private IRegistry<V> registry;

    protected RegisteredManager(LaunchMe plugin, Class<V> type) {
        super( plugin );
        this.type = type;
        this.registry = RegistryManager.ACTIVE.getRegistry( type );
    }

    @Override
    public IRegistry<V> getRegistry() {
        return registry;
    }
}
