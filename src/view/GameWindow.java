package view;

public class GameWindow {
    public static MainMenu mainMenu;
    public HVAMenu hvaMenu;
    public static AVAMenu avaMenu;

    public GameWindow() {
        mainMenu = new MainMenu();
        hvaMenu = new HVAMenu();
        avaMenu = new AVAMenu();
        mainMenu.create();
        hvaMenu.create();
        avaMenu.create();
    }

    public void displayMainMenu() {
        mainMenu.setVisible(true);
        hvaMenu.setVisible(false);
        avaMenu.setVisible(false);
    }
    
    public void displayHVAMenu() {
        mainMenu.dispose();
        hvaMenu.setVisible(true);
        avaMenu.setVisible(false);
    }
    
    public void displayAVAMenu() {
        mainMenu.setVisible(false);
        hvaMenu.setVisible(false);
        avaMenu.setVisible(true);        
    }
}
