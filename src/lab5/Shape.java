package lab5;

public abstract class Shape {
    Shape(String name){
        this.name = name;
    };
    protected String name;
    protected double area;
    abstract double calculatearea();
}

class Circle extends Shape{
    protected int radius;
    Circle(String name, int radius){
        super(name);
        this.radius = radius;
    }

    @Override
    double calculatearea() {
        return 3.1415 * radius * 2;
    }

    @Override
    public String toString(){
        return "name: " + name + "\narea: " + calculatearea();
    }
}

class Sphere extends Circle{
    Sphere(String name, int radius){
        super(name, radius);
    }
    @Override
    public String toString(){
        return "name: " + name + "\nV: " + 4.0*1.0/3.0*3.14*radius*radius*radius;
    }
}

class Rectangle extends Shape{
    private double width, height;
    Rectangle(String name, double width, double height){
        super(name);
        this.width = width;
        this.height = height;
    }
    @Override
    double calculatearea() {
        return width * height;
    }
    @Override
    public String toString(){
        return "name: " + name + "\narea: " + calculatearea();
    }
}



class Square extends Shape{
    protected double a;
    Square(String name, double a){
        super(name);
        this.a = a;
    }

    @Override
    public String toString(){
        return "name: " + name + "\narea: " + calculatearea();
    }

    @Override
    double calculatearea() {
        return a*a;
    }
}

class Cube extends Square{
    Cube(String name, double a){
        super(name, a);
    }
    @Override
    public String toString(){
        return "name: " + name + "\nV: " + a*a*a;
    }
}

class Go{
    public static void main(String[] args) {
        Square sq = new Square("SmallSquare", 2);
        System.out.println(sq);
        System.out.println();
        Rectangle rec = new Rectangle("Better lab5.Square", 5, 6.73);
        System.out.println(rec);
        System.out.println();
        Circle circ = new Circle("Ideal lab5.Circle", 78);
        System.out.println(circ);
        System.out.println();
        Cube c = new Cube("Kubik", 4);
        System.out.println(c);
        Sphere s = new Sphere("Magic Sphere", 6);
        System.out.println(s);
    }
}