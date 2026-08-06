package shapes;
import ruler.shaperuler;

public class triangle extends shaperuler{
private double base;
private double height;

public triangle (double base,double height){
this.base=base;
this.height=height;
}
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}
