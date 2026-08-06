package discount.types;
import discount.DiscountOff;

public class birthdayDiscount extends DiscountOff {
    double discount = 30;
    
    @Override
    public void Discounts() {
        System.out.println("Birthday Discount Applied: " + discount + "%");
    }
    
    @Override
    public void displayDiscount() {
        System.out.println("Displaying Birthday Discount: " + discount + "%");
    }
}
