package lab4;

public class Shape {
    protected String color;
    Shape(String color){
        this.color = color;
    }
}

class Work{
    public static void main(String[] args) {
        Circle circ = new Circle("Blue", 4);
        System.out.println(circ);
        System.out.println();
        Square sq = new Square("Green", 12);
        System.out.println(sq);
        System.out.println();
        Rectangle rec = new Rectangle("Pink", 3, 5);
        System.out.println(rec);
    }
}