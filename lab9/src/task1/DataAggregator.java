package task1;

public class DataAggregator implements Observer{
    StepCountStrategy stepCountStrategy;

    public DataAggregator(StepCountStrategy strategy) {
        this.stepCountStrategy = strategy;
    }
    @Override
    public void message(SensorData data) {
        System.out.println(this.stepCountStrategy.getStrategyDescription() + ", total step count: " + this.stepCountStrategy.getTotalSteps());
    }
}
