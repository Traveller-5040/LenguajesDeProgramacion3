package act_command;

public class SwitchChannel implements Command {
    private Televisor tv;
    public SwitchChannel(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.cambiarCanal();
    }
}
