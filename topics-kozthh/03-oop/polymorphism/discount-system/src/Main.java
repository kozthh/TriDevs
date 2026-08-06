import discount.DiscountOff;
import discount.types.birthdayDiscount;
import discount.types.HolidayDiscount;
import discount.types.SeniorDiscount;
import discount.types.PWD;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Polymorphism Demonstration ===\n");

        // Create an array of DiscountOff (polymorphic references)
        DiscountOff[] discounts = new DiscountOff[4];

        // Initialize with different discount types
        discounts[0] = new birthdayDiscount();
        discounts[1] = new HolidayDiscount();
        discounts[2] = new SeniorDiscount();
        discounts[3] = new PWD();

        // Iterate through and apply polymorphic method calls
        System.out.println("--- Applying Discounts ---");
        for (DiscountOff discount : discounts) {
            discount.Discounts();
        }

        System.out.println("\n--- Displaying Discounts ---");
        for (DiscountOff discount : discounts) {
            discount.displayDiscount();
        }
    }
}