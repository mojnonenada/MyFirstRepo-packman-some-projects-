class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private String  email;
    private String tel;
    private int money;
    private int age;

    Employee(String surname,String name, String patronymic, String position, String email, String tel, int money, int age) {
    this.surname = surname;
    this.name = name;
    this.patronymic = patronymic;
    this.position = position;
    this.email = email;
    this.tel = tel;
    this.money = money;
    this.age = age;
    }

    void getInfo(){
        System.out.println(surname+ " " + name+ " " + patronymic+ " "+ position+ " "+ email+ " "+ tel+" "+ money+" "+ age);
    }

   int getAge(){
        return age;
    }
}
