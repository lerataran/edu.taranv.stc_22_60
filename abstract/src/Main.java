public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[9];
        figures[0] = new Ellipse(5,4,6,2);
        figures[1] = new Rectangle(-2,0,4,5);
        figures[2] = new Rectangle(5,7,4,0);
        figures[3] = new Square(0,2,3);
        figures[4] = new Circle(1,2,19);
        figures[5] = new Ellipse(8,9,4,9);
        figures[6] = new Rectangle(-6,2,0,5);
        figures[7] = new Square(-6,2,5);
        figures[8] = new Circle(1,2,4);


        Moveable[] movable = new Moveable[6];
        movable[0] = new Square(5,2,7);
        movable[1]= new Circle(9,6,5);
        movable[2]= new Circle(3,8,2);
        movable[3]= new Square(0,0,5);
        movable[4]= new Circle(-8,-1,4);
        movable[5]= new Square(7,6,2);

        for (Figure figure : figures) {
            figure.getPerimeter();
            figure.getArea();
        }
        System.out.println("*************************************************");
        for (Moveable value : movable) {
            value.move(2,3);
        }
    }
}
