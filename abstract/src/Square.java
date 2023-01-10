public class Square extends Rectangle implements Moveable {
    public Square(int x, int y, int side) {
        super(x, y, side, side);
    }

    @Override
    public void move(int x, int y) {
        setX(x + getX());
        setY(y + getY());
    }

    @Override
    public double getPerimeter() {
        return 4 * getWidth();
    }

    @Override
    public double getArea() {
        return getWidth() * getWidth();
    }
}
