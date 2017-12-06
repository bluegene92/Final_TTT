package model;
import controller.GameManager;
import controller.Main;
import model.GameModeState;

public class AVAMode implements GameModeState {

    @Override
    public void doAction(GameManager gm) {
        Main.networkManager.requestData();
        Main.gameManager.ai.makeAVAMove();
        int bestMove = Main.gameManager.ai.bestMove;
        System.out.println("best move: " + bestMove);
        Main.networkManager.sendMove(bestMove);
        Main.gameManager.board.disableBoard();
        Main.networkManager.requestData();
    }
}
