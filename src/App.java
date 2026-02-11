import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import pages.CalculatorPage;

public class App extends JFrame {
    public App() {
        setTitle("Concepts syntax and Lexical Analysis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(546, 336);
        add(new CalculatorPage());
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App());
    }
}