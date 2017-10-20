
package model;
import view.Board;


public class GameState {

    
    /**
     * Keep track of the player's turn
     */
    public static final String X_PLAYER = "X";
    public static final String O_PLAYER = "O";
    
    
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
    
    
} // End class GameState
