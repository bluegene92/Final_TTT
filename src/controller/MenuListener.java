
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameState;
import view.Menu;
import view.UserInterface;


public class MenuListener implements ActionListener {

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        Object source = e.getSource();
        
        if (source == Menu.hvaButton) {
            
            
            /**
             * Change the display to HVA
             */
            System.out.println("Player Human vs AI");
            GameManager.gameMode = GameState.HVA_MODE;
            Main.userInterface.dispose();
            Main.hva.displayHVA();
            Main.hva.setVisible(true);
            Main.gameManager.ui = Main.hva;
            
        } else if (source == Menu.avaButton) {
            
            
            /**
             * Change the display to AVA
             */
            System.out.println("Player AI vs AI");
            GameManager.gameMode = GameState.AVA_MODE;
            Main.userInterface.dispose();
            Main.ava.displayAVA();
            Main.ava.setVisible(true);
            Main.gameManager.ui = Main.ava;
            
        } else if (source == Menu.startHVAGameButton) {
            
            
            /**
             * Start HVA game
             */
            System.out.println("start the game");
            UserInterface.board.enable();
            UserInterface.menu.startHVAGameButton.setEnabled(false);
            UserInterface.statusBar.setText("User: X's turn");
            
            
            
        } else if (source == Menu.startAVAGameButton) {
            // To be determine
            
            
            
        } else if (source == Menu.playAgainButton) {
            
            
            /**
             * Play the game again.
             */
            System.out.println("play again");
            if (GameManager.gameMode == GameState.HVA_MODE) {
                Menu.startHVAGameButton.setEnabled(false);
            } else if (GameManager.gameMode == GameState.AVA_MODE) {
                Menu.startAVAGameButton.setEnabled(false);
            }

            Menu.playAgainButton.setEnabled(false);
            GameManager.board.clearBoard();
            GameManager.ui.statusBar.setText("Play again: X's turn");
            
        } // End if
        
        
    } // End actionPerformed()
    
    
} // End class MenuListener
