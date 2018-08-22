package net.senmori.launchme.util;

import net.senmori.launchme.LaunchMe;
import org.apiguardian.api.API;
import org.bukkit.NamespacedKey;

@API( status = API.Status.INTERNAL )
public class GameData {

    @SuppressWarnings( "deprecation" )
    public static NamespacedKey checkKey(String key) {
        String[] split = new String[] { LaunchMe.getDefaultKey().getNamespace(), key};
        int i = key.indexOf(':'); // 58
        if (i >= 0) {
            split[1] = key.substring(i + 1, key.length());

            if (i > 1) {
                split[0] = key.substring(0, i);
            }
        }
        return new NamespacedKey( split[0], split[1] );
    }
}
