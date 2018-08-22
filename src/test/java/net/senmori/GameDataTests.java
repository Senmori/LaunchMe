package net.senmori;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.transport.GameData;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameDataTests {

    @ParameterizedTest
    @MethodSource("checkKey")
    @DisplayName( "Test GameData#checkKey conversion" )
    void testCheckKey(NamespacedKey expected, String key) {
        NamespacedKey actual = GameData.checkKey( key );
        assertEquals(expected, actual, "Invalid NamespacedKey validation");
    }

    static Stream<Arguments> checkKey() {
        return Stream.of(
                Arguments.of( LaunchMe.createKey( "test-key" ), "launchme:test-key" ),
                Arguments.of( LaunchMe.createKey("test-key"), "test-key" ),
                Arguments.of( LaunchMe.createKey("_test-key_-"), "_test-key_-" ),
                Arguments.of( LaunchMe.createKey("target-key"), "target-key" )
        );
    }


}
