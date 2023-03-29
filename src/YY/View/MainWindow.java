package YY.View;
import YY.Table.Table;
import YY.btn.btn;
import YY.panel.Panel;
import javax.swing.*;
import java.awt.*;


public class MainWindow extends JFrame {

    public Table jTable;
    public btn buttons;
    public Panel panel;
    public JScrollPane jScrollPane;

    public MainWindow(){
        super("Транспортная компания Орион"); //конструктор окна
        jTable = new Table();
        buttons = new btn(this);
        panel = new Panel(buttons);

        jScrollPane = new JScrollPane(jTable.jTable);

        this.add(panel.panel, BorderLayout.SOUTH);
        this.add(jScrollPane, BorderLayout.NORTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 400);
        this.setLocationRelativeTo(null); //показывается в середине
        this.setVisible(true);
    }
}
