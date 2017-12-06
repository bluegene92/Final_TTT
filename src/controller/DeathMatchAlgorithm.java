package controller;
import controller.GameManager;
import controller.Main;
import java.util.ArrayList;
import model.Algorithm;
import model.Cell;
import model.Player;
import view.Board;


public class DeathMatchAlgorithm implements Algorithm {
    public int bestCounter = 0;
    
    @Override
    public int runAlgorithm() {
        findBestMoveDeathMatch(Main.gameManager.board, GameManager.mainPlayer, 0);
        return bestCounter;
    }
    
    public void findBestMoveDeathMatch(Board board, String player, int depth) {
        deathMatch(board, player, depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public int deathMatch(Board board, String player, int depth, int alpha, int beta) {
        ArrayList<Cell> adjacentList = board.getAdjacentList(player);
        if (Main.gameManager.board.checkCounterRow(Player.X)) {
            return 10;
        } else if (Main.gameManager.board.checkCounterRow(Player.O)) {
            return -10;
        } 
        
        if (player.equalsIgnoreCase(Player.X)) {
            for (int i = 0; i < adjacentList.size(); i++) {
                if (adjacentList.size() > 1 && adjacentList.get(i).position == 4) {
                    continue;
                }
                int oldPosition = adjacentList.get(i).position;
                int newPosition = Main.gameManager.board.slideCell(oldPosition, Player.X);
                System.out.println("Old: " + oldPosition);
                System.out.println("New: " + newPosition);
                System.out.println("move player X from " + oldPosition + " to " + newPosition);
                int score = deathMatch(board, Player.O, depth+1, alpha, beta);
                Main.gameManager.board.undoMove(newPosition);
                Main.gameManager.board.selectCell(oldPosition, Player.X);

                if (score > alpha) {
                    alpha = score;
                    if (depth == 0) {
                        bestCounter = oldPosition;
                    }
                }

                if (beta <= alpha) {
                    return alpha;
                }
            } // End for  
            return alpha;
        } else { 
            for (int i = 0; i < adjacentList.size(); i++) {
                if (adjacentList.size() > 1 && adjacentList.get(i).position == 4) {
                    continue;
                }
                int oldPosition = adjacentList.get(i).position;
                int newPosition = Main.gameManager.board.slideCell(oldPosition, Player.X);
                System.out.println("Old: " + oldPosition);
                System.out.println("New: " + newPosition);
                System.out.println("move player O from " + oldPosition + " to " + newPosition);
                int score = deathMatch(board, Player.X, depth+1, alpha, beta);
                Main.gameManager.board.undoMove(newPosition);
                Main.gameManager.board.selectCell(oldPosition, Player.O);
                if (score < beta) {
                    beta = score;
                    if (depth == 0)
                        bestCounter = oldPosition;
                } else if (beta <= alpha) {
                    return beta;
                }
            } // End for  
            return beta;
        } // End if-else
    } // End deathmatch
} 
