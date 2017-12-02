package model;
import controller.GameManager;
import model.GameModeState;

public class HVAMode implements GameModeState {

    @Override
    public void doAction(GameManager gm) {
        gm.placeAIMove();
        gm.counter = gm.thresholdTime;
        gm.board.disableBoard();
    }

}
