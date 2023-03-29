package YY.btn;

import YY.View.MainWindow;
import YY.message.Message;
import YY.message.MessageSender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.PatternSyntaxException;

public class BtnAction {
    public static JTextField txtFindField = new JTextField("Название товара");

    public static void callAdd(MainWindow window) { //окно добавления ТС
        JDialog addDialog = new JDialog(window, "Новое Транспортное средство", true);
        addDialog.setSize(600, 200);
        addDialog.setLocationRelativeTo(window);

        JPanel addPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        JLabel typeLabel = new JLabel("Тип ТС");
        addPanel.add(typeLabel);
        JLabel nameLabel = new JLabel("Марка/Вид");
        addPanel.add(nameLabel);

        JComboBox<String> typesBox = new JComboBox<>(
                new String[] {"Автомобиль", "Поезд"});
        addPanel.add(typesBox);

        JTextField nameField = new JTextField("Название");
        addPanel.add(nameField);

        addDialog.add(addPanel, BorderLayout.NORTH);

        // Кнопка потведжения добавления товара
        JButton appendButton = new JButton("Добавить");
        appendButton.addActionListener(e -> {
            if (nameField.getText().isEmpty()) {
                MessageSender.showMessage(window, Message.CONTAINS_EMPTY_FIELD);
            } else {
                window.jTable.tableModel.add((String) typesBox.getSelectedItem(), nameField.getText());
                addDialog.dispose();
            }
        });

        addDialog.add(appendButton, BorderLayout.SOUTH);

        addDialog.setVisible(true);
    }

    public static void Delete(MainWindow window) {
        try{
            window.jTable.tableModel.delete(window.jTable.jTable.getSelectedRow());
        }
        catch (IndexOutOfBoundsException ex){
            MessageSender.showMessage(window, Message.EMPTY_RECORD_CHOSEN);
        }
    }

    public static void reset(MainWindow window){
        window.jTable.sorter.setRowFilter(null);
        txtFindField.setText("");
    }

    public static void findAction(MainWindow window){
        String text = txtFindField.getText();
        if (text.length() == 0) {
            window.jTable.sorter.setRowFilter(null);
        } else {
            try {
                window.jTable.sorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (PatternSyntaxException pse) {
                System.err.println("*_*Нето*_*");
            }
        }
    }
}
