package act_command;

public class IncreaseVol implements Command {
    private Televisor tv;
    public IncreaseVol(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.subirVolumen();
    }
}
