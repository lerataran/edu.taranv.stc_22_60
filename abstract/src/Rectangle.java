public class Rectangle extends Figure {
    private final int width;
    private final int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void getPerimeter() {
        int a = getWidth();
        int b = getHeight();
        int p = 2*(a+b);
        System.out.println("Периметр Rectangle равен " + p);
    }

    @Override
    public void getArea() {
        int s = getWidth()*getHeight();
        System.out.println("Площадь Rectangle равен " + s);
    }
}
