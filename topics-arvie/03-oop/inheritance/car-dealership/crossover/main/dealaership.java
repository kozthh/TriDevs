import childsedan.city;
import childsedan.mirrage;
import childsedan.vios;
import childSUV.Everest;
import childSUV.Fortuner;
import childSUV.Landcruiser;
import parentcrossover.InvalidPriceException;
import java.util.Scanner;

public class dealaership {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Car Dealership!");
        System.out.println("Please select a car type:");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        System.out.println("3. Crossover");

        int carType = scanner.nextInt();
        scanner.nextLine();

        switch (carType) {
            case 1:
                System.out.println("You selected Sedan.");
                System.out.println("Please select a model:");
                System.out.println("1. City");
                System.out.println("2. Vios");
                System.out.println("3. Mirrage");

                int sedanModel = scanner.nextInt();
                scanner.nextLine();

                switch (sedanModel) {
                    case 1:
                        try {
                            city cityCar = new city("Red", "2026", 950000, 150, 16, "Automatic");
                            System.out.println("City Car:");
                            cityCar.displayInfo();
                        } catch (InvalidPriceException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            vios viosCar = new vios("Blue", "2026", 900000, "Vios", 140, 15, "Manual");
                            System.out.println("Vios Car:");
                            viosCar.displayInfo();
                        } catch (InvalidPriceException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            mirrage mirrageCar = new mirrage("Black", "2026", 800000, "Mirrage", 130, 14, "Automatic");
                            System.out.println("Mirrage Car:");
                            mirrageCar.displayInfo();
                        } catch (InvalidPriceException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid Sedan Model selection.");
                }
                break;
            case 2:
                System.out.println("You selected SUV.");
                System.out.println("Please select a model:");
                System.out.println("1. Fortuner");
                System.out.println("2. Everest");
                System.out.println("3. Landcruiser");

                int suvModel = scanner.nextInt();
                scanner.nextLine();

                switch (suvModel) {
                    case 1:
                        try {
                            Fortuner fortunerCar = new Fortuner("White", "2026", 8000000, "Fortuner", 200, 18, "Automatic", "Diesel");
                            System.out.println("Fortuner Car:");
                            fortunerCar.displayInfo();
                        } catch (InvalidPriceException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            Everest everestCar = new Everest("Silver", "2026", 8000000, "Everest", 220, 20, "Automatic", "Diesel");
                            System.out.println("Everest Car:");
                            everestCar.displayInfo();
                        } catch (InvalidPriceException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            Landcruiser landcruiserCar = new Landcruiser("Black", "2026", 10000000, "Landcruiser", 250, 22, "Automatic", "Diesel");
                            System.out.println("Landcruiser Car:");
                            landcruiserCar.displayInfo();
                        } catch (InvalidPriceException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid SUV Model selection.");
                }
                break;
            case 3:
                System.out.println("Crossover option selected.");
                System.out.println("The crossover models in this example are BRV, Veloz, and Xpander.");
                break;
            default:
                System.out.println("Invalid Car Type selection.");
        }

        scanner.close();
    }
}
