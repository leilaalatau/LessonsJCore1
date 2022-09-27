package lessonsJCore.JCore.dz.lesson1;

public class Person {
    private String name;
    private int canRun;

    public Person(String name, int canRun){
        this.name = name;
        this.canRun = canRun;
    }

    public String getName(){
        return name;
    }

    public int getCanRun(){
        return canRun;
    }
}

