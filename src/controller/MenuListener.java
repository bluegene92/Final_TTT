package controller;
import model.AVAMode;
import model.HVAMode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AVADeathMatchMode;
import model.Player;
import org.json.JSONException;
import view.AVAMenu;
import view.HVAMenu;
import view.MainMenu;
import static view.AVAMenu.deathMatchCheckBox;

public class MenuListener implements ActionListener {

    char remoteBoardArr[] = new char[9];
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
       
        if (source == HVAMenu.mainMenuButton || source == AVAMenu.mainMenuButton) {
            System.out.println("main  menu");
            Main.gameWindow.displayMainMenu();
        } else if (source == MainMenu.hvaButton) {
            System.out.println("Clicked hva");
            Main.gameWindow.displayHVAMenu();
            Main.gameManager.setState(new HVAMode());
            Main.gameManager.board = HVAMenu.hvaBoard;
            HVAMenu.statusBar.setText("Click <Start Game> to begin");
            System.out.println("Set game mode to: " + Main.gameManager.myState.toString());
        } else if (source == MainMenu.avaButton) {
            System.out.println("Clicked ava");
            Main.gameWindow.displayAVAMenu();
            Main.gameManager.setState(new AVAMode());
            Main.gameManager.board = AVAMenu.avaBoard;
            Main.networkManager.requestData();
            System.out.println("Set game mode to: " + Main.gameManager.myState.toString());
            System.out.println("Player AI vs AI");
        } else if (source == HVAMenu.playAgainButton) {
            Main.gameManager.board.resetBoard();
            Main.gameManager.playerTurn = Player.X;
            HVAMenu.startHVAGameButton.setEnabled(true);
            HVAMenu.statusBar.setText("");
            HVAMenu.timeCountDown.setText("10 seconds (default)");
            Main.gameManager.timer.stop();
        } else if (source == HVAMenu.startHVAGameButton) {   
            HVAMenu.playAgainButton.setEnabled(false);
            System.out.println("start the game");
            HVAMenu.hvaBoard.clearBoard();
            HVAMenu.hvaBoard.enableBoard();
            HVAMenu.statusBar.setText("");            
            HVAMenu.readThresholdTime.setEditable(false);
            if (!HVAMenu.readThresholdTime.getText().equalsIgnoreCase("")) {
                if (Integer.parseInt(HVAMenu.readThresholdTime.getText()) != 0) {
                    Main.gameManager.thresholdTime = Integer.parseInt(HVAMenu.readThresholdTime.getText());
                }
            }
            Main.gameManager.myState.doAction(Main.gameManager);
            Main.gameManager.startTimer();
        } else if (source == AVAMenu.makeMoveButton) { 
//            System.out.println("AI make a move");
//            Main.networkManager.requestData();
//            int bestMove = 99;
//            Main.networkManager.sendMove(bestMove);
//            Main.networkManager.requestData();
            
            // Start at AVAMode

            Main.gameManager.myState.doAction(Main.gameManager);
            
        } else if (source == deathMatchCheckBox) {
            Main.gameManager.isDeathMatch = (Main.gameManager.isDeathMatch) ? false : true;
            if (Main.gameManager.isDeathMatch) {
                Main.gameManager.setState(new AVADeathMatchMode());
                Main.gameManager.ai.algorithm = new DeathMatch();
                System.out.println("Set game mode to: " + Main.gameManager.myState.toString());
            } else {
                Main.gameManager.setState(new AVAMode());
                Main.gameManager.ai.algorithm = new AlphaBetaPruning();
                System.out.println("Set game mode to: " + Main.gameManager.myState.toString());
            }
            System.out.println("Death match: " + Main.gameManager.isDeathMatch);
        }
        
    } // End actionPerformed()
    
    
} // End class MenuListener
