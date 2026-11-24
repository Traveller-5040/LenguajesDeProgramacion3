package act_command;

public class OnTv implements Command {
    private Televisor tv;
    public OnTv(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.encender();
    }
}
