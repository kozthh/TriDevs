package notifications.apps;

import payments.cash;

public class pick {

    public void pick(String app) {
        switch (app) {
            case "gcash":
                new payments.gcash();
                break;
            case "maya":
                new payments.maya();
                break;
            case "uniondigital":
                new payments.uniondigital();
                break;
            case "cash":
                new cash();
                break;
            case "sms":
                new sms();
                break;
            default:
                System.out.println("Unknown app: " + app);
        }
    }
}
