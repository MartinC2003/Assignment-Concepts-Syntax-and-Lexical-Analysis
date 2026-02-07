package pages;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class AboutPage extends JPanel{
    public AboutPage() {
        setLayout(new FlowLayout());
        setBackground(Color.WHITE);
        
        JLabel label = new JLabel("About Page");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label);
        
        JLabel info = new JLabel("Your app information goes here");
        add(info);
    }
}
