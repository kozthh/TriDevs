package main;

import childamnimals.dog;
import mainAnimal.animal;

public class animain {
    public static void main(String[] args) {
        animal animal = new animal("Animal ", true);
        animal.breathe();
        System.out.println();
        animal.walk();
        System.out.println();
        animal.running();

        System.out.println();

        dog dog = new dog("Dog ", true, "Buddy");
        dog.breathe();
        System.out.println();
        dog.walk();
        System.out.println();
        dog.running();
    }
}