public class CommandPatternTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("Light Status:");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("Light Status:");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
