
package controller;
import model.GameState;
import view.Board;
import view.Menu;
import view.UserInterface;


public class GameManager {
    

    public static int gameMode;
    public static Board board;
    public static String result;
    public static UserInterface ui;
    
    /**
     * X will always be the first player.
     * 0 - X turn
     * 1 - O turn
     */
    public static String playerTurn = GameState.X_PLAYER;
    
    
    public static AI ai;


    public GameManager() {
        ai = new AI();
    }
    
    
    
    public static boolean isGameOver() {
        board = UserInterface.board;
        return checkWinner("X") || checkWinner("O") || board.isBoardEmpty();
    }
    
    
    /**
     * Invoke when game is finish, which will
     * disable the board, and enable the "play again"
     * button back on.
     */
    public static void gameEnd() {
        UserInterface.board.disable();
        Menu.playAgainButton.setEnabled(true);
    }
    
    
    
    /**
     * Check if the player won the game. If the player
     * win, return true, otherwise return false.
     * 
     * @param player The player to be evaluated.
     * @return boolean Return true if the player win.
     */
    public static boolean checkWinner(String player) {
        if (board.checkWinCondition(0, 1, 2) && // Top row
            board.cells[0].getText().equalsIgnoreCase(player)) {
            return true;
        } else if (board.checkWinCondition(3, 4, 5) && // Middle row
                   board.cells[3].getText().equalsIgnoreCase(player)) {
            return true;
        } else if (board.checkWinCondition(6, 7, 8) && // Bottom row
                   board.cells[6].getText().equalsIgnoreCase(player)) {
            return true;
        } else if (board.checkWinCondition(0, 3, 6) && // Left column
                   board.cells[0].getText().equalsIgnoreCase(player)) {
            return true;
        } else if ((board.checkWinCondition(1, 4, 7) && // Middle column
                board.cells[1].getText().equalsIgnoreCase(player))) {
            return true;
        } else if ((board.checkWinCondition(2, 5, 8) && // Right column 
                board.cells[2].getText().equalsIgnoreCase(player))) {
            return true;
        } else if ((board.checkWinCondition(0, 4, 8) && // Backward diagonal
                board.cells[0].getText().equalsIgnoreCase(player))) {
            return true;
        } else if ((board.checkWinCondition(2, 4, 6) && // Forward diagonal 
                board.cells[2].getText().equalsIgnoreCase(player))) {
            return true;
        }
        return false;
    } // End checkWinner()
    
    
} // End class GameManager
