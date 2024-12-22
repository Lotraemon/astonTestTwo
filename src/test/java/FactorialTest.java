import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FactorialTest {

    @CsvSource({
            "0,1",
            "1,1",
            "3,5",
            "5,120"
    })
    @ParameterizedTest
    public void test1(int input, long expected) {
        Assertions.assertEquals(expected, Factorial.calculateFactorial(input), "Ошибка с числом: " + input);
    }

    @Test
    public void test2() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Factorial.calculateFactorial(-1));
    }
}
