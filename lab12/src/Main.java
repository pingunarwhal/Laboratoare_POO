import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

interface CalculatorBase {
    class NullParameterException extends RuntimeException {
    }

    class UnderflowException extends RuntimeException {
    }

    class OverflowException extends RuntimeException {
    }

    Double add(Double nr1, Double nr2);

    Double divide(Double nr1, Double nr2);

    Double average(Collection<Double> numbers);
}

class CalculatorClass implements CalculatorBase {

    @Override
    public Double add(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        } else if (nr1 == Double.POSITIVE_INFINITY || nr2 == Double.POSITIVE_INFINITY || nr1 + nr2 == Double.POSITIVE_INFINITY) {
            throw new OverflowException();
        } else if (nr1 == Double.NEGATIVE_INFINITY || nr2 == Double.NEGATIVE_INFINITY || nr1 + nr2 == Double.NEGATIVE_INFINITY) {
            throw new UnderflowException();
        }
        return nr1 + nr2;
    }

    @Override
    public Double divide(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        } else if (nr2 == 0d && nr1 > 0d) {
            throw new OverflowException();
        } else if (nr2 == 0d && nr1 < 0d) {
            throw new UnderflowException();
        }
        return nr1 / nr2;
    }

    @Override
    public Double average(Collection<Double> numbers) {
        Double sum = 0d;
        List<Double> arr = numbers.stream().collect(Collectors.toList());
        for (int i = 0; i < numbers.size(); i ++) {
            sum = add(sum, arr.get(i));
        }
        return divide(sum, (double) numbers.size());
    }
}

public class Main {
    public static void main(String[] args) {
        CalculatorClass calculator = new CalculatorClass();

        System.out.println(calculator.add(2d, 3d));
        System.out.println(calculator.divide(9d, 4d));
        System.out.println(calculator.average(Arrays.asList(1d, 2d, 3d, 4d)));


        try {
            calculator.add(null, Double.MAX_VALUE);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.add(Double.MAX_VALUE, null);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.add(null, null);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.add(Double.MAX_VALUE, Double.MAX_VALUE);
        } catch (CalculatorBase.OverflowException e) {
            System.out.println("Overflow Exception thrown!");
        }

        try {
            calculator.add(-Double.MAX_VALUE, -Double.MAX_VALUE);
        } catch (CalculatorBase.UnderflowException e) {
            System.out.println("Underflow Exception thrown!");
        }

        try {
            calculator.divide(null, Double.MAX_VALUE);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.divide(Double.MAX_VALUE, null);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.divide(null, null);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.divide(null, null);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.divide(1d, 0d);
        } catch (CalculatorBase.OverflowException e) {
            System.out.println("Overflow Exception thrown!");
        }

        try {
            calculator.divide(-1d, 0d);
        } catch (CalculatorBase.UnderflowException e) {
            System.out.println("Underflow Exception thrown!");
        }

        try {
            calculator.average(Arrays.asList(1d, 2d, Double.MAX_VALUE, Double.MAX_VALUE));
        } catch (CalculatorBase.OverflowException e) {
            System.out.println("Overflow Exception thrown!");
        }

        try {
            calculator.average(Arrays.asList(1d, -100d, -Double.MAX_VALUE, -Double.MAX_VALUE));
        } catch (CalculatorBase.UnderflowException e) {
            System.out.println("Underflow Exception thrown!");
        }
    }
}
