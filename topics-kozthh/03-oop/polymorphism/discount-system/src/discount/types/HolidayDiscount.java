package discount.types;
import discount.DiscountOff;

public class HolidayDiscount extends DiscountOff {
    double discount = 20;

    @Override
    public void Discounts() {
        System.out.println("Holiday Discount Applied: " + discount + "%");
    }

    @Override
    public void displayDiscount() {
        System.out.println("Displaying Holiday Discount: " + discount + "%");
    }
}
