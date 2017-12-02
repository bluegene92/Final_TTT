package view;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Menu extends JFrame {
    private final int WIDTH = 900;
    private final int HEIGHT = 600;    
    public void initialize() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
} // End class Menu
