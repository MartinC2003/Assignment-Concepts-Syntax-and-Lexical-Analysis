package calculatorpage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;

public class ResultsPanel extends JPanel {

    /*This JPanel class takes in the calcators output and 
    displays it back to be shown to the user*/

    private JLabel resultsTitle;
    private JLabel resultsSubtitle;
    private JLabel countOutputLabel;
    private JLabel sumOutputLabel;
    private JLabel averageOutputLabel;
    private JSeparator separator;

    //Constructor 
    public ResultsPanel() {
        initComponents();
    }
    
    private void initComponents() {
    
        setBackground(new Color(30, 37, 41));  
        setForeground(new Color(255, 255, 255));  
        
        resultsTitle = new JLabel("Results");
        resultsTitle.setFont(new Font("HaasGrot Text 65 Md Trial", Font.PLAIN, 24));
        resultsTitle.setForeground(new Color(255, 255, 255));
        
        resultsSubtitle = new JLabel("Results will be shown here");
        resultsSubtitle.setFont(new Font("HaasGrot Text 65 Md Trial", Font.PLAIN, 14));
        resultsSubtitle.setForeground(new Color(255, 255, 255));
        
        separator = new JSeparator();
        

        JPanel countPanel = createOutputPanel(new Color(183, 165, 126), "Count Output: 0");
        countOutputLabel = (JLabel) countPanel.getComponent(0);
        
        JPanel sumPanel = createOutputPanel(new Color(183, 165, 126), "Sum Output: 0");
        sumOutputLabel = (JLabel) sumPanel.getComponent(0);
        
        JPanel averagePanel = createOutputPanel(new Color(183, 165, 126), "Average Output: 0");
        averageOutputLabel = (JLabel) averagePanel.getComponent(0);
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(false);
        
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(resultsTitle)
                    .addComponent(resultsSubtitle)
                    .addComponent(separator, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(countPanel, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(sumPanel, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(averagePanel, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addGap(20)
        );
        
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(30)
                .addComponent(resultsTitle)
                .addGap(5)
                .addComponent(resultsSubtitle, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5)
                .addComponent(countPanel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(sumPanel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(averagePanel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGap(30)
        );
    }

    //helper method for ui 
    private JPanel createOutputPanel(Color backgroundColor, String labelText) {
        JPanel panel = new JPanel();

        panel.setBackground(backgroundColor);
        panel.setForeground(new Color(255, 255, 255));
        
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("HaasGrot Text 55 Rm Trial", Font.BOLD, 14));
        label.setForeground(new Color(255, 255, 255));
        
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(false);
        layout.setAutoCreateContainerGaps(false);
        
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        panel.add(label);
        return panel;
    }
    
    // Getter methods
    public JLabel getCountOutputLabel() {
        return countOutputLabel;
    }
    
    public JLabel getSumOutputLabel() {
        return sumOutputLabel;
    }
    
    public JLabel getAverageOutputLabel() {
        return averageOutputLabel;
    }
    
    // Setter methods
    public void setCount(int count) {
        countOutputLabel.setText("Count: " + count);
    }
    
    public void setSum(double sum) {
        sumOutputLabel.setText("Sum: " + sum);
    }
    
    public void setAverage(double average) {
        averageOutputLabel.setText("Average: " + String.format("%.2f", average));
    }
    
    //clears the calculator's output 
    public void clearResults() {
        setCount(0);
        setSum(0);
        setAverage(0);
    }
}