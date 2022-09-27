package lessonsJCore.JCore.dz.lesson1;

public class RunClass {
    public static void main(String[] args) {
        Person[] person = new Person[4];
        person[0] = new Person ("Oleg",10);
        person[1] = new Person ("Mik", 5);
        person[2] = new Person("Sam", 15);
        person[3] = new Person("Nik",20);
        Team team = new Team("Команда",person);

        Course course = new Course(10);
        String result = course.doIt(team);
        System.out.println(result);
    }
}
