package ru.geekbrains.q2.thread;

public class Main {
    static final int SIZE = 1000000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];

    public static void main(String[] args) {
        Main e = new Main();
        e.method1();
        e.method2();
    }

    public void method1() {
        for (int i=0; i< SIZE; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        fillArray (arr, SIZE);
        System.out.println("method1: " + (System.currentTimeMillis() - a));
    }

    public void method2() {
        Main e1 = new Main();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        for (int i=0; i< SIZE; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        // System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение,
        // откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
        // Разбиваем массив
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        // расчет новых значений массива в двух потоках
        new Thread(() -> e1.fillArray(a1, HALF)).start();
        new Thread(() -> e1.fillArray(a2, HALF)).start();
        // Склеиваем массив
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        System.out.println("method2: " + (System.currentTimeMillis() - a));
    }

    private void fillArray(float[] arr, int size) {
        for (int i=0; i< size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
