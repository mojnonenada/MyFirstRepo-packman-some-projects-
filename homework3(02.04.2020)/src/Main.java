import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Anatoliy","Anton","Arkadiy","Artur","Boris","Vadim","Valentin","Valeriy","Viktor","Vitaliy"," Vladimir","Artur","Artur","Artur","Artur","Anton","Anton","Anton","Kirill","Maksim","Anatoliy","Anatoliy"};
        LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
        for (String i : names) {
           Integer kol = hm.get(i);
           hm.put(i, kol == null ? 1 : (kol+1) );
        }
        System.out.println("Task 1");
        System.out.println(hm);
        System.out.println("Task 2");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov","79954443553");
        phoneBook.add("Petrov","79545454553");
        phoneBook.add("Kofffffff","799533333");
        phoneBook.add("Ivanov","7323233332");
        phoneBook.add("ggggggg","77777777777");
        phoneBook.add("","");
        System.out.println(phoneBook.get("Petrov"));
    }
}

