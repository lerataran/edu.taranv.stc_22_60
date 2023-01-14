public class Circle extends Ellipse implements Movable {

    public Circle(int x, int y, int width) {
        super(x, y, width, 0);
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * width);
    }

    @Override
    public double getArea() {
        return (Math.PI * width * width);
    }
}
