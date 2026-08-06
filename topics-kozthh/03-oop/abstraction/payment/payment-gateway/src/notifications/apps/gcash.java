package notifications.apps;
import notifications.absrule.rule;

public class gcash extends rule {
    @Override
    public void paidNotifications() {
        System.out.print("your gcash payment is successful");
    }
}
