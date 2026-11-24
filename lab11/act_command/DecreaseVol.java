package act_command;

public class DecreaseVol implements Command {
    private Televisor tv;
    public DecreaseVol(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.bajarVolumen();
    }
}
