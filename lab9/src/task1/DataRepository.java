package task1;

import java.util.ArrayList;

public class DataRepository {
    private ArrayList<SensorData> dataList = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }
    public void addData(SensorData dataRecord) {
        dataList.add(dataRecord);

        for (Observer i : this.observers) {
            i.message(dataRecord);
        }
    }

    public ArrayList<SensorData> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<SensorData> dataList) {
        this.dataList = dataList;
    }
}
