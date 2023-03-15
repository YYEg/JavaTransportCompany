package YY.objects;

public class Ecspress extends Vehicle {

    public Ecspress(String name) {
        super(name);
        setType("Экспрес");
    }
    @Override
    public String processOperation() {
        return (getType() + " под названием " + getName() + " построил новый самолет под названием " + ecspressGoal());
    }
    private String ecspressGoal() {
        return getObjetName();
    }
}
