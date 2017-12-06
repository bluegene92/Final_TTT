package view;
import controller.Main;
import controller.MenuListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AVAMenu extends Menu {
    public static Board avaBoard;
    public static JTextField statusBar;
    public static JButton makeMoveButton;
    public static JButton playAgainButton;
    public static JButton mainMenuButton;
    public static JButton resetBoardButton;
    public static JTextField serverStatus;
    public static JTextField readServerURL;
    public static JCheckBox deathMatchCheckBox;
    public static JCheckBox playerTwoCheckBox;
    private MenuListener menuListener;
    private JPanel body;
    private JPanel rightArea;
    private JPanel severStatusPanel;
    private JPanel inputPanel;
    private JPanel makeMovePanel;
    private JPanel makeMovePanelLeftSide;
    private JPanel makeMovePanelRightSide;
    private JPanel resetBoardPanel;
    private JPanel playAgainPanel;
    private JPanel mainPanel;
    
    public void create() {
        initialize();
        setLayout(new BorderLayout());
        menuListener = new MenuListener();
        
        body = new JPanel();
        body.setLayout(new GridLayout(1, 2));
        
        avaBoard = new Board();
        avaBoard.create();
        avaBoard.disableBoard();
        
        rightArea = new JPanel();
        rightArea.setLayout(new GridLayout(6, 1));

//        severStatusPanel = new JPanel();
//        severStatusPanel.setLayout(new FlowLayout());
//        serverStatus = new JTextField();
//        serverStatus.setEditable(false);
//        serverStatus.setFont(new Font("Courier New", Font.BOLD, 15));
//        serverStatus.setText("Server status: ");
//        serverStatus.setBorder(BorderFactory.createEmptyBorder());
//        severStatusPanel.add(serverStatus);
//        rightArea.add(severStatusPanel);
        
        readServerURL = new JTextField("http://dotpizza.azurewebsites.net/api/tictactoe");
        readServerURL.setPreferredSize(new Dimension(350, 30));
        
//        inputPanel = new JPanel();
//        inputPanel.setLayout(new FlowLayout());
//        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Server URL"));
//        inputPanel.add(readServerURL);
//        rightArea.add(inputPanel);

        makeMovePanel = new JPanel();
        makeMovePanel.setLayout(new GridLayout(1, 3));
        makeMovePanelLeftSide = new JPanel();
        makeMovePanelLeftSide.setLayout(new FlowLayout());
        makeMovePanelRightSide = new JPanel();
        makeMovePanelRightSide.setLayout(new FlowLayout());
        makeMoveButton = new JButton("Make Move");
        makeMoveButton.setPreferredSize(new Dimension(100, 30));
        makeMoveButton.addActionListener(menuListener);
        resetBoardPanel = new JPanel();
        resetBoardPanel.setLayout(new FlowLayout());
        resetBoardButton = new JButton("Reset Board");
        resetBoardButton.setPreferredSize(new Dimension(150, 30));
        resetBoardButton.addActionListener(menuListener);
        deathMatchCheckBox = new JCheckBox("Death match");
        deathMatchCheckBox.addActionListener(menuListener);
        deathMatchCheckBox.setMnemonic(KeyEvent.VK_D);
        playerTwoCheckBox = new JCheckBox("Player 2");
        playerTwoCheckBox.addActionListener(menuListener);
        playerTwoCheckBox.setMnemonic(KeyEvent.VK_O);
        makeMovePanelLeftSide.add(makeMoveButton);
        makeMovePanelRightSide.add(deathMatchCheckBox);
        makeMovePanelRightSide.add(playerTwoCheckBox);
        makeMovePanel.add(makeMovePanelLeftSide);
        makeMovePanel.add(makeMovePanelRightSide);
        resetBoardPanel.add(resetBoardButton);
        rightArea.add(makeMovePanel);
        rightArea.add(resetBoardPanel);

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
        
        statusBar = new JTextField();
        statusBar.setFont(new Font("Courier New", Font.BOLD, 40));
        statusBar.setEditable(false);
        
        body.add(avaBoard);
        body.add(rightArea);
        add(statusBar, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
                
    }
}
