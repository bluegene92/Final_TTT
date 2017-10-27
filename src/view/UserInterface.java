
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserInterface extends JFrame {

   
    public static Board board;
    public static Menu menu;
    public static JTextField statusBar;
    
    public void initialize() {
        setSize(600, 600);
        setPreferredSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setLocationRelativeTo(null);
        
        menu = new Menu();
        menu.mainMenu();
        
        add(menu);
    }

    
    public void displayHVA() {
        setSize(900, 600);
        setPreferredSize(new Dimension(900, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe: Human vs. AI");
        setLocationRelativeTo(null);
        
        statusBar = new JTextField("Human vs. AI: Please specify a threshold time...");
        statusBar.setFont(new Font("Courier New", Font.BOLD, 16));
        statusBar.setEditable(false);
        add(statusBar, BorderLayout.NORTH);
        
        
        JPanel body = new JPanel();
        body.setLayout(new GridLayout(1, 2));
        
        System.out.println("Board created");
        board = Board.getInstance();
        board.create();
        board.disable();
        body.add(board);
        
        menu = new Menu();
        menu.hvaMenu();
        body.add(menu);
        add(body, BorderLayout.CENTER);
        
    }
    
    public void displayAVA() {
        setSize(900, 600);
        setPreferredSize(new Dimension(900, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe: AI vs. AI");
        setLocationRelativeTo(null);
        
        statusBar = new JTextField("AI vs. AI: Please enter in the server address and port number...");
        statusBar.setFont(new Font("Courier New", Font.BOLD, 16));
        statusBar.setEditable(false);
        add(statusBar, BorderLayout.NORTH);
        
        JPanel body = new JPanel();
        body.setLayout(new GridLayout(1, 2));
        
        board = Board.getInstance();
        board.create();
        body.add(board);
        
        menu = new Menu();
        menu.avaMenu();
        body.add(menu);

        add(body, BorderLayout.CENTER);
    }
}
