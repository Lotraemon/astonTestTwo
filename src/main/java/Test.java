public class Test {

    public static int transformArray(String[][] array) throws MyArrayDataException, MyArraySizeException {

        int arraySum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4) {
                throw new MyArraySizeException("Размер массива не 4х4");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    arraySum += Integer.parseInt(array[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException("Ошибка конвертации по индексу: [" + i + ":" + j + "] Значение: " + array[i][j]);
                }
            }
        }
        return arraySum;
    }

    public static void main(String[] args) {
        String[][] array0 = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] array1 = {{"1", "1", "1", "X"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] array2 = {{"1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        try {
            System.out.println("Сумма массива: " + transformArray(array0));
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Сумма массива: " + transformArray(array1));
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Сумма массива: " + transformArray(array2));
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }
    }
}
