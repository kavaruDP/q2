package ru.geekbrains.q2.exception;

/*  В стандартном пакете java.lang определен ряд стандартных исключений.
    Ниже приведены некоторые часто встречающиеся подклассы unchecked исключений,
    производные от класса RuntimeException:
    ArrayIndexOutOfВoundsException    Выход индекса за пределы массива
    ClassCastException                Неверное приведение типов
*/

public class Main {

    public static void main(String[] args) {
        String[][] myArray = {
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"}
        };

        try {
            System.out.println("Сумма элементов массива равна: " + getSum(myArray));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getSum(String[][] myArray) throws MyArraySizeException, MyArrayDataException {
        if (myArray.length > 4 || myArray[0].length > 4){
            throw new MyArraySizeException();
        }

        int sum = 0;
        int tmp = 0;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                try {
                    tmp = Integer.parseInt (myArray[i][j]);
                } catch (NumberFormatException e) {
                    tmp = 0;
                    throw new MyArrayDataException(i,j);
                }
                sum = sum + tmp;
            }
        }
        return sum;
    }

}
