public class Square extends Rectangle implements Movable {
    public Square(int x, int y, int width) {
        super(x, y, width, 0);
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public double getPerimeter() {
        return 4 * width;
    }

    @Override
    public double getArea() {
        return width * width;
    }
}
