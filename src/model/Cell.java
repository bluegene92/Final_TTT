
package model;
import java.awt.Font;
import javax.swing.JButton;


public class Cell extends JButton {
    

    private String fontFamily = "Courier New";
    private int fontSize = 30;
    
    
    /**
     * Holds the position of the cell 0-8
     */
    public int position;
    
    
    public Cell() {
        setFont(new Font(fontFamily, Font.BOLD, fontSize));
    }
    
    
    public Cell(Cell copy) {
        this.position = copy.position;
    }
    
    
    public Cell(String name) {
        super.setText(name);
    }
    
    
    public boolean isEmpty() {
        return this.getText().equalsIgnoreCase("");
    }
    
    
    public boolean equals(Cell c) {
        return this.getText().equalsIgnoreCase(c.getText());
    }
    
    
} // End class Cell
