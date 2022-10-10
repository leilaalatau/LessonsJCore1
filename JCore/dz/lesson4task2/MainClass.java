package lessonsJCore.JCore.dz.lesson4task2;

public class MainClass {
    public static void main(String[] args) {
        TelephoneBookClass telephoneBookClass = new TelephoneBookClass();
        telephoneBookClass.add("123", "Ivanov");
        telephoneBookClass.add("456", "Ivanov");
        telephoneBookClass.add("789", "Ivanov");
        telephoneBookClass.add("111", "Petrov");
        telephoneBookClass.add("222", "Markov");
        telephoneBookClass.add("555", "Serov");
        telephoneBookClass.add("444", "Belov");

        System.out.println(telephoneBookClass.getPhoneByFIO("Ivanov"));
        System.out.println(telephoneBookClass.getPhoneByFIO("888"));

    }
}
