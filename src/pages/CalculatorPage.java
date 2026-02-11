package pages;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import calculatorpage.InputPanel;
import calculatorpage.ResultsPanel;

public class CalculatorPage extends JPanel{

    /*Program gui is intialized here
    Used Swing and Netbeans IDE's built in designer 
    to design the gui of the application. Once the design in 
    Netbeans was completed I split the two main JPanel Components
    into classes.
    */
    private InputPanel inputPanel;
    private ResultsPanel resultsPanel;
    

    public CalculatorPage() {
        initComponents();
    }

    private void initComponents() {
        setSize(new Dimension(546, 336)); 

        resultsPanel = new ResultsPanel();      
        inputPanel = new InputPanel(resultsPanel);

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
