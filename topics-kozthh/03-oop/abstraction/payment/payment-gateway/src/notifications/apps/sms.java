package notifications.apps;
import notifications.absrule.rule;

public class sms extends rule{
    @Override
    public void paidNotifications() {
        System.out.print("you successfully paid your parking fee, thank you so much ");
    }
}
