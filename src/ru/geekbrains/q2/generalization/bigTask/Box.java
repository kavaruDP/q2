package ru.geekbrains.q2.generalization.bigTask;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> implements Comparable<Box> {
    private String titleBox;
    private Float weight;                                       // Вес содержимого коробки
    private T[] arrayFruits;                                    // Содержимое коробки в виде массива
    private ArrayList<T> listFruits= new ArrayList<T>();         // Содержимое коробки в виде списка

    // простейший конструктор коробки с именем
    public Box(String titleBox) {
        this.titleBox = titleBox;
        weight = 0.0f;
    }

    // добавление фруктов списком
    public void putFruits(ArrayList<T> listFruits) {
        if (listFruits.size() == 0) return;
        for (T listItem  : listFruits) {
            this.listFruits.add(listItem);
            weight = weight + listItem.weightOne;
        }
    }

     //добавление фруктов поштучно
    public void putFruit(T fruit) {
        this.listFruits.add(fruit);
        weight = weight + fruit.weightOne;
    }

    public Float getWeight() {
        return weight;
    }

    public ArrayList<T> getFruits() {
        return listFruits;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Box o) {
        return this.weight.intValue() - o.weight.intValue();
    }

    public boolean compare(Box o) {
        if (0 == this.compareTo(o)){
            return true;
        }
        else {
            return false;
        }
    }
    // Пересыпать фрукты из коробки, для которой вызван метод в коробку, указанную в параметре метода
    public void pourIn(Box<T> o) {
        if (0 == this.listFruits.size()) return;
        if (this == o) return;
        float sum = o.getWeight();
        for (T listItem  : this.listFruits) {
            o.getFruits().add(listItem);
            sum = sum + listItem.weightOne;
        }
        o.setWeight(sum);
        //ArrayList<T> listFruits = o.listFruits;
        //o.putFruits(listFruits);
        this.listFruits.clear();
        this.weight = 0.0f;
    }
}
