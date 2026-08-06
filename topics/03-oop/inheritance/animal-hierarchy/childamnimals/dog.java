package childamnimals; 

import mainAnimal.animal; 

public class dog extends animal { 
    private String Dog; 

    public dog(String name, boolean isAlive, String Dog) { 
        super(name, isAlive);
        this.Dog = Dog;

    }

    public String getDog() { 
        return Dog;
    } 

    public void setDog(String dog){ 
        this.Dog = dog;
    }


    @Override
    public void breathe() { 
        System.out.print(getName() + "The Dog is breathing");
    }

    @Override
    public void walk() { 
        System.out.print(getName() + "The Dog is walking"); 
    }

    @Override
    public void running(){ 
        System.out.print(getName() + "Dog is running");
    }

    public static void main(String[] args) {
        dog dog = new dog("Dog ", true, "Buddy");
        dog.breathe();
        System.out.println();
        dog.walk();
        System.out.println();
        dog.running();
    }
}