package act_command;

public class CommandTest {
    public static void main(String[] args) {
        Televisor tv1 = new Televisor();
        RemoteControl ctrl = new RemoteControl();

        ctrl.setCommand(new OnTv(tv1));
        ctrl.pressButton();

        ctrl.setCommand(new SwitchChannel(tv1));
        ctrl.pressButton();

        ctrl.setCommand(new IncreaseVol(tv1));
        ctrl.pressButton();

        ctrl.setCommand(new DecreaseVol(tv1));
        ctrl.pressButton();

        ctrl.setCommand(new OffTv(tv1));
        ctrl.pressButton();
    }
}
