package model;
import controller.GameManager;

public interface GameModeState {
    void doAction(GameManager gm);
}
