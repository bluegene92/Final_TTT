package model;

public class TicTacToeData {

    public char[] gameBoard;
    public int gameTurn;
    public boolean gameMode;
    public String gameWinner;
    public String clientID;
    
    public TicTacToeData() {
        gameBoard = new char[9];
        gameTurn = 1;
        gameMode = false;
        gameWinner = "";
        clientID = "";
    }
    
    public void getInfo() {
        System.out.println("board: ");
        for (int i = 0; i < 9; ++i) {

            System.out.print(gameBoard[i]);
            if (i == 2 || i == 5) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("turn: " + gameTurn);
        System.out.println("status deathmatch: " + gameMode);
        System.out.println("status winner: " + gameWinner);
        System.out.println("client id: " + clientID);
    }
    
}
