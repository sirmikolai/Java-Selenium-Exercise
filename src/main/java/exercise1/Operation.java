package exercise1;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Operation {

    private static final Logger logger = Logger.getLogger(Operation.class);

    public ArrayList<Integer> getEvenNumbersFromArrayList(ArrayList<Integer> numbers) {
        logger.info("Get even numbers from array list");
        return numbers.stream().filter(v -> v%2==0).collect(Collectors.toCollection(ArrayList::new));
    }
}
