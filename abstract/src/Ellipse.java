public class Ellipse extends Figure {

    public Ellipse(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public double getPerimeter() {
        return (4 * (Math.PI * width * height + (width - height) * (width - height)) / (width + height));
    }

    @Override
    public double getArea() {
        return (Math.PI * width * height);
    }
}

