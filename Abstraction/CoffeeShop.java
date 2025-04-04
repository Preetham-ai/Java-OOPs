abstract class CoffeeMaker {
    protected int waterLevel;
    
    public CoffeeMaker(int waterLevel) {
        this.waterLevel = waterLevel;
    }
    
    abstract void brewCoffee();
    abstract void cleanMachine();
    
    void checkWater() {
        System.out.println("Water level: " + waterLevel + "ml");
    }
}

class EspressoMachine extends CoffeeMaker {
    public EspressoMachine(int waterLevel) {
        super(waterLevel);
    }
    
    void brewCoffee() {
        if (waterLevel >= 30) {
            System.out.println("Brewing espresso shot");
            waterLevel -= 30;
        } else {
            System.out.println("Not enough water");
        }
    }
    
    void cleanMachine() {
        System.out.println("Running espresso machine cleaning cycle");
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        CoffeeMaker machine = new EspressoMachine(100);
        
        machine.checkWater();
        machine.brewCoffee();
        machine.brewCoffee();
        machine.brewCoffee(); 
        machine.cleanMachine();
    }
}
