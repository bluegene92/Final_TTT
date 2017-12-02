/**
 * This is a Tictactoe game application with 2 game modes.
 * The first game mode is human vs. AI, where the user
 * can play again an artificial intelligence. 
 * The second game mode is AI vs. AI, where two AI, on
 * separate systems compete over a server network.
 * 
 * @author Team 8 XOXO
 * @version 1.4
 * @since 2017-10-20
 */
package controller;
import view.GameWindow;

public class Main {
    public static GameManager gameManager;
    public static NetworkManager networkManager;
    public static GameWindow gameWindow;
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                gameManager = new GameManager();
                networkManager = new NetworkManager();
                gameWindow = new GameWindow();
                gameWindow.displayMainMenu();
            } // End run()
            
        }); // End invokeLater()
        
    } // End main();
    
} // End class Main
