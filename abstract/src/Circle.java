public class Circle extends Ellipse implements Moveable {

    public Circle(int x, int y, int radius) {
        super(x, y,radius,radius);
    }

    @Override
    public void move(int x, int y) {
        setX(x + getX());
        setY(y + getY());
    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * getSemiAxisA());
    }

    @Override
    public double getArea() {
        return (Math.PI * getSemiAxisA() * getSemiAxisA());
    }
}
