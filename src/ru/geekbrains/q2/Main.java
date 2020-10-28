package ru.geekbrains.q2;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsic",3);
        Human human1 = new Human("Igor",25);
        Robot robot1 = new Robot("B11",10);
        Track track1 = new Track(10);
        Wall wall1 = new Wall(5);

        Object[] pArray = new Object[3];
        pArray[0] = new Cat("Barsic", 3);
        pArray[1] = new Human("Igor",25);
        pArray[2] = new Robot("B11",0);

        Object[] oArray = new Object[4];
        oArray[0] = new Track(10);
        oArray[1] = new Wall(1);
        oArray[2] = new Track(12);
        oArray[3] = new Wall(2);

        for (Object obstacle:oArray) {
            // Сначала все поочередно бегаем
            if (obstacle instanceof Track) {
                for (Object player : pArray) {
                    if (player instanceof Cat) {
                        ((Cat) player).run((Track) obstacle);
                    }
                    if (player instanceof Human) {
                    ((Human) player).run((Track) obstacle);
                    }
                    if (player instanceof Robot) {
                        ((Robot) player).run((Track) obstacle);
                    }
                }
            }
            // Затем все поочередно прыгаем
            else if (obstacle instanceof Wall) {
                for (Object player : pArray) {
                    if (player instanceof Cat) {
                        ((Cat) player).jump((Wall)obstacle);
                    }
                    if (player instanceof Human) {
                        ((Human) player).jump((Wall)obstacle);
                    }
                    if (player instanceof Robot) {
                        ((Robot) player).jump((Wall)obstacle);
                    }
                }
            }
        }
    }

}
