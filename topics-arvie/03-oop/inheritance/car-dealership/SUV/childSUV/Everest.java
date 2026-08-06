package childSUV;

import parentcrossover.InvalidPriceException;
import parentsuv.suv;

public class Everest extends suv {
    private int horsepower;
    private int wheelSize;
    private String transmissionType;
    private String GasType;

   public Everest(String color, String yearmodel, int price, String model, int horsepower, int wheelSize, String transmissionType, String GasType) throws InvalidPriceException {
       super(color, yearmodel, price, model);
        this.horsepower = horsepower;
        this.wheelSize = wheelSize;
        this.transmissionType = transmissionType;
        this.GasType = GasType;
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

    public String getGasType() {
        return GasType;
    }

    @Override
    public void displayInfo() {
        System.out.println("Everest:");
        super.displayInfo();
        System.out.println("Horsepower: " + horsepower);
        System.out.println("Wheel Size: " + wheelSize);
        System.out.println("Transmission Type: " + transmissionType);
        System.out.println("Gas Type: " + GasType);
    }

    @Override
    public String toString() {
        return "Everest{" +
                "horsepower=" + horsepower +
                ", wheelSize=" + wheelSize +
                ", transmissionType='" + transmissionType + '\'' +
                ", GasType='" + GasType + '\'' +
                '}';
    }


}