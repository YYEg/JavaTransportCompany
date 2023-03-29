package YY.btn;

import YY.View.MainWindow;
import javax.swing.*;

public class btn {
    public JButton addButton, deleteButton, searchButton, resetButton;

    public btn(MainWindow window){

        addButton = new JButton("Добавить товар");
        addButton.addActionListener(e -> BtnAction.callAdd(window));

        deleteButton = new JButton("Удалить товар");
        deleteButton.addActionListener(e -> BtnAction.Delete(window));

        searchButton = new JButton("Поиск");
        searchButton.addActionListener(e -> BtnAction.findAction(window));

        resetButton = new JButton("Сброс");
        resetButton.addActionListener(e -> BtnAction.reset(window));
    }
}
