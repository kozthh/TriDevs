package discount.types;
import discount.DiscountOff;

public class SeniorDiscount extends DiscountOff {
    double discount = 25;

    @Override
    public void Discounts() {
        System.out.println("Senior Discount Applied: " + discount + "%");
    }

    @Override
    public void displayDiscount() {
        System.out.println("Displaying Senior Discount: " + discount + "%");
    }
}
