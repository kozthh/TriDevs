package parentsuv;

public class suv {
    private final String color;
    private final String yearModel;
    private final int price;
    private final String model;

    public suv(String color, String yearModel, int price, String model) {
        this.color = color;
        this.yearModel = yearModel;
        this.price = price;
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public String getYearModel() {
        return yearModel;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Year Model: " + yearModel);
        System.out.println("Price: " + price);
    }
}