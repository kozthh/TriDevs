package mainAnimal;

public class animal { 
    private boolean isAlive;
    private String name; 

    public animal(String name, boolean isAlive) { 
        this.name = name; 
        this.isAlive = isAlive; 

    }

    public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

    public boolean getAlive() { 
        return isAlive;
    }
    
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void breathe() { 
        System.out.print(getName() + "The animal is breathing");
    }

    public void walk() { 
        System.out.print(getName() + "The animal is walking"); 
    }

    public void running(){ 
        System.out.print(getName()+ "animal is running");
    }

    public static void main(String[] args) {
        animal animal = new animal("Animal ", true);
        animal.breathe();
        System.out.println();
        animal.walk();
        System.out.println();
        animal.running();
    }
}
