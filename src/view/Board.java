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
    
    public void create() {
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < CELLS_COUNT; ++i) {
            boardModel.cells[i] = new Cell();
            boardModel.cells[i].position = i;
            add(boardModel.cells[i]);
            boardModel.cells[i].addActionListener(cellListener);
        } 
    }

    public void selectCell(int position, String player) {
        boardModel.cells[position].setText(player);
        boardModel.cells[position].setEnabled(false);
    }

    public void slideCell(int currentPosition, int availablePosition, String player) {
        
        /** 
        * ********* TBD ****************
        * Do something for slide cell
        */
        
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
    
    public Board CopyBoard(Board b) {
        for (int i = 0; i < CELLS_COUNT; ++i) {
            b.boardModel.cells[i] = boardModel.cells[i];
        }
        return this;
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
    

} // End class Board
