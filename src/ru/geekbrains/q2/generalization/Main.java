package ru.geekbrains.q2.generalization;
import ru.geekbrains.q2.generalization.bigTask.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Задача 1
        //Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
//        List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
//        for (int i=0; i < numberList.size(); i++ ) {
//            System.out.println(numberList.get(i));
//        }
        ObjArray<Integer> testArray1 = new ObjArray<> (1,2,3,4,5);
        ObjArray<Double> testArray2 = new ObjArray<> (1.0,2.0,3.0,4.0,5.0);
        ObjArray<String> testArray3 = new ObjArray<> ("1","2","3","4","5");
        testArray2.printItem();
        testArray2.swapArray(0,4);
        testArray2.printItem();

        //Задача 2
        //Написать метод, который преобразует массив в ArrayList
        System.out.println("Тип T: " + testArray2.Array2ArrayList().getClass().getName());

        //Задача 3
        //Манипуляции с коробками.
        //Создаем коробку под апельсины и кладем в нее 4 апельсина
        Box<Orange> boxOrange1 = new Box<>("boxOrange1");
        Orange fruitOrange1 = new Orange("fruitOrange1");
        Orange fruitOrange2 = new Orange("fruitOrange2");
        Orange fruitOrange3 = new Orange("fruitOrange3");
        ArrayList<Orange> listOrange = new ArrayList<>(Arrays.asList(fruitOrange1,fruitOrange2,fruitOrange3));
        boxOrange1.putFruits(listOrange);
        boxOrange1.putFruit(fruitOrange1);
        System.out.println("Вес коробки с апельсинами boxOrange1: " + boxOrange1.getWeight());
        //Создаем коробку под яблоки и кладем в нее 6 яблок
        Box<Apple> boxApple1 = new Box<>("boxApple1");
        Apple fruitApple1 = new Apple("fruitApple1");
        Apple fruitApple2 = new Apple("fruitApple2");
        Apple fruitApple3 = new Apple("fruitApple3");
        ArrayList<Apple> listApple = new ArrayList<>(Arrays.asList(fruitApple1,fruitApple2,fruitApple3));
        boxApple1.putFruits(listApple);
        boxApple1.putFruit(fruitApple1);
        boxApple1.putFruit(fruitApple2);
        boxApple1.putFruit(fruitApple3);
        System.out.println("Вес коробки с яблоками boxApple1: " + boxApple1.getWeight());
        //Сравниваем обе коробки по весу
        System.out.println ("Вес коробки boxOrange1 равен весу коробки boxApple1: " + boxOrange1.compare(boxApple1));
        //Создаем вторую коробку под апельсины и кладем в нее 3 апельсина
        Box<Orange> boxOrange2 = new Box<>("boxOrange2");
        boxOrange2.putFruit(fruitOrange1);
        boxOrange2.putFruit(fruitOrange2);
        boxOrange2.putFruit(fruitOrange3);
        System.out.println("Вес коробки с апельсинами boxOrange2: " + boxOrange2.getWeight());
        //Пересыпаем апельсины
        //boxApple2.pourIn(boxOrange1)  не компилируется -> пересыпать яблоки в коробку с апельсинами нельзя
        boxOrange2.pourIn(boxOrange1);
        System.out.println("Вес коробки с апельсинами boxOrange1 (в которую пересыпали): " + boxOrange1.getWeight());
        System.out.println("Вес коробки с апельсинами boxOrange2 (из которой пересыпали): " + boxOrange2.getWeight());
        //Создаем вторую коробку под яблоки и кладем в нее 3 яблока
        Box<Apple> boxApple2 = new Box<>("boxApple2");
        boxApple2.putFruit(fruitApple1);
        boxApple2.putFruit(fruitApple2);
        boxApple2.putFruit(fruitApple3);
        System.out.println("Вес коробки с яблоками boxApple2: " + boxApple2.getWeight());
        //Пересыпаем яблоки
        boxApple2.pourIn(boxApple1);
        System.out.println("Вес коробки с яблоками boxApple1 (в которую пересыпали): " + boxApple1.getWeight());
        System.out.println("Вес коробки с яблоками boxApple2 (из которой пересыпали): " + boxApple2.getWeight());
        //Сравниваем обе коробки по весу
        System.out.println ("Вес коробки boxOrange1 равен весу коробки boxApple1: " + boxOrange1.compare(boxApple1));
    }

}
