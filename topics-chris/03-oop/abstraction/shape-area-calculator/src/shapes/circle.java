package shapes;
import ruler.shaperuler;

public class circle extends shaperuler{
    private double radius;

    public circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
