package testngtests;

import exercise1.Operation;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise1Test {

    private Operation operation = new Operation();

    @BeforeGroups(groups = "emptyList")
    public void beforeEmptyListTest() {
        System.out.println("Test checkingTheMethod_GetEvenNumbersFromArray_WhenArrayListIsEmpty started.");
    }

    @Test(groups = "emptyList")
    public void checkingTheMethod_GetEvenNumbersFromArray_WhenArrayListIsEmpty() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> result = operation.getEvenNumbersFromArrayList(arrayList);
        Assert.assertEquals(result.size(), 0);
    }

    @AfterGroups(groups = "emptyList")
    public void afterEmptyListTest() {
        System.out.println("Test checkingTheMethod_GetEvenNumbersFromArray_WhenArrayListIsEmpty ended.");
    }

    @BeforeGroups(groups = "notEmptyList")
    public void beforeNotEmptyListTest() {
        System.out.println("Test checkingTheMethod_GetEvenNumbersFromArray_WhenArrayListIsNotEmpty started.");
    }

    @Test(groups = "notEmptyList")
    public void checkingTheMethod_GetEvenNumbersFromArray_WhenArrayListIsNotEmpty() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(4, 5, 7, 15, 17, 20, 21, 23, 30, 31, 32, 40, 41, 42, 48, 58, 59, 60, 65, 69));
        ArrayList<Integer> result = operation.getEvenNumbersFromArrayList(arrayList);
        Assert.assertEquals(result.size(), 9);
        Assert.assertEquals(result, new ArrayList<Integer>(Arrays.asList(4, 20, 30, 32, 40, 42, 48, 58, 60)));
    }

    @AfterGroups(groups = "notEmptyList")
    public void afterNotEmptyListTest() {
        System.out.println("Test checkingTheMethod_GetEvenNumbersFromArray_WhenArrayListIsNotEmpty ended.");
    }
}
