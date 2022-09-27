package lessonsJCore.JCore.dz.lesson1;

public class Team {
    private String name;
    private Person[] peoples;

    public Team(String name, Person[] peoples){
        this.name = name;
        this.peoples = peoples;
    }

    public String getName() {
        return name;
    }

    public Person[] getPeoples() {
        return peoples;
    }
}
