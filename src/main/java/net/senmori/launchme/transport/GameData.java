package net.senmori.launchme.transport;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.registries.RegistryBuilder;
import org.apiguardian.api.API;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;

@API(status = API.Status.INTERNAL)
@SuppressWarnings("deprecation")
public class GameData {
    public static final NamespacedKey TARGETS = LaunchMe.createKey( "targets" );
    public static final NamespacedKey TRANSPORTS = LaunchMe.createKey( "transports" );
    public static final NamespacedKey TRANSPORT_METHODS = LaunchMe.createKey( "methods" );
    public static final NamespacedKey TRANSPORT_TYPES = LaunchMe.createKey( "types" );
    public static final NamespacedKey TRANSPORT_OPTIONS = LaunchMe.createKey( "options" );

    @SuppressWarnings("deprecation")
    public static NamespacedKey checkKey(String key) {
        String[] split = new String[]{ LaunchMe.getDefaultKey().getNamespace(), key };
        int i = key.indexOf( ':' ); // 58
        if ( i >= 0 ) {
            split[ 1 ] = key.substring( i + 1, key.length() );

            if ( i > 1 ) {
                split[ 0 ] = key.substring( 0, i );
            }
        }
        return new NamespacedKey( split[ 0 ], split[ 1 ] );
    }

    public static <V extends Keyed> RegistryBuilder<V> makeRegistry(org.bukkit.plugin.Plugin owner, NamespacedKey key, Class<V> type) {
        return new RegistryBuilder<>(owner, key, type);
    }
}
