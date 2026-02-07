import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import components.ContentArea;
import components.Sidebar;
import pages.AboutPage;
import pages.CalculatorPage;

public class App  extends JFrame{
        public App() {
        setTitle("Concepts syntax and Lexical Analysis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
       
        // Create sidebar and content area
        Sidebar sidebar = new Sidebar();
        ContentArea contentArea = new ContentArea();
        
        // Link sidebar buttons to content area
        sidebar.setContentArea(contentArea);
        setLayout(new java.awt.BorderLayout());
        add(sidebar, java.awt.BorderLayout.WEST);
        add(contentArea, java.awt.BorderLayout.CENTER);
        contentArea.addPage(new CalculatorPage(), "calculator");
        contentArea.addPage(new AboutPage(), "about");

        add(contentArea);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App());
    }
}
