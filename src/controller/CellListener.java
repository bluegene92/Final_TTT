
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cell;
import model.GameState;
import model.Player;

public class CellListener implements ActionListener {

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        Object source = e.getSource();
        Cell c = (Cell) source;
        
        if ( GameManager.gameMode == GameState.HVA_MODE && 
            GameManager.playerTurn == Player.X) {
  
                c.setText(Player.X);
                c.setEnabled(false);
                GameManager.timeTick = GameManager.timeInSeconds;
                GameManager.playerTurn = Player.O;    
                
                
                /**
                 * Find the best position to take, using minimax or alphaBetaPruning
                 */
                if (!GameManager.isGameOver()) {
                    GameManager.ui.statusBar.setText("O's turn");
                    //GameManager.ai.findBestMoveMiniMax(UserInterface.board, Player.O, 0);
                    GameManager.ai.findBestMoveAlphaBeta(GameManager.board, Player.O, 0);
                    int bestMove = GameManager.ai.bestPosition;
    
                    GameManager.board.selectCell(bestMove, Player.O);
                    System.out.println("iteration: " + GameManager.ai.iteration);
                    System.out.println("Make move at : " + bestMove);
                    GameManager.ai.iteration  = 0; // Reset
                    GameManager.ui.statusBar.setText("X's turn");
                    GameManager.playerTurn = Player.X;  
                }
                
                
                if (GameManager.checkWinner(Player.X)) {
                    System.out.println("X win");
                    GameManager.gameEnd();
                    GameManager.ui.statusBar.setText("X Win!!!");
                } else if (GameManager.checkWinner(Player.O)) {
                    System.out.println("O win");
                    GameManager.gameEnd();
                    GameManager.ui.statusBar.setText("O Win!!!");
                } else if (GameManager.board.isBoardEmpty()){
                    System.out.println("DRAW");
                    GameManager.gameEnd();
                    GameManager.ui.statusBar.setText("Draw!!!");
                }
        } else if (GameManager.gameMode == GameState.AVA_MODE) {

            /**
             ************** TBD **********************
             * Do something in AI vs. AI mode
             */
            
            
            
            
            
        }
        
        
        

    } // End actionPerformed()
    
    
} // End class CellListener
