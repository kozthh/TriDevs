package payments;

public class gcash extends paaymode {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with GCash");
    }
}
