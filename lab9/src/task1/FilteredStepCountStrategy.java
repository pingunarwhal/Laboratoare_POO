package task1;

public class FilteredStepCountStrategy implements StepCountStrategy{
    DataRepository data;

    public FilteredStepCountStrategy(DataRepository dataRepository) {
        this.data = dataRepository;
    }

    @Override
    public int getTotalSteps() {
        int steps = 0;
        for (SensorData i : data.getDataList()) {
            if (i.getStepsCount() > 0 && i.getStepsCount() < Utils.MAX_STEP_DIFFERENCE) {
                steps += i.getStepsCount();
            }
        }
        return steps;
    }

    @Override
    public String getStrategyDescription() {
        return "Filtered strategy";
    }
}
