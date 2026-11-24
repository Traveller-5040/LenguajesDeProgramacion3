package act_observer;

public class UObserver implements Observer {
    private String name;

    public UObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(this.name + " recibio un correo: " + message);
    }
}
