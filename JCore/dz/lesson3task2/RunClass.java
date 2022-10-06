package lessonsJCore.JCore.dz.lesson3task2;

import java.util.ArrayList;

public class RunClass {

    public static void main(String[] args) {
        ArrayList<Apple> applesList = new ArrayList<>(10);
        Apple apple0 = new Apple(5);
        Apple apple1 = new Apple(2);
        Apple apple2 = new Apple(3);
        Apple apple3 = new Apple(4);

        applesList.add(apple0);
        applesList.add(apple1);
        applesList.add(apple2);
        applesList.add(apple3);

        Box<Apple> box1 = new Box<>();

        ArrayList<Apple> applesList2 = new ArrayList<>();
        applesList2.add(apple0);
        applesList2.add(apple1);
        applesList2.add(apple2);
        applesList2.add(apple3);

        Apple apples4 = new Apple(10);

        Box<Apple> box2 = new Box<>();

        System.out.println(box2.getFruitList());

        System.out.println(box1.compareList(box2));

        box1.toEmptyList(box2);

        System.out.println(box2);

        ArrayList<Orange> orangeArrayList = new ArrayList<>(10);
        Orange orange0 = new Orange(5);

        Box<Orange> box3 = new Box<>();

        box1.compare(box3);


    }
}
