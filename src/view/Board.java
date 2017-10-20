
package view;
import controller.CellListener;
import controller.GameManager;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Cell;


public class Board extends JPanel {

    
    public Cell cells[];
    private final int CELLS_COUNT = 9;
    private CellListener cellListener;
    
    
    /**
     * Apply singleton design pattern to the board.
     * Since only 1 board should exist in the application.
     */
    private static Board instance = new Board();
    
    
    /**
     * Make constructor private
     */
    private Board(){}
    
    public static Board getInstance() {
        return instance;
    }
    
    
    
    
    /**
     * Create and initialize the Tictactoe board.
     * 
     * @return void
     */
    public void create() {

        
        /**
         * Set grid layout to 3x3
         */
        setLayout(new GridLayout(3, 3));
        
        
        cells = new Cell[9];
        cellListener = new CellListener();
        for (int i = 0; i < CELLS_COUNT; ++i) {
            cells[i] = new Cell();
            cells[i].position = i; // Set the position 0-8
            cells[i].addActionListener(cellListener);
            add(cells[i]);
        }
        
        
        /**
         * Give the game manager the reference to this board
         */
        GameManager.board = this;
        
        
    } // End create()
    
    
    /**
     * Select the cell which the player want to make their move.
     * @param position The position of the board 0-8
     */
    public void selectCell(int position, String player) {
        cells[position].setText(player);
        cells[position].setEnabled(false);
    }
    
    
    /**
     * In case where the game is a draw, where each player have
     * 4 counter on the board, they can slide their counter to
     * the adjacent available spot.
     */
    public void slideCell(int currentPosition, int availablePosition, String player) {
        
        /** 
        * ********* TBD ****************
        * Do something for slide cell
        */
        
    }
    
    
    /**
     * Undo the move at the given position on the board.
     * 
     * @param position The position of the cell.
     */
    public void undoMove(int position) {
        UserInterface.board.cells[position].setText("");
        UserInterface.board.cells[position].setEnabled(true);
    }
    
    
    /**
     * Get the cells count of the board.
     * 
     * @return Return the number of cells on the board.
     */
    public int getCellsCount() {
        return cells.length;
    }
    
    
    /**
     * Disable all the cells on the board.
     */
    public void disable() {
        for (int i = 0; i < CELLS_COUNT; ++i) {
                cells[i].setEnabled(false);
        }
    }
    
    
    /**
     * Enable the all the cells on the board to be selected.
     */
    public void enable() {
        for (int i = 0; i < CELLS_COUNT; ++i) {
                cells[i].setEnabled(true);
        }
    }
    
    
    /**
     * Clear the Tictactoe board by setting all the cell
     * text to empty and enabled the whole board.
     */
    public void clearBoard() {
        for (int i = 0; i < CELLS_COUNT; ++i) {
            cells[i].setText("");
        }
        enable();
    }
    
    
    /**
     * Check if the board is empty. If the board
     * no longer have any available cells to place
     * a move, then it is empty, return true. 
     * Otherwise there are still room, return false.
     * 
     * @return Return true if the board is empty, otherwise false.
     */
    public boolean isBoardEmpty() {
        for (int i = 0; i < CELLS_COUNT; ++i) {
            if (cells[i].isEmpty() && cells[i].isEnabled())
                return false;
        }
        return true;
    }
    
    
    /**
     * This function takes a set of value of the positions
     * of three cells and check to make sure they are not empty
     * and that their value matches. If it those two conditions met,
     * then return true, otherwise return false.
     * 
     * @param first the first Cell
     * @param second the second Cell
     * @param third the third Cell
     * @return Return true if there's a winning set, otherwise false.
     */
    public boolean checkWinCondition(int first, int second, int third) {
        if ((!cells[first].isEmpty() && !cells[second].isEmpty() && !cells[third].isEmpty())  && 
             (cells[first].equals(cells[second]) &&
              cells[second].equals(cells[third]))) {
            return true;
        }
        return false;
    }
    
    
    /**
     * Return an array list of cells objects that are available
     * on the Tictactoe board. Cell that are empty and enabled
     * is consider available and will be added onto the list.
     * 
     * @return an ArrayList of available Cell objects
     */
    public ArrayList<Cell> getAvailableCells() {
        ArrayList<Cell> availableCells = new ArrayList<>();
        for(int i = 0; i < CELLS_COUNT; ++i) {
            if (cells[i].isEmpty() && cells[i].isEnabled()) {
                availableCells.add(cells[i]);
            }
        }
        return availableCells;
    }
    

} // End class Board
