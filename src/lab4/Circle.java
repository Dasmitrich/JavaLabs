package lab4;

public class Circle extends Shape {
    private int radius;
    Circle(String color, int radius){
        super (color);
        this.radius = radius;
    }
    @Override
    public String toString (){
        return  "color: " + color + "\nradius: " + radius + "\narea: " + 3.14*radius*radius;
    }
}