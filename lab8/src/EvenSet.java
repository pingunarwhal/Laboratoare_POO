import java.util.HashSet;

public class EvenSet extends HashSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        if (integer % 2 == 0)
            return super.add(integer);
        return false;
    }
}