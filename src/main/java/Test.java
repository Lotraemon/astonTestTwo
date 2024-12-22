public class Test {
    public static int calculateFactorial(int i) {
        int result = 1;
        for (int j = 1; j <= i; j++) {
            result *= j;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculateFactorial(-5));
    }
}//
