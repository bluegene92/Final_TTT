package model;
import controller.GameManager;
import controller.Main;

public class AVADeathMatchMode implements GameModeState {

    @Override
    public void doAction(GameManager gm) {
        Main.networkManager.requestData();
        gm.ai.makeDeathMatchMove();
        int bestCounter = Main.gameManager.ai.bestCounter;
        Main.networkManager.sendMove(bestCounter);
        Main.gameManager.board.disableBoard();
        Main.networkManager.requestData();
    }

}
