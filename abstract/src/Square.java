public class Square extends Rectangle implements Moveable{
    public Square(int x, int y, int side) {
        super(x, y, side, side);
    }

    @Override
    public void move(int x, int y) {
        int x1=setX(x);
        int y1=setY(y);
        System.out.println("Square переместился на "+ x1 + ","+y1);
    }

    @Override
    public void getPerimeter() {
        int p = 4*getWidth();
        System.out.println("Периметр Square равен " + p);
    }

    @Override
    public void getArea() {
        int s = getWidth()*getWidth();
        System.out.println("Площадь Square равен " + s);
    }
}
