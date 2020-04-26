import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    public HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String name, String number) {
        ArrayList<String> numberList = phoneBook.get(name);
        if (numberList == null ) {
            numberList = new ArrayList<>();
        }
        numberList.add(number);
        phoneBook.put(name,numberList);
    }

    public ArrayList <String> get (String name){
        return phoneBook.get(name);
    }
}
