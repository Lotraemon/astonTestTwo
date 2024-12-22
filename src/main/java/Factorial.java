public class Factorial {
    public static long calculateFactorial(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Отрицательное число");
        }
        long result = 1;
        for (int j = 1; j <= i; j++) {
            result *= j;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculateFactorial(3));
    }
}
