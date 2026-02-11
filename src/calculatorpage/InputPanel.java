package calculatorpage;


import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import components.Calculator;
import components.Calculator.TokenContainer;


public class InputPanel extends JPanel {
    private Calculator calculator;    
    private ResultsPanel resultsPanel; 

    private JSeparator separator1;
    private JSeparator separator2;
    private JSeparator separator3;


    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JTextField inputTextField;
    private JButton addNumberBtn;
    private JLabel outputMessageTitle;
    private JLabel outputMessage;
    private JLabel arrayOutputLabel;
    private JButton submitBtn;

    public List<Double> numbers = new ArrayList<>();


    public InputPanel(ResultsPanel resultsPanel) {
        initComponents();
        displayArray();
        buttonListeners();
        calculator = new Calculator();
        this.resultsPanel = resultsPanel;
    }

    private void initComponents() { 
        titleLabel = new JLabel("Calculator");
        titleLabel.setFont(new Font("HaasGrot Text 55 Rm Trial", Font.PLAIN, 24));
        
        descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(new Font("HaasGrot Text 55 Rm Trial", Font.PLAIN, 14));
        
        inputTextField = new JTextField("");
        inputTextField.setPreferredSize(new Dimension(140, 25));
        
        addNumberBtn = new JButton("Add Number");
        
        outputMessageTitle = new JLabel("Output Message Title");
        outputMessageTitle.setFont(new Font("HaasGrot Text 55 Rm Trial", Font.PLAIN, 14));
        
        outputMessage = new JLabel("Output Message");
        outputMessage.setFont(new Font("HaasGrot Text 55 Rm Trial", Font.ITALIC, 12));
        
        separator1 = new JSeparator();
        separator2 = new JSeparator();
        separator3 = new JSeparator(); 

        arrayOutputLabel = new JLabel("Array Output");
        arrayOutputLabel.setFont(new Font("HaasGrot Text 55 Rm Trial", Font.PLAIN, 12));
        
        submitBtn = new JButton("Submit");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(false);
        
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(separator1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(descriptionLabel)
                    .addComponent(separator2, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputTextField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                        .addGap(18)
                        .addComponent(addNumberBtn))
                    .addComponent(outputMessageTitle)
                    .addComponent(outputMessage)
                    .addComponent(separator3, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(arrayOutputLabel)
                    .addComponent(submitBtn, GroupLayout.Alignment.TRAILING))
                .addGap(20)
        );
        
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(30)
                .addComponent(titleLabel)
                .addGap(10)
                .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5)
                .addComponent(descriptionLabel)
                .addGap(10)
                .addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(inputTextField)
                    .addComponent(addNumberBtn))
                .addGap(10)
                .addComponent(outputMessageTitle)
                .addGap(18)
                .addComponent(outputMessage)
                .addGap(10)
                .addComponent(separator3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5)
                .addComponent(arrayOutputLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(submitBtn)
                .addGap(30)
        );
    }
    
    // Getter methods
    public JTextField getInputTextField() {
        return inputTextField;
    }
    
    public JButton getAddNumberBtn() {
        return addNumberBtn;
    }
    
    public JButton getsubmitBtn() {
        return submitBtn;
    }
    
    public JLabel getOutputMessageTitle() {
        return outputMessageTitle;
    }
    
    public JLabel getOutputMessage() {
        return outputMessage;
    }
    
    public JLabel getArrayOutputLabel() {
        return arrayOutputLabel;
    }
    
    
    // Setter methods; 
    public void setOutputMessage(String title, String message) {
        outputMessageTitle.setText(title);
        outputMessage.setText(message);
    }

    public void setArrayMessage(String message) {
        arrayOutputLabel.setText(message);
    }

    private void buttonListeners() {
        addNumberBtn.addActionListener(e -> onAddNumberClicked());
        submitBtn.addActionListener(e -> CalculateArray());
    }
    
    private void onAddNumberClicked() {
        String userInput = inputTextField.getText().trim();
        TokenContainer token = Calculator.infoAnalyzer(userInput);
        
    switch (token.type) {

        case NUMBER:
            double value = Double.parseDouble(token.userInput);
            numbers.add(value);
            setOutputMessage("Valid Number", "Added: " + value);
            displayArray();
            inputTextField.setText("");
            break;

        case INVALIDINPUT:
            setOutputMessage("Invalid Input", "Please enter a valid number");
            break;

        default:
            setOutputMessage("Unexpected exception", "Please try again");
            break;
        }
    }
    
    private void CalculateArray() {
        if (numbers.isEmpty()) {
            setArrayMessage(
                "Please add numbers before submitting"
            );
            return;
        }
        calculator.calculateAverage(numbers);
        resultsPanel.setCount(calculator.count);
        resultsPanel.setSum(calculator.sum);
        resultsPanel.setAverage(calculator.average);
    }
    
    private void displayArray() {
        if (numbers.isEmpty()) {
        setArrayMessage("Please add your numbers, Added numbers will be displayed here.");
        return;
    }
        setArrayMessage("Array: " + numbers.toString());
    }
    
    private void clearArray() {
        numbers.clear();
        resultsPanel.clearResults();
        displayArray(); 
    }
    
}