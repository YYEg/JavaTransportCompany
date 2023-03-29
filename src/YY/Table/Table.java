package YY.Table;
import YY.Data.transportCompany;
import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class Table {
    public JTable jTable;
    public MyTableModel tableModel;

    public TableRowSorter<MyTableModel> sorter;

    public Table(){
        jTable = new JTable();
        tableModel = new MyTableModel(new transportCompany());
        jTable.setModel(tableModel);

        sorter = new TableRowSorter<>(tableModel);
        jTable.setRowSorter(sorter);
    }

}
