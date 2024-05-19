package cardAdventure.global;

import cardAdventure.creatures.Player;
import cardAdventure.exceptions.NotInitialisedException;

/**
* Class to gold a global instance of Player.
*/
public class PlayerGlobal {
    private static Player player;

    /**
    * initialise the global instance of Player.
    * @param player instance of Player ti initialise the global instance of Player with
    */
    public static void init(Player player) {
        PlayerGlobal.player = player;
    }

    /**
    * Get the global instance of Player.
    * @return Player, the global instance of Player
    */
    public static Player getPlayer() throws NotInitialisedException {
        if (PlayerGlobal.player == null) {
            throw new NotInitialisedException("Global player instance is not initialised");
        }
        return PlayerGlobal.player;
    }
}
