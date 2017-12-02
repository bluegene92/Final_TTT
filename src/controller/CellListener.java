package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Cell;
import model.Player;
import view.HVAMenu;

public class CellListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Cell c = (Cell) source;
        if (Main.gameManager.playerTurn.equalsIgnoreCase(Player.O)){ // Player O turn
            Main.gameManager.board.selectCell(c.position, Player.O);
            Main.gameManager.updatePlayerTurn();
            Main.gameManager.myState.doAction(Main.gameManager);
        }
        
//        if (Main.gameManager.gameMode == GameState.HVA_MODE 
//            && Main.gameManager.playerTurn == Player.X) {
//                Main.gameManager.playerTurn = Player.O;    
//                Main.gameManager.board.selectCell(c.position, Player.X);
//                Main.gameManager.timeTick = Main.gameManager.timeInSeconds;   
//                Main.gameManager.ai.makeMove();
//                Main.gameManager.checkForWinner();
//        }
        
        
        

    } // End actionPerformed()
    
    
    
} // End class CellListener
