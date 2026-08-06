package parentcrossover;

public class cross {
    private String color;
    private String model;
    private int price;

    public cross(String color, String model, int price) throws InvalidPriceException {
        validatePrice(price);
        this.color = color;
        this.model = model;
        this.price = price;
    }

    protected void validatePrice(int price) throws InvalidPriceException {
        if (price < 0) {
            throw new InvalidPriceException("Price must be greater than or equal to 0");
        }
    }

    // Getters
    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    // Setters
    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) throws InvalidPriceException {
        validatePrice(price);
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Color: " + color);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
}