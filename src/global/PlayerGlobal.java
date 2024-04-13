package global;

import creatures.Player;
import exceptions.NotInitialisedException;

public class PlayerGlobal {
    private static Player player;

    public static void init(Player player) {
        PlayerGlobal.player = player;
    }

    public static Player getPlayer() throws NotInitialisedException {
        if (PlayerGlobal.player == null) {
            throw new NotInitialisedException("Global player instance is not initialised");
        }
        return PlayerGlobal.player;
    }
}
