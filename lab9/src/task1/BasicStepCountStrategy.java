package task1;

public class BasicStepCountStrategy implements StepCountStrategy{
    DataRepository data;

    public BasicStepCountStrategy(DataRepository dataRepository) {
        this.data = dataRepository;
    }

    @Override
    public int getTotalSteps() {
        int steps = 0;
        for (SensorData i : data.getDataList()) {
            steps += i.getStepsCount();
        }
        return steps;
    }

    @Override
    public String getStrategyDescription() {
        return "Basic strategy";
    }
}
