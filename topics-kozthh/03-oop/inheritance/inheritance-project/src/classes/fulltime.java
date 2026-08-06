package classes;

import parent.HR;

public class fulltime extends HR {
    private double bonus;
    private double tax = 150.59;

    public fulltime(String name, String position) {
        super(name, position);
        this.bonus = 0.0;
        this.tax = 0.0;
    }

    public fulltime(String name, String position, double bonus) {
        super(name, position);
        this.bonus = bonus;
        this.tax = 0.0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    protected double getBasePay() {
        return 1299.99;
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
