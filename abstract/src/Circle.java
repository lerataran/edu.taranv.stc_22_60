public class Circle extends Ellipse implements Moveable {

    public Circle(int x, int y, int radius) {
        super(x, y,radius,radius);
    }

    @Override
    public void move(int x, int y) {
        int x1=setX(x);
        int y1=setY(y);
        System.out.println("Circle переместился на "+ x1 + ","+y1);
    }

    @Override
    public void getPerimeter() {
        int p = (int) (2*Math.PI*getSemiAxisA());
        System.out.println("Периметр Circle равен " + p);
    }

    @Override
    public void getArea() {
        int s = (int) (Math.PI*getSemiAxisA()*getSemiAxisA());
        System.out.println("Площадь Square равен " + s);
    }
}
