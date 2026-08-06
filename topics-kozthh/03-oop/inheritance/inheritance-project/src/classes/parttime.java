package classes;
import parent.*;

public class parttime extends HR {
    private double bonus;
    private double tax = 200.59;

    public parttime(String name, String position) {
        super(name, position);
        this.bonus = 0.0;
    }

    public parttime(String name, String position, double bonus) {
        super(name, position);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    protected double getBasePay() {
        return 800.99;
    }

    @Override
    protected double getBonus() {
        return bonus;
    }

    @Override
    protected double getTax() {
        return tax;
    }
}
