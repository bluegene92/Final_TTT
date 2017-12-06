package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.HVAMode;
import javax.swing.Timer;
import model.GameModeState;
import model.Player;
import view.AVAMenu;
import view.Board;
import view.HVAMenu;

public class GameManager {
    public Board board;
    public String result;
    public int thresholdTime = 10;
    public int counter;
    public Timer timer;
    public boolean isDeathMatch = false;
    public GameModeState myState;
    

    public String playerTurn = Player.X;
    public static String mainPlayer = Player.X;
    public static AI ai;

    public GameManager() {
        ai = new AI();
        myState = new HVAMode();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HVAMenu.timeCountDown.setText(counter + " secs");
                if (counter == 0) {
                    board.disableBoard();
                    HVAMenu.readThresholdTime.setEditable(true);
                    HVAMenu.timeCountDown.setText("Time's up!");
                    HVAMenu.statusBar.setText("You Lose!!!");
                    playerTurn = Player.X;
                    timer.stop();
                    counter = thresholdTime;
                }
                counter--;
            }
        });
    }
    
    
    public void placeAIMove() {
        if (playerTurn.equalsIgnoreCase(Player.X)) {
            ai.makeMove();
            updatePlayerTurn();
        }
        checkForWinner();
    }
    
    public void startTimer() {
        counter = thresholdTime;
        timer.start();
    }
    
    public void updatePlayerTurn() {
        playerTurn = (playerTurn.equalsIgnoreCase(Player.O)) ? Player.X : Player.O;
    }
    
    public boolean isDeathMatch() {
        int count = 0;
        for (int i = 0; i < 9; ++i) {
            if (!board.boardModel.cells[i].isEmpty()) {
                count++;
            }
        }
        if (!board.checkCounterRow(Player.X) &&
            !board.checkCounterRow(Player.O) &&
            count == 8) {
            return true;
        } 
        return false;
    }
    
    public void setState(GameModeState gms) {
        myState = gms;
    }
    
    public GameModeState getState() {
        return myState;
    }
    
    public boolean isGameOver() {
        return board.checkCounterRow(Player.X) 
                || board.checkCounterRow(Player.O) 
                || board.isBoardEmpty();
    }
    
    public boolean isGameOverDeathMatch() {
        return board.checkCounterRow(Player.X) 
            || board.checkCounterRow(Player.O);
    }

    public void gameEnd() {
        board.disableBoard();
        HVAMenu.startHVAGameButton.setEnabled(false);
        HVAMenu.playAgainButton.setEnabled(true);
        HVAMenu.readThresholdTime.setEditable(true);
    }
    

    public void updateHVAStatusBar(String n) {
        HVAMenu.statusBar.setText(n);
    }
    
    public void updateAVAStatusBar(String n) {
        AVAMenu.statusBar.setText(n);
    }
    
    public void checkForWinner() {
        System.out.println("Check for winner");
        if (board.checkCounterRow(Player.X)) {
            System.out.println("X win");
            updateHVAStatusBar("X WIN!!!");
            timer.stop();
            gameEnd();
        } else if (board.checkCounterRow(Player.O)) {
            System.out.println("O win");
            updateHVAStatusBar("O WIN!!!");
            timer.stop();
            gameEnd();
        } else if (board.isBoardEmpty()){
            System.out.println("DRAW");
            updateHVAStatusBar("DRAW!!!");
            timer.stop();
            gameEnd();
        }
    }
    
} // End class GameManager
