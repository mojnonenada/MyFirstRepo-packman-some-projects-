public class Main {

    public static void main(String[] args) {
        Employee[] parsArray = new Employee[5];
        parsArray[0] = new Employee("Ivanov", "Ivan", "Ivanovic", "Engineer", "ewfewf@mail.ru", "+792121212", 10000, 50);
        parsArray[1] = new Employee(" Ivanov1", "Ivan1", "Ivanovic1", "Engineer1", "ewfewf@mail.ru", "+7345342", 16550, 51);
        parsArray[2] = new Employee("Ivanov2 ", "Ivan2", "Ivanovic2", "Engineer2", "abcwf@mail.ru", "+7324243212", 15454500, 30);
        parsArray[3] = new Employee("Ivanov3 ", "Ivan3", "Ivanovic3", "Engineer3", "aaaaaaaaaaaawf@mail.ru", "+867867867812", 123500, 53);
        parsArray[4] = new Employee("Ivanov4 ", "Ivan4", "Ivanovic4", "Engineer4", "loc.gmail.ru", "+7234343112", 100, 54);

        for (int i = 0; i < parsArray.length; i++) {
            if (parsArray[i].getAge() > 40) {parsArray[i].getInfo();
            }
        }
    }
}
