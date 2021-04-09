import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Gui{

    public Gui(){
        JFrame frame = new JFrame();

        JButton button = new JButton("Click me bro");
        JLabel label = new JLabel("Number of Clicks");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);



        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tutorial GUI");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Gui();
    }
}