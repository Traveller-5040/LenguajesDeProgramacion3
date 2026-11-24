package act_command;

public class OffTv implements Command {
    private Televisor tv;
    public OffTv(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.apagar();
    }
}
