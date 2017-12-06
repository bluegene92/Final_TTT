package controller;
import java.util.ArrayList;
import model.Algorithm;
import model.Cell;
import model.Player;
import view.Board;

public class AlphaBetaPruning implements Algorithm {
    
    private int bestPosition = 0;
    public AlphaBetaPruning() {
    }
    
    @Override
    public int runAlgorithm() {
        findBestMoveAlphaBeta(Main.gameManager.board, Main.gameManager.mainPlayer, 0);
        return bestPosition;
    }
    
    public void findBestMoveAlphaBeta(Board board, String player, int depth) {
        alphaBetaPruning(board, player, depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public int alphaBetaPruning(Board board, String player, int depth, int alpha, int beta) {
        ArrayList<Cell> availableCells = board.getAvailableCells();

        if (Main.gameManager.board.checkCounterRow(Player.X)) {
            return 10;
        } else if (Main.gameManager.board.checkCounterRow(Player.O)) {
            return -10;
        } else if (availableCells.isEmpty()) {
            return 0;
        }
        
        if (player.equalsIgnoreCase(Player.X)) {
            for (int i = 0; i < availableCells.size(); i++) {
                int position = availableCells.get(i).position;
                Main.gameManager.board.selectCell(position, Player.X);
                int score = alphaBetaPruning(board, Player.O, depth+1, alpha, beta);
                Main.gameManager.board.undoMove(position);
                
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
            for (int i = 0; i < availableCells.size(); i++) {
                int position = availableCells.get(i).position;
                Main.gameManager.board.selectCell(position, Player.O);
                int score = alphaBetaPruning(board, Player.X, depth+1, alpha, beta);
                Main.gameManager.board.undoMove(position);
                
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
