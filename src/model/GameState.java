
package model;
import java.time.Duration;
import view.Board;


public class GameState {
    
    /**
     * X player always go first.
     */
    public static String PLAYER_TURN;
    
    
    /**
     * Game result
     */
    public static final int GAME_DONE = 10;
    public static final int GAME_DRAW = 11;
    public static final int X_WIN = 12;
    public static final int O_WIN = 13;
    
    
    /**
     * Match mode
     */
    public static final int MENU_MODE = 20;
    public static final int HVA_MODE = 21;
    public static final int AVA_MODE = 22;
    public static final int DEATH_MATCH = 23;
    public static Board board;
    
    
    public static Duration thresholdTime;
    
} // End class GameState
