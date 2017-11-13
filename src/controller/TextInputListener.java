    

package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import view.Menu;


public class TextInputListener implements DocumentListener {

    @Override
    public void insertUpdate(DocumentEvent e) {
        warn(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        warn(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        warn(e);
    }

    public void warn(DocumentEvent e) {
        Document doc = (Document) e.getDocument();
        
        if (Integer.parseInt(Menu.readThresholdTime.getText())<=0){
            System.out.println("not integer");
        }
     }
}
