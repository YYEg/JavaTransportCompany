package YY.panel;

import YY.btn.BtnAction;
import YY.btn.btn;

import javax.swing.*;
import java.awt.*;

public class Panel {
    public JPanel panel;
    public Panel(btn buttons){
        // Панель меню
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(buttons.addButton);
        panel.add(buttons.deleteButton);

        panel.add(BtnAction.txtFindField);
        panel.add(buttons.searchButton);
        panel.add(buttons.resetButton);

    }
}
