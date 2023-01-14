public abstract class Figure {
    protected int x;
    protected int y;
    protected final int width;
    protected final int height;

    public Figure(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract double getPerimeter();

    public abstract double getArea();


}
