package ru.geekbrains.q2;

public class Robot implements Jump, Run {
    private String name;
    private int power;
    private int maxHeight;
    private int maxLength;
    private boolean isGood = true;

    public Robot(String name, int power) {
        this.name = name;
        if (power >1 & power <50) {
            maxHeight = 2;
            maxLength = 100;
        }
        else {
            maxHeight = 0;
            maxLength = 0;
        }
    }

    public void run(Track track) {
        System.out.println("Робот " + name + runResult(track.getLength()));
    }

    public void jump(Wall wall) {
        System.out.println("Робот " + name + jumpResult(wall.getHeight()));
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
