package factorial;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTest {

    @DataProvider
    public Object[][] factorialData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {5, 120},
        };
    }

    @Test(dataProvider = "factorialData")
    public void test1(int a, long expected) {
        long actual = Factorial.calculateFactorial(a);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void test2() {
        Factorial.calculateFactorial(-1);
    }
}