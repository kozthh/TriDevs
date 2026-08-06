package parent;

public class HR {
    private String name;
    private String position;

    public HR(String name, String position) {
        this.name = name;
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public double calculatePayCheck() {
        return getBasePay() + getBonus() - getTax();
    }

    protected double getBasePay() {
        return 0.0;
    }

    protected double getBonus() {
        return 0.0;
    }

    protected double getTax() {
        return 0.0;
    }
}
