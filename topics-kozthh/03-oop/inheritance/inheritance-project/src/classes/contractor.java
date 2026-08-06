package classes;

import parent.HR;

public class contractor extends HR {
    private double bonus;
    private double tax = 280.78;

    public contractor(String name, String position) {
        super(name, position);
        this.bonus = 0.0;
    }

    public contractor(String name, String position, double bonus) {
        super(name, position);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    protected double getBasePay() {
        return 1500.99;
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
