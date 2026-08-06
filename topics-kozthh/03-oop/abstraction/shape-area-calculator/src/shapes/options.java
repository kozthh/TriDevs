package shapes;
import java.util.Scanner;

public class options {

        circle circle;
        square square;
        triangle triangle;

        public options(Scanner in, int choice) {
            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    double radius = in.nextDouble();
                    circle = new circle(radius);
                    System.out.println("Area: " + circle.getArea());
                    break;
                case 2:
                    System.out.print("Enter side 1: ");
                    double side1 = in.nextDouble();
                    System.out.print("Enter side 2: ");
                    double side2 = in.nextDouble();
                    square = new square(side1, side2);
                    System.out.println("Area: " + square.getArea());
                    break;
                case 3:
                    System.out.print("Enter base: ");
                    double base = in.nextDouble();
                    System.out.print("Enter height: ");
                    double height = in.nextDouble();
                    triangle = new triangle(base, height);
                    System.out.println("Area: " + triangle.getArea());
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
