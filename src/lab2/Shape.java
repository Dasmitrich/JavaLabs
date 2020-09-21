package lab2;

public class Shape {
        int a = 17;
        double b = 18.5;
        int c = 19;
        int h = 5;
        String text = "Pyramide";

}

class Tester{
    public static void main(String[] args) {
        Shape s = new Shape();
        System.out.println("Length " + s.a + ", Width " + s.b + ", Height " + s.c + ", Curvature " + s.h + ", Name: " + s.text);
    }
}