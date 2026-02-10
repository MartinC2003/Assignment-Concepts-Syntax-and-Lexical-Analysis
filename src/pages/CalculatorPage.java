package pages;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import calculatorpage.InputPanel;
import calculatorpage.ResultsPanel;

public class CalculatorPage extends JPanel{

    
    private InputPanel inputPanel;
    private ResultsPanel resultsPanel;
    

    public CalculatorPage() {
        initComponents();
    }

    private void initComponents() {
        setSize(new Dimension(546, 336));
        setMinimumSize(new Dimension(546, 336));
        setPreferredSize(new Dimension(546, 336));

        inputPanel = new InputPanel();
        resultsPanel = new ResultsPanel();

        setLayout(new GridLayout(1, 2));
        add(inputPanel);
        add(resultsPanel);

    }
    
    public InputPanel getInputPanel() {
        return inputPanel;
    }
    
    public ResultsPanel getResultsPanel() {
        return resultsPanel;
    }

}
