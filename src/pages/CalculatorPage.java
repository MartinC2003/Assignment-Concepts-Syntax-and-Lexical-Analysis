package pages;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorPage extends JPanel{
    public CalculatorPage() {
        setLayout(new FlowLayout());
        setBackground(Color.WHITE);
        
        JLabel label = new JLabel("Calculator Page");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label);
        
        double sum = 0;
        int count=0; 
        
        //add like function here 
        JTextField input = new JTextField(20);
        add(input);
        
        JButton calculate = new JButton("Calculate");
        add(calculate);
    }


}
