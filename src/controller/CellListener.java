package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Cell;
import model.GameState;
import model.Player;

public class CellListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Cell c = (Cell) source;
        
        if ( GameManager.gameMode == GameState.HVA_MODE 
            && GameManager.playerTurn == Player.X) {
                GameManager.playerTurn = Player.O;    
                GameManager.board.selectCell(c.position, Player.X);
                GameManager.timeTick = GameManager.timeInSeconds;   
                GameManager.ai.makeMove();
                GameManager.checkForWinner();
        } else if (GameManager.gameMode == GameState.AVA_MODE) {

            /**
             ************** TBD **********************
             * Do something in AI vs. AI mode
             */
            
            
            
            
            
        }
        
        
        

    } // End actionPerformed()
    
    
    
} // End class CellListener
