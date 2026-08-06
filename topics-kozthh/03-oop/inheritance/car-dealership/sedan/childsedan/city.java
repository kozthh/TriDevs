package childsedan;

import parentcrossover.InvalidPriceException;
import parentsedan.sedan;

public class city extends sedan {
    private int horsepower;
    private int wheelSize;
    private String transmissionType;

    public city(String color, String yearmodel, int price, int horsepower, int wheelSize, String transmissionType) throws InvalidPriceException {
        super(color, yearmodel, price, "City");
        this.horsepower = horsepower;
        this.wheelSize = wheelSize;
        this.transmissionType = transmissionType;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    @Override
    public void displayInfo() {
        System.out.println("City:");
        super.displayInfo();
        System.out.println("Horsepower: " + horsepower);
        System.out.println("Wheel Size: " + wheelSize);
        System.out.println("Transmission Type: " + transmissionType);
    }



}