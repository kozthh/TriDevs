package payments;

public class mode {

    public void payment(String type, double amount) {
        switch (type) {
            case "gcash":
                new gcash().pay(amount);
                break;
            case "maya":
                new maya().pay(amount);
                break;
            case "uniondigital":
                new uniondigital().pay(amount);
                break;
            case "cash":
                new cash().pay(amount);
                break;
            default:
                System.out.println("Unsupported payment type: " + type);
        }
    }
}
