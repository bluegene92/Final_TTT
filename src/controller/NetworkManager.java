package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TicTacToeData;
import org.json.JSONException;
import org.json.JSONObject;
import view.AVAMenu;

public class NetworkManager {
    public HTTPRequest httprequest;
    private GameBoard gameBoard;
    private TicTacToeData tictactoeData;
    private GameStatus gameStatus;
    private GameStatistic gameStatistic;
    private GameClientID gameClientID;
    
    public JSONObject jsonObject;
    private String stringFromUrl;
    public NetworkManager() {
        httprequest = new HTTPRequest();
        gameBoard = new GameBoard();
        tictactoeData = new TicTacToeData();
        gameStatus = new GameStatus();
        gameStatistic = new GameStatistic();
        gameClientID = new GameClientID();
    }
    
    public void requestData() {
        try {
            stringFromUrl = httprequest.readJsonFromUrl("http://dotpizza.azurewebsites.net/api/tictactoe/");
        } catch (IOException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            jsonObject = new JSONObject(stringFromUrl);
        } catch (JSONException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        }    
        getBoard();
        getStatistic();
        getStatus();
        getClientID();
        tictactoeData.getInfo();
    }
    
    public void sendMove(int n) {
        httprequest.put(n);
    }
    
    public void getBoard() {
        gameBoard.get(jsonObject);
        tictactoeData.gameBoard = gameBoard.gameBoardArray;
        for (int i = 0; i < 9; ++i) {
            
            String value = String.valueOf(tictactoeData.gameBoard[i]);
            if (value.equalsIgnoreCase("-")) {
                AVAMenu.avaBoard.boardModel.cells[i].setText("");
            } else {
                AVAMenu.avaBoard.boardModel.cells[i].setText(
                        String.valueOf(tictactoeData.gameBoard[i]));
            }
        }
        Main.gameManager.board = AVAMenu.avaBoard;
    }
    
    public void getStatistic() {
        tictactoeData.gameTurn = Integer.parseInt(gameStatistic.get(jsonObject));
    }
    
    public void getStatus() {
        String statusInfo = gameStatus.get(jsonObject);
        int index = statusInfo.indexOf('@');
        String gameModeString = statusInfo.substring(0, index);
        String winnerString = statusInfo.substring(index + 1, statusInfo.length());
        if (gameModeString.equalsIgnoreCase("false")) {
            tictactoeData.gameMode = false;
//            AVAMenu.deathMatchCheckBox.setSelected(false);
            Main.gameManager.ai.algorithm = new AlphaBetaPruning(); 
        } else if (gameModeString.equalsIgnoreCase("true")) {
            Main.gameManager.ai.algorithm = new DeathMatchAlgorithm();
            tictactoeData.gameMode = true;
//            AVAMenu.deathMatchCheckBox.setSelected(true);
        }
        tictactoeData.gameWinner = winnerString;
    }
    
    public void getClientID() {
        tictactoeData.clientID = gameClientID.get(jsonObject);
    }
}
