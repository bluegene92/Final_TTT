package controller;

import java.util.ArrayList;

import model.Algorithm;
import model.Cell;
import model.Player;
import view.Board;

public class AlphaBetaPruning implements Algorithm {
    
    public static int bestPosition = 0;
    public int tick = 0;
    
    @Override
    public void runAlgorithm() {
        findBestMoveAlphaBeta(GameManager.board, Player.O, 0);
    }
    
    public void findBestMoveAlphaBeta(Board board, String player, int depth) {
        alphaBetaPruning(board, player, depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public int alphaBetaPruning(Board board, String player, int depth, int alpha, int beta) {
//        iteration++;
        ArrayList<Cell> availableCells = board.getAvailableCells();

        if (GameManager.checkCounterRow(Player.X)) {
            return 10;
        } else if (GameManager.checkCounterRow(Player.O)) {
            return -10;
        } else if (availableCells.isEmpty()) {
            return 0;
        }
        
        /**
         * If the player is player X
         */
        if (player.equalsIgnoreCase(Player.X)) {
            
            for (int i = 0; i < availableCells.size(); i++) {
//                iteration++;
                int position = availableCells.get(i).position;
                GameManager.board.selectCell(position, Player.X);
                int score = alphaBetaPruning(board, Player.O, depth+1, alpha, beta);
                GameManager.board.undoMove(position);
                
                if (score > alpha) {
                    alpha = score;
                    if (depth == 0)
                        bestPosition = position;
                }

                if (beta <= alpha) {
                    return alpha;
                }
            } // End for
            return alpha;
        } else {
            /**
             * If the player is O
             */
            for (int i = 0; i < availableCells.size(); i++) {
//                iteration++;
                int position = availableCells.get(i).position;
                GameManager.board.selectCell(position, Player.O);
                int score = alphaBetaPruning(board, Player.X, depth+1, alpha, beta);
                GameManager.board.undoMove(position);
                
                if (score < beta) {
                    beta = score;
                    if (depth == 0)
                        bestPosition = position;
                } else if (beta <= alpha) {
                    return beta;
                }
            } // End for
            return beta;
        } // End if-else
    } // End alphaBetaPruning    


} // End class AlphaBetaPrunning
