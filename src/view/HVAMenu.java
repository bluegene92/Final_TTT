package view;
import controller.Main;
import controller.MenuListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HVAMenu extends Menu {
    public static Board hvaBoard;
    public static JButton startHVAGameButton;
    public static JButton playAgainButton;
    public static JButton mainMenuButton;
    public static JTextField timeCountDown;
    public static JTextField readThresholdTime;
    public static JTextField statusBar;
    private JPanel body;
    private JPanel rightArea;
    private JPanel timeCountDownPanel;
    private JPanel inputPanel;
    private JPanel startPanel;
    private JPanel playAgainPanel;
    private JPanel mainPanel;
    private MenuListener menuListener;

    void create() {
        initialize();
        setLayout(new BorderLayout());
        menuListener = new MenuListener();
        
        body = new JPanel();
        body.setLayout(new GridLayout(1, 2));
        
        hvaBoard = new Board();
        hvaBoard.create();
        hvaBoard.disableBoard();
        Main.gameManager.board = hvaBoard;
        
        rightArea = new JPanel();
        rightArea.setLayout(new GridLayout(5, 1));

        timeCountDownPanel = new JPanel();
        timeCountDownPanel.setLayout(new FlowLayout());
        timeCountDown = new JTextField();
        timeCountDown.setEditable(false);
        timeCountDown.setText("10 seconds (default)");
        timeCountDown.setHorizontalAlignment(SwingConstants.CENTER);
        timeCountDown.setBorder(BorderFactory.createEmptyBorder());
        timeCountDown.setPreferredSize(new Dimension(300, 100));
        timeCountDown.setFont(new Font("Courier New", Font.BOLD, 25));
        timeCountDownPanel.add(timeCountDown);
        rightArea.add(timeCountDownPanel);
        
        readThresholdTime = new JTextField();
        readThresholdTime.setPreferredSize(new Dimension(100, 30));
        
        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter threshold time"));
        inputPanel.add(readThresholdTime);
        rightArea.add(inputPanel);

        startPanel = new JPanel();
        startPanel.setLayout(new FlowLayout());
        startHVAGameButton = new JButton("Start Game");
        
        startHVAGameButton.setPreferredSize(new Dimension(100, 30));
        startHVAGameButton.addActionListener(menuListener);
        startPanel.add(startHVAGameButton);
        rightArea.add(startPanel);

        playAgainPanel = new JPanel();
        playAgainPanel.setLayout(new FlowLayout());
        playAgainButton = new JButton("Play Again");
        playAgainButton.setPreferredSize(new Dimension(100, 30));
        playAgainButton.setEnabled(false);
        playAgainButton.addActionListener(menuListener);
        playAgainPanel.add(playAgainButton);
        rightArea.add(playAgainPanel);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(menuListener);
        mainPanel.setPreferredSize(new Dimension(100, 30));
        mainPanel.add(mainMenuButton);
        rightArea.add(mainPanel);
        
        statusBar = new JTextField("");
        statusBar.setFont(new Font("Courier New", Font.BOLD, 40));
        statusBar.setEditable(false);

        body.add(hvaBoard);
        body.add(rightArea);
        add(statusBar, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
    }
}
