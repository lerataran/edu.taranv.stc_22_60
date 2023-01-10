public class Ellipse extends Figure {
    private final int semiAxisA;
    private final int semiAxisB;

    public Ellipse(int x, int y, int semiAxisA, int semiAxisB) {
        super(x, y);
        this.semiAxisA=semiAxisA;
        this.semiAxisB=semiAxisB;
    }

    public int getSemiAxisA() {
        return semiAxisA;
    }

    public int getSemiAxisB() {
        return semiAxisB;
    }

    @Override
    public void getPerimeter() {
        int a = getSemiAxisA();
        int b = getSemiAxisB();
        int p = (int) (4*(((Math.PI*a*b) + ((2*a) - (2*a*b) + (2*b))) / (a+b)));
        // формула взята из википедии в проект добавила фотографию формулы
        System.out.println("Периметр Ellipse равен " + p);
    }

    @Override
    public void getArea() {
        int s = (int) (Math.PI*getSemiAxisA()*getSemiAxisB());
        System.out.println("Площадь Ellipse равен " + s);
    }
}

