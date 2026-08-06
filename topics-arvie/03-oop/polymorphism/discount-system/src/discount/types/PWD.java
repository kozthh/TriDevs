package discount.types;

import discount.DiscountOff;

public class PWD extends DiscountOff {
    double discount = 15;
    
    @Override
    public void Discounts() {
        System.out.println("PWD Discount Applied: " + discount + "%");
    }
    
    @Override
    public void displayDiscount() {
        System.out.println("Displaying PWD Discount: " + discount + "%");
    }
}
