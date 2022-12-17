package task1;

public class ConsoleLogger implements Observer{
    @Override
    public void message(SensorData data) {
        System.out.println("New sensor data: " + data.toString());
    }
}
