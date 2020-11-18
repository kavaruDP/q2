package ru.geekbrains.q2.collection;

import ru.geekbrains.q2.*;

import java.util.*;

public class Main {



    public static void main(String[] args) {

        // Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        ArrayList<String> list = new ArrayList<>();
        makeList (list);
        Set<String> set = new HashSet(list);
        System.out.println(set);

        // Посчитать сколько раз встречается каждое слово.
        takeStat(list, set);

        // Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
        // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        // тогда при запросе такой фамилии должны выводиться все телефоны.
        PhoneBook pb = new PhoneBook("1");
        pb.add("+79161111111","Petrov");
        pb.add("+79162222222","Ivanov");
        pb.add("+79163333333","Petrov");
        pb.add("+79164444444","Sidorov");
        System.out.println(pb.get("Petrov"));

        //количество строк - R, а столбцов - C
        int R = 5;
        int C = 6;
        int[][] arr = new int[R][C];
        int i =0;
        int j =0;
        int k=1;
        int stop = 0;
        while (k < 19){
            i= down(i,j,k,arr,R);
            System.out.println("k=" + k + " i=" + i + " j=" + j + " down");
            j++;
            j= right(i,j,k,arr,C);
            System.out.println("k=" + k + " i=" + i + " j=" + j + " right");
            i--;
            i = up(i,j,k,arr);
            System.out.println("k=" + k + " i=" + i + " j=" + j + " up");
            j--;
            j = left(i,j,k,arr);
            System.out.println("k=" + k + " i=" + i + " j=" + j + " left");
            i++;
        }
        //Вывод результата
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (arr[x][y]<10) {
                    System.out.print(arr[x][y] + "  ");
                } else {
                    System.out.print(arr[x][y] + " ");
                }
            }
            System.out.println("");
        }
    }

    //System.out.println("k=" + k + " i=" + i + " j=" + j + " ss=" + ss);

    private static int down (int i, int j, int value, int[][] arr, int maxArr) {
        while (i < maxArr && arr[i][j] == 0) {
            arr[i][j] = value;
            i++;
            value++;
            if (i==maxArr) {
                i--;
                break;
            }
        }
        return i;
    }
    private static int right (int i, int j, int value, int[][] arr, int maxArr) {
        while (j < maxArr && arr[i][j] == 0) {
            arr[i][j] = value;
            j++;
            value++;
            if (j==maxArr) {
                j--;
                break;
            }
        }
        return j;
    }
    private static int up (int i, int j, int value, int[][] arr) {
        while (i >= 0 && arr[i][j] == 0) {
            arr[i][j] = value;
            i--;
            value++;
            if (i==-1) {
                i++;
                break;
            }
        }
        return i;
    }
    private static int left (int i, int j, int value, int[][] arr) {
        while (j >=0 && arr[i][j] == 0) {
            arr[i][j] = value;
            j++;
            value++;
            if (j==-1) {
                j++;
                break;
            }
        }
        return i;
    }
    private static void makeList(ArrayList myList) {

        myList.add("zero");
        myList.add("eleven");
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        myList.add("five");
        myList.add("five");         //**
        myList.add("six");
        myList.add("seven");
        myList.add("eight");
        myList.add("nine");
        myList.add("ten");
        myList.add("eleven");      //**
        myList.add("twelve");
        myList.add("fourteen");
        myList.add("fifteen");
        myList.add("fifteen");     //**
        myList.add("eleven");      //***
    }

    private static void takeStat(ArrayList myList, Set mySet) {
        // Создаем map-структуру для хранения результата и инициализируем ее нулями
        Map<String, Integer> myMap = new HashMap();
        Iterator<String> iterSet = mySet.iterator();
        while (iterSet.hasNext()) {
            String itemSet = iterSet.next();
            myMap.put(itemSet, 0);
        }
        // Перебираем map-структуру сравнивая key со всеми элементами исходного списка myList. Увеличиваем value всякий раз когда находим совпадение
        Iterator<String> iterList = myList.iterator();
        for (Map.Entry<String, Integer> o : myMap.entrySet()) {
            String mapKey = o.getKey();
            Integer mapValue = o.getValue();
            boolean isEntryChange = false;
            for (Object itemList  : myList) {
                if (itemList.equals(mapKey)) {
                    mapValue ++;
                    isEntryChange = true;
                }
            }
            if (isEntryChange) myMap.put(mapKey, mapValue);
        }
        // Выводим результат
        for (Map.Entry<String, Integer> o : myMap.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }
    }

}
