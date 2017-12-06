package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import model.Algorithm;
import model.Player;


public class AI {
    public Algorithm algorithm = new AlphaBetaPruning();
    public int bestMove;
    public int bestCounter;
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
    
    
    public void makeDeathMatchMove() {
        if (Main.gameManager.board.isEmpty()) {
            System.out.println("running " + algorithm.toString());
            Main.gameManager.board.selectCell(4, Main.gameManager.mainPlayer);
        } else if (Main.gameManager.isDeathMatch()) {
            System.out.println("running death match");
            algorithm = new DeathMatchAlgorithm();
            bestCounter = algorithm.runAlgorithm();
            System.out.println("running " + algorithm.toString());
            System.out.println("best Counter" + bestCounter);
//            Main.gameManager.board.slideCell(bestCounter, Main.gameManager.mainPlayer);
            Main.gameManager.checkForWinner();
            
        } else  {
            algorithm = new AlphaBetaPruning();
            bestMove = algorithm.runAlgorithm();
            System.out.println("run alphabeta");
            System.out.println("running " + algorithm.toString());
            Main.gameManager.board.selectCell(bestMove, Main.gameManager.mainPlayer);
        }
    }

    public void makeAVAMove() {
        if (!Main.gameManager.isGameOver()) {
            long startTime = System.currentTimeMillis();
            if (Main.gameManager.board.isEmpty()) {
                bestMove = 4;
            } else {
                bestMove = algorithm.runAlgorithm();
            }
            long endTime = System.currentTimeMillis();
            int diff = (int) endTime - (int) startTime;
            if (diff < 3000) {
                pauseTime = 3000 - diff;
            }
            pause(pauseTime);
        }        
    }
    
    public void makeMove() {
        if (!Main.gameManager.isGameOver()) {
            long startTime = System.currentTimeMillis();
            if (Main.gameManager.board.isEmpty()) {
                bestMove = 4;
            } else {
                bestMove = algorithm.runAlgorithm();
            }
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
