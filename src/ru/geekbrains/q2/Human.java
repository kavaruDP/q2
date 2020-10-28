package ru.geekbrains.q2;

public class Human implements Jump, Run {
    private String name;
    private int age;
    private int maxHeight;
    private int maxLength;
    private boolean isGood = true;

    public Human(String name, int age) {
        this.name = name;
        if (age >10 & age <30) {
            maxHeight = 2;
            maxLength = 100;
        }
        else {
            maxHeight = 0;
            maxLength = 0;
        }
    }

    public void run(Track track) {
        System.out.println("Человек " + name + runResult(track.getLength()));

    }

    public void jump(Wall wall) {
        System.out.println("Человек " + name + jumpResult(wall.getHeight()));
    }

    private String runResult(int param) {
        if (!isGood) {
            return " снят с соревнований";
        }
        if (param < maxLength) {
            return " успешно пробежал";
        }
        else {
            isGood = false;
            return " пробежать не смог";
        }
    }

    private String jumpResult(int param) {
        if (!isGood) {
            return " снят с соревнований";
        }
        if (param < maxHeight) {
            return " успешно прыгнул";
        }
        else {
            isGood = false;
            return " прыгнуть не смог";
        }
    }
}
