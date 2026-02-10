package components;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Sidebar extends JPanel{
    private JButton programBtn;
    private JButton aboutBtn;
    private ContentArea contentArea;
    
    public Sidebar() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        
        programBtn = createButton("Program");
        aboutBtn = createButton("About");
        
        add(Box.createVerticalStrut(20));
        add(programBtn);
        add(Box.createVerticalStrut(20));
        add(aboutBtn);
        add(Box.createVerticalGlue());
    }
    
    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        return btn;
    }
    

    public void setContentArea(ContentArea contentArea) {
        programBtn.addActionListener(e -> contentArea.showPage("calculator"));
        aboutBtn.addActionListener(e -> contentArea.showPage("about"));
    }
}
