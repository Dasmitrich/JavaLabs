package lab3;

public class Human {
    protected String nationality, name;
    protected int age;
    Human(String nationality, String name, int age){
        this.nationality = nationality;
        this.name = name;
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAge() {
        return age;
    }
}

class head extends Human{
    private String eyecolour;
    head(String nationality, String name, int age, String eyecolour){
        super(nationality, name, age);
        this.eyecolour = eyecolour;
    }

    @Override
    public String toString() {
        return ("Name " + name + "\nNationality " + nationality + "\nAge " + age + "\nEyecolour " + eyecolour);
    }
}

class leg extends Human{
    private String side;
    leg(String nationality, String name, int age, String eyecolour){
        super(nationality, name, age);
        this.side = side;
    }

    @Override
    public String toString() {
        return ("Name " + name + "\nNationality " + nationality + "\nAge " + age + "\nSide " + side);
    }
}

class hand extends Human{
    private String colour;
    hand(String nationality, String name, int age, String colour){
        super(nationality, name, age);
        this.colour = colour;
    }

    @Override
    public String toString() {
        return ("Name " + name + "\nNationality " + nationality + "\nAge " + age + "\nColour " + colour);
    }
}

class go{
    public static void main(String[] args) {
        head h = new head("Mitry", "Finnish", 20, "Blue");
        System.out.println(h.toString());
    }
}