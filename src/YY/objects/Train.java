package YY.objects;

public class Train extends Vehicle {

    public Train(String name) {
        super(name);
        setType("Поезд");
    }
    @Override
    public String processOperation() {
        return (getType() + getName() + " отправляется в " + trainGoal());
    }
    private String trainGoal() {
        return getObjetName();
    }
}
