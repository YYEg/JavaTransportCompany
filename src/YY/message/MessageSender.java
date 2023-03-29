package YY.message;

import javax.swing.*;
import java.awt.*;

public class MessageSender {
    public static void showMessage(Component component, Message message) { // Диалоговое сообщение
        JOptionPane.showMessageDialog(component, message);
    }
}
