package net.senmori.launchme.transport.types;

import net.senmori.launchme.api.Target;
import net.senmori.launchme.api.Transport;
import net.senmori.launchme.api.TransportMethod;
import net.senmori.launchme.api.TransportOptions;
import net.senmori.launchme.api.TransportType;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;

public class BasicTransport implements Transport {

    private final NamespacedKey key;
    private final TransportType type;
    private final TransportOptions options;
    private final TransportMethod method;
    private final Location location;
    private Target target;

    public BasicTransport(NamespacedKey key, TransportType type, Location location) {
        this.key = key;
        this.type = type;
        this.options = type.getTransportOptions();
        this.method = type.getTransportMethod();
        this.location = location;
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @Override
    public TransportType getTransportType() {
        return type;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public TransportOptions getOptions() {
        return options;
    }

    @Override
    public Target getTarget() {
        return target;
    }

    @Override
    public void setTarget(Target target) {
        this.target = target;
    }

    @Override
    public boolean canActivate(LivingEntity entity) {
        return options.canTransport( entity );
    }

    @Override
    public void activate(LivingEntity entity) {
        method.transport( entity, this );
    }
}
