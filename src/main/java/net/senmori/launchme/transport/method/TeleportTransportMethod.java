package net.senmori.launchme.transport.method;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.Transport;
import net.senmori.launchme.api.TransportMethod;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportTransportMethod implements TransportMethod {
    private static final NamespacedKey key = LaunchMe.createKey( "teleport" );

    @Override
    public void transport(LivingEntity entity, Transport transport) {
        if ( isValid( transport ) ) {
            entity.teleport( transport.getLocation(), PlayerTeleportEvent.TeleportCause.PLUGIN );
        }
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }
}
