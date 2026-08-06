package parentcrossover.models;

import parentcrossover.InvalidPriceException;
import parentcrossover.cross;

public class veloz extends cross {
	private int horsepower;
	private int wheelSize;
	private String transmissionType;

	public veloz(String color, int price, int horsepower, int wheelSize, String transmissionType) throws InvalidPriceException {
		super(color, "Veloz", price);
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
		System.out.println("Veloz:");
		super.displayInfo();
		System.out.println("Horsepower: " + horsepower);
		System.out.println("Wheel Size: " + wheelSize);
		System.out.println("Transmission Type: " + transmissionType);
	}
}
