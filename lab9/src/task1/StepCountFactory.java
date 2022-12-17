package task1;

public class StepCountFactory {
    public static StepCountStrategy createStrategy (String type, DataRepository dataRepository) {
        if (type.equals("basic")) {
            return new BasicStepCountStrategy(dataRepository);
        }
        return new FilteredStepCountStrategy(dataRepository);
    }
}
