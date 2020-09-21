package lab4;

public class Square extends Shape {
    protected int height;
    Square(String color, int height){
        super(color);
        this.height = height;
    }
    public String toString(){
        return "color: " + color + "\nheight: "+ height + "\narea: " + height*height;
    }
}

class Rectangle extends Square{
    private int width;
    Rectangle(String color, int height, int width){
        super(color, height);
        this.width = width;
    }
    @Override
    public String toString(){
        return "color: " + color + "\nheight: "+ height + "\nwidth: " + width + "\narea: " + height*width;
    }
}