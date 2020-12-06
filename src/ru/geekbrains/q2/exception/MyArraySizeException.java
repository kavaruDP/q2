package ru.geekbrains.q2.exception;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super("Ошибка в индексе массива");
    }

}
