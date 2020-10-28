package ru.geekbrains.q2;

public class Cat implements Jump, Run {
    private String name;
    private int age;
    private int maxHeight;
    private int maxLength;
    private boolean isGood = true;

    public Cat(String name, int age) {
        this.name = name;
        if (age >1 & age <10) {
            maxHeight = 2;
            maxLength = 100;
        }
        else {
            maxHeight = 0;
            maxLength = 0;
        }
    }

    public void run(Track track) {
        System.out.println("Кошка " + name + runResult(track.getLength()));

    }

    public void jump(Wall wall) {
        System.out.println("Кошка " + name + jumpResult(wall.getHeight()));
    }

    private String runResult(int param) {
        if (!isGood) {
            return " снята с соревнований";
        }
        if (param < maxLength) {
            return " успешно пробежала";
        }
        else {
            isGood = false;
            return " пробежать не смогла";
        }
    }

    private String jumpResult(int param) {
        if (!isGood) {
            return " снята с соревнований";
        }
        if (param < maxHeight) {
            return " успешно прыгнула";
        }
        else {
            isGood = false;
            return " прыгнуть не смогла";
        }
    }
}
