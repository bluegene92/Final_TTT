

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Cell;
import model.GameState;
import view.UserInterface;

public class CellListener implements ActionListener {

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        Object source = e.getSource();
        Cell c = (Cell) source;
        
        if ( GameManager.gameMode == GameState.HVA_MODE && 
            GameManager.playerTurn == GameState.X_PLAYER) {
  
                c.setText(GameState.X_PLAYER);
                c.setEnabled(false);

                
                /**
                 * Find the best position to take, using minimax or alphaBetaPruning
                 */
                if (!GameManager.isGameOver()) {
                    GameManager.ui.statusBar.setText("O's turn");
                    //GameManager.ai.findBestMoveMiniMax(UserInterface.board, GameState.O_PLAYER, 0);
                    GameManager.ai.findBestMoveAlphaBeta(UserInterface.board, GameState.O_PLAYER, 0);
                    int bestMove = GameManager.ai.bestPosition;
                    GameManager.board.selectCell(bestMove, GameState.O_PLAYER);
                    System.out.println("iteration: " + GameManager.ai.iteration);
                    System.out.println("Make move at : " + bestMove);
                    GameManager.ai.iteration  = 0; // Reset
                    GameManager.ui.statusBar.setText("X's turn");
                }
                
                
                if (GameManager.checkWinner(GameState.X_PLAYER)) {
                    System.out.println("X win");
                    GameManager.gameEnd();
                    GameManager.ui.statusBar.setText("X Win!!!");
                } else if (GameManager.checkWinner(GameState.O_PLAYER)) {
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
