package YY.Table;


import YY.Data.Vehicle;
import YY.Data.Train;
import YY.Data.Car;
import YY.Data.transportCompany;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
    private final transportCompany data;

    public MyTableModel(transportCompany transportCompany){
        this.data = transportCompany;
    }

    @Override
    public  String getColumnName(int column){
        return switch (column) {
            case 0 -> "Тип";
            case 1 -> "Вид";
            case 2 -> "Марка";
            default -> "";
        };
    }

    @Override
    public int getRowCount() {  //Колличество строк
        return data.getCount();
    }

    @Override
    public int getColumnCount() {  //Колличество столбцов
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return data.getVehicle(rowIndex).getType();
            case 1: {
                Vehicle p = data.getVehicle(rowIndex);
                if(p instanceof Train){
                    return ((Train) p).getForm();
                }else{
                    return "-";
                }
            }
            case 2: {
                Vehicle p = data.getVehicle(rowIndex);
                if(p instanceof Car){
                    return ((Car)p).getBrand();
                }else{
                    return "-";
                }
            }
        }
        return "default";
    }

    public void delete(int index){
        this.data.remove(index);
        fireTableDataChanged();
    }

    public void add(String type, String something){  //добавление
        switch(type){
            case "Автомобиль" -> this.data.addVehicle(new Car(type, something));
            case "Поезд" -> this.data.addVehicle(new Train(type, something));
        }
        fireTableDataChanged();
    }

    /*@Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }*/
}
