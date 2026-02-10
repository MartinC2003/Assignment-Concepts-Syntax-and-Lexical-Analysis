package calculatorpage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
public class ResultsPanel extends JPanel {
    private InputPanel  inputPanel;  

    private JLabel resultsTitle;
    private JLabel resultsSubtitle;
    private JLabel countOutputLabel;
    private JLabel sumOutputLabel;
    private JLabel averageOutputLabel;
    private JButton resetBtn;
    private JSeparator separator;

    public ResultsPanel() {
        initComponents();
        buttonListeners();
    }
    
    private void initComponents() {
        setBackground(new Color(30, 37, 41));
        setForeground(new Color(255, 255, 255));
        
        resultsTitle = new JLabel("Results");
        resultsTitle.setFont(new Font("HaasGrot Text 55 Md Trial", Font.PLAIN, 24));
        resultsTitle.setForeground(new Color(255, 255, 255));
        
        resultsSubtitle = new JLabel("Results will be shown here");
        resultsSubtitle.setFont(new Font("HaasGrot Text 55 Md Trial", Font.PLAIN, 14));
        resultsSubtitle.setForeground(new Color(255, 255, 255));
        
        countOutputLabel = new JLabel("Count Output: 0");
        countOutputLabel.setFont(new Font("HaasGrot Text 55 Rm Trial", Font.BOLD, 14));
        countOutputLabel.setForeground(new Color(255, 255, 255));
        
        sumOutputLabel = new JLabel("Sum Output: 0");
        sumOutputLabel.setFont(new Font("HaasGrot Text 55 Rm Trial", Font.BOLD, 14));
        sumOutputLabel.setForeground(new Color(255, 255, 255));
        
        averageOutputLabel = new JLabel("Average Output: 0");
        averageOutputLabel.setFont(new Font("HaasGrot Text 55 Rm Trial", Font.BOLD, 14));
        averageOutputLabel.setForeground(new Color(255, 255, 255));
        
        resetBtn = new JButton("Reset");
        separator = new JSeparator();
        
        JPanel countPanel = createOutputPanel(countOutputLabel);
        JPanel sumPanel = createOutputPanel(sumOutputLabel);
        JPanel averagePanel = createOutputPanel(averageOutputLabel);
        
        
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
                    .addComponent(averagePanel, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(resetBtn, GroupLayout.Alignment.TRAILING))
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
                .addComponent(resetBtn)
                .addGap(30)
        );
    }
    
    private JPanel createOutputPanel(JLabel label) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        
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
        
        return panel;
    }
    
    // Getter methods
    public JButton getResetBtn() {
        return resetBtn;
    }
    
    public JLabel getCountOutputLabel() {
        return countOutputLabel;
    }
    
    public JLabel getSumOutputLabel() {
        return sumOutputLabel;
    }
    
    public JLabel getAverageOutputLabel() {
        return averageOutputLabel;
    }
    
    // Setter methods; gets the assigned variables from the calculator class
    public void setCount(int count) {
        countOutputLabel.setText("Count Output: " + count);
    }
    
    public void setSum(double sum) {
        sumOutputLabel.setText("Sum Output: " + sum);
    }
    
    public void setAverage(double average) {
        averageOutputLabel.setText("Average Output: " + String.format("%.2f", average));
    }
    
    private void buttonListeners() {
        resetBtn.addActionListener(e -> clearArray());
    }

    public void clearArray() {
        inputPanel.numbers.clear();
    }
    public void updateAllResults(int count, double sum, double average) {
        setCount(count);
        setSum(sum);
        setAverage(average);
    }
}