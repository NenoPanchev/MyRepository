package ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 18, 2, -1);

        Integer maxInteger = ListUtils.getMax(integers);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "c", "b");

        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(integers));
        System.out.println(ListUtils.getMin(strings));
        System.out.println(ListUtils.getMax(strings));
    }
}
