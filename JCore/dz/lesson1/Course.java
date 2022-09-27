package lessonsJCore.JCore.dz.lesson1;

public class Course {
    String result;
    private int run;


    public Course(int run){
        this.run = run;

    }

    public String doIt(Team team){
        result = "Команда: "+team.getName()+" "+ '\n';
        for(Person person: team.getPeoples()){
            result += "Имя участника: "+person.getName()+" "+'\n';
            int value = person.getCanRun();
            testRun(value);
        }
        return result;
    }

    private void testRun(int value){
        if(value<run) result = result +"Прошел полосу"+'\n';
        else result += "Не прошел полосу"+'\n';
    }
}
