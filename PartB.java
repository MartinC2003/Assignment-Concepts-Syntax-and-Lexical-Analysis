import java.awt.*;
import javax.swing.*;

public class PartB {
  static int[] x;
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Demo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel root = new JPanel(new BorderLayout(8, 8));
      root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      JTextField field = new JTextField(20);
      JButton button = new JButton("Greet");

      //root.add(top, BorderLayout.NORTH);
      root.add(new JScrollPane(new JTextArea(10, 40)), BorderLayout.CENTER);


      frame.setContentPane(root);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    });
  }
}