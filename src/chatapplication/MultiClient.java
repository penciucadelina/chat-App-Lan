package chatapplication;
import javax.swing.*;
import static chatapplication.MulticastClient.name;

/**
 * @author Adelina Penciuc
 */
public class MultiClient {
    MultiClient() {
        name = JOptionPane.showInputDialog("Please enter your name:");
        int count = 0;
        while (name == null || name.equals("")) {
            if (name == null) {
                new ChatApp().setVisible(true);
                count++;
                break;
            } else if (name.equals("")) {
                JOptionPane.showMessageDialog(new ChatApp(), "Please enter a proper name");
                name = JOptionPane.showInputDialog("Please enter your name");
            }

        }
        if (count == 0) {
            new MulticastClient().setVisible(true);
            Thread t1 = new Thread(new Client());
            t1.start();

        }
    }
}
