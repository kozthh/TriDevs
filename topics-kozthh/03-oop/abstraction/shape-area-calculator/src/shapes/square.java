package shapes;
import ruler.shaperuler;

public class square extends shaperuler{
    private double side;
    private double side2;

    public square(double side, double side2) {
        this.side = side;
        this.side2 = side2;
    }

    @Override
    public double getArea() {
        return side * side2;
    }
}
