package lab6;

interface Movable{
    void speedcheck();
    void setspeed(int speed);
    void setpoints(int x, int y);
}

class MovableRectangle implements Movable{
    protected int speed;
    private int height, width;
    MovableRectangle(int height, int width){
        this.height = height;
        this.width = width;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    @Override
    public void speedcheck() { }

    @Override
    public void setspeed(int speed) {
        this.speed = speed;
    }
    @Override
    public void setpoints(int x, int y){ }
}

class Movablepoints implements Movable{
    protected int x,y;
    @Override
    public void speedcheck() {
        if(x==y){
            System.out.println("Right speed");
        } else {
            System.out.println("Wrong speed");
        }
    }

    @Override
    public void setspeed(int speed) {

    }

    public void setpoints(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class go{
    public static void main(String[] args) {
        MovableRectangle mov = new MovableRectangle(12, 15);
        System.out.println(mov.getHeight());
        Movablepoints mp = new Movablepoints();
        mp.setpoints(12, 12);
        System.out.println();
        mp.speedcheck();
    }
}