package controller;

import controller.GameManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import model.Algorithm;
import model.Player;

public class AI {
    
    private Thread thread;
    private String threadName;
    private Algorithm algorithm = new AlphaBetaPruning();
    public static double maxPly;
    public static int bestPosition;
    public static int iteration = 0; // For testing purpose
    public int negativeInfinity = Integer.MIN_VALUE;
    public int positiveInfinity = Integer.MAX_VALUE;
    int tick = 0;
    boolean thinking = true;
    int bestMove;
    public Timer time;
    
    public AI() {}
    
    public void pause() {
        time = new Timer(3000, taskPerform);
        time.start();
    }

    ActionListener taskPerform = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            GameManager.board.selectCell(bestMove, Player.O);
            time.stop();
        }
    };
     
    public void makeMove() {
        if (!GameManager.isGameOver()) {
            GameManager.ui.statusBar.setText("O's turn");
            algorithm.runAlgorithm();
            bestMove = AlphaBetaPruning.bestPosition;
            pause(); // Pause for 3 seconds
            GameManager.ui.statusBar.setText("X's turn");
            GameManager.playerTurn = Player.X;  
        }
        //algorithm.runAlgorithm();
    }
} // End AI
