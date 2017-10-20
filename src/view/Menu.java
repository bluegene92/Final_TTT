
package view;
import controller.MenuListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Menu extends JPanel {

    
    public static JButton hvaButton;
    public static JButton avaButton;
    public static JButton startHVAGameButton;
    public static JButton startAVAGameButton;
    public static JButton playAgainButton;
    public static JTextField readThresholdTime;
    public static JTextField readServerAddress;
    public static JTextField readPortNumber;
    private JPanel row1;
    private JPanel row2;
    private MenuListener menuListener;

    
    /**
     * When the game first player, a menu will
     * display two options to select (hva & ava).
     */
    public void mainMenu() {
        menuListener = new MenuListener();
        row1 = new JPanel();
        row2 = new JPanel();
        
        
        row1.setLayout(new FlowLayout());
        row2.setLayout(new FlowLayout());
        setLayout(new GridLayout(2, 1));
        
        
        hvaButton = new JButton("Human vs AI");
        avaButton = new JButton("AI vs AI");
        
        
        hvaButton.setPreferredSize(new Dimension(150, 40));
        avaButton.setPreferredSize((new Dimension(150, 40)));
        
        
        hvaButton.addActionListener(menuListener);
        avaButton.addActionListener(menuListener);
        
        
        row1.add(hvaButton);
        row2.add(avaButton);
        
        
        add(row1);
        add(row2);


    } // End create()
    
    
    /**
     * In HVA, the menu will have a threshold time input
     * for the user to enter.
     */
    public void hvaMenu() {
        menuListener = new MenuListener();
        setLayout(new GridLayout(3, 1));
        
        
        readThresholdTime = new JTextField();
        readThresholdTime.setPreferredSize(new Dimension(100, 30));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter threshold time"));
        inputPanel.add(readThresholdTime);
        
        
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new FlowLayout());
        startHVAGameButton = new JButton("Start Game");
        startHVAGameButton.setPreferredSize(new Dimension(100, 30));
        startHVAGameButton.addActionListener(menuListener);
        startPanel.add(startHVAGameButton);
        
        JPanel playAgainPanel = new JPanel();
        playAgainPanel.setLayout(new FlowLayout());
        playAgainButton = new JButton("Play Again");
        playAgainButton.setPreferredSize(new Dimension(100, 30));
        playAgainButton.setEnabled(false);
        playAgainButton.addActionListener(menuListener);
        playAgainPanel.add(playAgainButton);
        
        add(inputPanel);
        add(startPanel);
        add(playAgainPanel);
        
    } // End hvaMenu()
    
    
    
        public void avaMenu() {
        menuListener = new MenuListener();    
        setLayout(new GridLayout(3, 1));
        
        
        readServerAddress = new JTextField();
        readServerAddress.setPreferredSize(new Dimension(200, 30));

        readPortNumber = new JTextField();
        readPortNumber.setPreferredSize(new Dimension(200, 30));
        
        JPanel inputAddressPanel = new JPanel();
        JPanel inputPortPanel = new JPanel();

        
        inputAddressPanel.setBorder(BorderFactory.createTitledBorder("Enter server address"));
        inputPortPanel.setBorder(BorderFactory.createTitledBorder("Enter port number"));
        
        inputAddressPanel.add(readServerAddress);
        inputPortPanel.add(readPortNumber);
        
        
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new FlowLayout());
        startAVAGameButton = new JButton("Start Game");
        startAVAGameButton.setPreferredSize(new Dimension(100, 30));
        startAVAGameButton.addActionListener(menuListener);
        startPanel.add(startAVAGameButton);
        
        
        JPanel playAgainPanel = new JPanel();
        playAgainPanel.setLayout(new FlowLayout());
        playAgainButton = new JButton("Play Again");
        playAgainButton.setPreferredSize(new Dimension(100, 30));
        playAgainButton.setEnabled(false);
        playAgainButton.addActionListener(menuListener);
        playAgainPanel.add(playAgainButton);
        
        add(inputAddressPanel);
        add(inputPortPanel);
        add(startPanel);
        add(playAgainPanel);
        
        
    } // End avaMenu()
    
    

} // End class Menu
