package payments;

public class cash extends paaymode {
    @Override
    public void pay(double amount) {
        System.out.println("You successfully paid:" + amount + "php");
    }
}
