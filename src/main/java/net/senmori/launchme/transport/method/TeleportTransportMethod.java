package net.senmori.launchme.transport.method;

import net.senmori.launchme.transport.Transport;
import net.senmori.launchme.transport.TransportMethod;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportTransportMethod implements TransportMethod {
    @Override
    public void transport(LivingEntity entity, Transport transport) {
        if ( isValid( transport ) ) {
            entity.teleport( transport.getLocation(), PlayerTeleportEvent.TeleportCause.PLUGIN );
        }
    }


}
