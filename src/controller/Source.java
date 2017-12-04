package controller;

import model.TicTacToeData;


public class Source {

//    public static void main(String[] args) {
//        HTTPRequest.setMyID("Team X"); //OK
//        HTTPRequest.setMyID("Team Y"); //IllegalStateException will be thrown
//        HTTPRequest http = new HTTPRequest();
//        TicTacToeData myData = new TicTacToeData();
//
//        http.get(myData);
//        print(myData);
//
//        http.put(8);
//
//        http.get(myData);
//        print(myData);
//    }

    public static void print(TicTacToeData myData) {
        System.out.println("Game Board");
        for (int i = 0; i < myData.gameBoard.length; i++) {
            System.out.println(myData.gameBoard[i]);
        }
        System.out.println("\n");
        System.out.println("Turn Number = " + myData.gameTurn);
        System.out.println("\n");
        System.out.println("isDeathMatch = " + myData.gameMode);
        System.out.println("\n");
        System.out.println("Winner = " + myData.gameWinner);
        System.out.println("\n");
    }

}
