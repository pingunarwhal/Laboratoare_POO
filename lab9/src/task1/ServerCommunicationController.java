package task1;

public class ServerCommunicationController implements Observer{
    @Override
    public void message(SensorData data) {
        ServerMessage serverMessage = new ServerMessage(data.getStepsCount(), Utils.getClientId(), data.getTimestamp());
        System.out.println("Generated server message: " + serverMessage.toString());
    }
}
