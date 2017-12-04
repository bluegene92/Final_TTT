package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import model.Algorithm;
import model.Player;


public class AI {
    public Algorithm algorithm = new AlphaBetaPruning();
    public static double maxPly;
    public static int bestPosition;
    public static int iteration = 0; // For testing purpose
    public int negativeInfinity = Integer.MIN_VALUE;
    public int positiveInfinity = Integer.MAX_VALUE;
    int tick = 0;
    boolean thinking = true;
    public int bestMove;
    public Timer time;
    public int pauseTime = 3000; // 3 seconds
    
    public AI() {}
    
    public void pause(int pauseTime) {
        time = new Timer(pauseTime, taskPerform);
        time.start();
        Main.gameManager.timer.stop();
        Main.gameManager.counter = Main.gameManager.thresholdTime;
    }

    ActionListener taskPerform = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Main.gameManager.board.selectCell(bestMove, Player.X);
            Main.gameManager.checkForWinner();
            Main.gameManager.gameEnd();
            time.stop();
            Main.gameManager.timer.start();
            Main.gameManager.board.enableBoard();
            
        }
    };

    public void makeAVAMove() {
        if (!Main.gameManager.isGameOver()) {
            /**
             * Calculate the time the algorithm run.
             * Subtract it from 3 seconds to find pause time.
             */
            long startTime = System.currentTimeMillis();
            bestMove = algorithm.runAlgorithm();
            long endTime = System.currentTimeMillis();
            int diff = (int) endTime - (int) startTime;
            if (diff < 3000) {
                pauseTime = 3000 - diff;
            }
            System.out.println("Ran algorithm, AVA best move is: " + bestMove);
        }        
    }
    
    
    public void makeMove() {
        if (!Main.gameManager.isGameOver()) {
            /**
             * Calculate the time the algorithm run.
             * Subtract it from 3 seconds to find pause time.
             */
            long startTime = System.currentTimeMillis();
            bestMove = algorithm.runAlgorithm();
            long endTime = System.currentTimeMillis();
            int diff = (int) endTime - (int) startTime;
            if (diff < 3000) {
                pauseTime = 3000 - diff;
            }
            
            pause(pauseTime);
            System.out.println("Ran algorithm, best move is: " + bestMove);
        }
    }
} // End AI
