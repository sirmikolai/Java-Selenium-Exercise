package exercise1;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Operation {

    public ArrayList<Integer> getEvenNumbersFromArrayList(ArrayList<Integer> numbers) {
        return numbers.stream().filter(v -> v%2==0).collect(Collectors.toCollection(ArrayList::new));
    }
}
