package payments;

public class uniondigital extends paaymode {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with UnionDigital");
    }
}
