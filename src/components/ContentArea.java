package components;
import java.awt.CardLayout;

import javax.swing.JPanel;

public class ContentArea extends JPanel{
    private CardLayout cardLayout; 
   
    public ContentArea() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
    } 
    
    public void addPage(JPanel page, String name) {
       this.add(page, name); 
    }

    public void showPage(String name) {
        cardLayout.show(this, name);
    }
}
