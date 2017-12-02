package view;
import controller.MenuListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu extends Menu {
    public static JButton hvaButton;
    public static JButton avaButton;
    public static JButton startHVAGameButton;
    public static JButton startAVAGameButton;
    public static JButton playAgainButton;
    public static JTextField timeCountDown;
    public static JTextField readThresholdTime;
    public static JTextField readServerAddress;
    public static JTextField readPortNumber;
    private JPanel row1;
    private JPanel row2;
    private MenuListener menuListener;
    
    public void create() {
        initialize();
        System.out.println("main menu created");
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
    }
}
