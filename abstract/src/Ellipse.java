public class Ellipse extends Figure {
    private final int semiAxisA;
    private final int semiAxisB;

    public Ellipse(int x, int y, int semiAxisA, int semiAxisB) {
        super(x, y);
        this.semiAxisA = semiAxisA;
        this.semiAxisB = semiAxisB;
    }

    public int getSemiAxisA() {
        return semiAxisA;
    }

    @Override
    public double getPerimeter() {
        return (4 * (Math.PI * semiAxisA * semiAxisB + (semiAxisA - semiAxisB) * (semiAxisA - semiAxisB)) / (semiAxisA + semiAxisB));
    }

    @Override
    public double getArea() {
        return (Math.PI * semiAxisA * semiAxisB);
    }
}

