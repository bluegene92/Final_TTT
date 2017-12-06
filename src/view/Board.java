package view;
import controller.CellListener;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.BoardModel;
import model.Cell;

public class Board extends JPanel {
    private final int CELLS_COUNT = 9;
    public BoardModel boardModel = new BoardModel();
    private CellListener cellListener = new CellListener();
    public static int counterOnBoard = 0;
    
    public void create() {
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < CELLS_COUNT; ++i) {
            boardModel.cells[i] = new Cell();
            boardModel.cells[i].position = i;
            add(boardModel.cells[i]);
            boardModel.cells[i].addActionListener(cellListener);
            boardModel.cells[i].setFocusable(false);
        } 
        
//        boardModel.cells[0].setText(Player.O);
//        boardModel.cells[1].setText(Player.X);
//        boardModel.cells[2].setText(Player.X);
//        boardModel.cells[3].setText(Player.O);
//        boardModel.cells[4].setText(Player.X);
//        boardModel.cells[5].setText(Player.O);
//        boardModel.cells[6].setText(Player.O);
//        boardModel.cells[7].setText(Player.O);
//        boardModel.cells[8].setText(Player.X);
    }

    public void selectCell(int position, String player) {
        boardModel.cells[position].setText(player);
//        boardModel.cells[position].setEnabled(false);
    }
    
    public int slideCell(int position, String player) {
        int currentEmptySlot = getEmptySlot();
        System.out.println("slide counter: " + position + " to "+ currentEmptySlot);
        boardModel.cells[currentEmptySlot].setText(player);
        undoMove(position);
        return currentEmptySlot;
    }
    
    public boolean isEmpty() {
        for (int i = 0; i < 9; ++i) {
            if (!boardModel.cells[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public int getCounterOnBoard() {
        int n = 0;
        for (int i = 0; i < 9; ++i) {
            if (!boardModel.cells[i].isEmpty()) {
                n++;
            }
        }
        return n;
    }
    
    public int getEmptySlot() {
        for (int i = 0; i < 9; ++i) {
            if (boardModel.cells[i].getText().equalsIgnoreCase("")) {
                return i;
            }
        }
        return -1;
    }

    public void undoMove(int position) {
        boardModel.cells[position].setText("");
        boardModel.cells[position].setEnabled(true);
    }

    public int getCellsCount() {
        return boardModel.cells.length;
    }

    public void disableBoard() {
        for (int i = 0; i < CELLS_COUNT; ++i) {
                boardModel.cells[i].setEnabled(false);
        }
    }

    public void enableBoard() {
        for (int i = 0; i < CELLS_COUNT; ++i) {
            if (boardModel.cells[i].isEmpty()) {
                boardModel.cells[i].setEnabled(true);
            }
        }
    }
    
    public void clearBoard() {
        for (int i = 0; i < CELLS_COUNT; ++i) {
            boardModel.cells[i].setText("");
        }
        enableBoard();
    }
    
    public void removeCounter(int position) {
        boardModel.cells[position].setText("");
    }
    
    public ArrayList<Cell> getAdjacentList(String player) {
        ArrayList<Cell> adjacentList = new ArrayList<Cell>();
        int emptySlot = getEmptySlot();
        for (int i = 0; i < 9; ++i) {
            if (boardModel.cells[i].getText().equalsIgnoreCase(player) && 
                isAdjacent(emptySlot, boardModel.cells[i].position)) {
                
                System.out.println("Adding " + boardModel.cells[i].position + " to adjacent list");
                adjacentList.add(boardModel.cells[i]);
                System.out.print("player " + player + " position " + boardModel.cells[i].position);
                System.out.println(" adjacent to empty slot" + emptySlot);
            } 

        }        
        return adjacentList;        
    }
    
    public void resetBoard() {
        for (int i = 0; i < CELLS_COUNT; ++i) {
            boardModel.cells[i].setText("");
        }
        disableBoard();
    }

    public boolean isBoardEmpty() {
        for (int i = 0; i < CELLS_COUNT; ++i) {
            if (boardModel.cells[i].isEmpty())
                return false;
        }
        return true;
    }

    public boolean checkWinCondition(int first, int second, int third) {
        if ((!boardModel.cells[first].isEmpty() && !boardModel.cells[second].isEmpty() && !boardModel.cells[third].isEmpty())  && 
             (boardModel.cells[first].equals(boardModel.cells[second]) &&
              boardModel.cells[second].equals(boardModel.cells[third]))) {
            return true;
        }
        return false;
    }
    
    public boolean checkCounterRow(String player) {
        if (checkWinCondition(0, 1, 2) && // Top row
            boardModel.cells[0].getText().equalsIgnoreCase(player)) {
            return true;
        } else if (checkWinCondition(3, 4, 5) && // Middle row
                   boardModel.cells[3].getText().equalsIgnoreCase(player)) {
            return true;
        } else if (checkWinCondition(6, 7, 8) && // Bottom row
                   boardModel.cells[6].getText().equalsIgnoreCase(player)) {
            return true;
        } else if (checkWinCondition(0, 3, 6) && // Left column
                   boardModel.cells[0].getText().equalsIgnoreCase(player)) {
            return true;
        } else if ((checkWinCondition(1, 4, 7) && // Middle column
                boardModel.cells[1].getText().equalsIgnoreCase(player))) {
            return true;
        } else if ((checkWinCondition(2, 5, 8) && // Right column 
                boardModel.cells[2].getText().equalsIgnoreCase(player))) {
            return true;
        } else if ((checkWinCondition(0, 4, 8) && // Backward diagonal
                boardModel.cells[0].getText().equalsIgnoreCase(player))) {
            return true;
        } else if ((checkWinCondition(2, 4, 6) && // Forward diagonal 
                boardModel.cells[2].getText().equalsIgnoreCase(player))) {
            return true;
        }
        return false;
    } // End checkWinner()    

    public ArrayList<Cell> getAvailableCells() {
        ArrayList<Cell> availableCells = new ArrayList<>();
        for(int i = 0; i < CELLS_COUNT; ++i) {
            if (boardModel.cells[i].isEmpty()) {
                availableCells.add(boardModel.cells[i]);
            }
        }
        return availableCells;
    }
    
    public boolean isAdjacent(int position1, int position2) {
        switch (position1) {
            case 0:
                if (position2 == 1 || position2 == 3 || position2 == 4) {
                    return true;
                }
            break;
            
            case 1:
                if (position2 == 0 || position2 == 2 || position2 == 4) {
                    return true;
                }
            break;
            
            case 2:
                if (position2 == 1 || position2 == 4 || position2 == 5) {
                    return true;
                }
            break;
            
            case 3:
                if (position2 ==  0 || position2 == 4 || position2 == 6) {
                    return true;
                }
            break;
            
            case 4:
                if (position2 == 0 || position2 == 1 || position2 == 2
                        || position2 == 3 || position2 == 5 || position2 == 6 
                        || position2 == 7
                        || position2 == 8)
                    return true;
            break;
            
            case 5:
                if (position2 == 2 || position2 == 4 || position2 == 8) {
                    return true;
                }
            break;
            
            case 6:
                if (position2 == 3 || position2 == 4 || position2 == 7) {
                    return true;
                }
            break;
            
            case 7:
                if (position2 == 6 || position2 == 4 || position2 == 8) {
                    return true;
                }
            break;
            
            case 8:
                if (position2 == 4 || position2 == 7 || position2 == 5) {
                    return true;
                }
            break;
        } 
        return false;
    }
} // End class Board
