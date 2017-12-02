package controller;

import controller.GameManager;
import java.util.ArrayList;
import model.Algorithm;
import model.Cell;
import model.Player;
import view.Board;

public class Minimax implements Algorithm {

    public int bestPosition = 0;
    
    @Override
    public int runAlgorithm() {
        findBestMoveMiniMax(Main.gameManager.board, Player.O, 0);
        return bestPosition;
    }

    public int findBestMoveMiniMax(Board board, String player, int depth) {
        return minimax(board, player, depth);
    }
    
    public int minimax(Board board, String player, int depth) {
        ArrayList<Cell> availableCells = board.getAvailableCells();
        
        
        /**
         * Check terminal state and evaluated score.
         * If X player win, return 1. If O player win,
         * return -1. If it's a draw, return 0.
         */
        if (Main.gameManager.board.checkCounterRow(Player.X)) {
            return 1;
        } else if (Main.gameManager.board.checkCounterRow(Player.O)) {
            return -1;
        } else if (availableCells.isEmpty()) {
            return 0;
        }
        
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        
        for (int i = 0; i < availableCells.size(); ++i) {
            int position = availableCells.get(i).position;
            if (player.equalsIgnoreCase(Player.O)) {
                Main.gameManager.board.selectCell(position, Player.O);
                System.out.println("Place O in position: " + position + " depth = " + depth);
                int currentScore = minimax(board, Player.X, depth+1);
                min = Math.min(currentScore, min);
                
                
                if (depth == 0) {
                    System.out.println(currentScore);
                }
                
                
                if (currentScore <= 0) {
                    if (depth == 0) {
                        bestPosition = position;
                    }
                }
                
                if (currentScore == -1) {
                    Main.gameManager.board.undoMove(position);
                    break;
                }
                
                /**
                 * Check before the last move complete, if the
                 * last move guarantee O will win, then game ends.
                 * 
                 * if (i == availableCells.size() -1 && min > 0) {
                        if (depth == 0) {
                            bestPosition = position;
                        }
                    }
                 */
            } else {
                Main.gameManager.board.selectCell(position, Player.X);
                int currentScore = minimax(board, Player.O, depth+1);
                max = Math.max(currentScore, max);
                
                if (max == 1) {
                    Main.gameManager.board.undoMove(position);
                    break;
                }
                
            } // End if-else check player X or player O
            
            // Undo move
            Main.gameManager.board.undoMove(position);
            
        } // End for
        return player.equalsIgnoreCase(Player.X) ? max : min;
    } // End minimax
}
