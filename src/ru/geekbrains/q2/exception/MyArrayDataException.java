package ru.geekbrains.q2.exception;

public class MyArrayDataException extends NumberFormatException{
    protected int i;
    protected int j;
    public MyArrayDataException(int i, int j) {
        super("Ошибка в ячейке с идексом (" + i + "," + j + ") при приведении строки к int");
    }
}
