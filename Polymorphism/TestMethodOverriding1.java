class Vehicle {
    void start() {
        System.out.println("Vehicle starting...");
    }
    
    void stop() {
        System.out.println("Vehicle stopping...");
    }
}

class ElectricCar extends Vehicle {
    void start() {
        System.out.println("Electric car starting silently...");
    }
    
    void stop() {
        System.out.println("Electric car regenerating brakes...");
    }
    
    void charge() {
        System.out.println("Charging battery...");
    }
}

class TestMethodOverriding1 {
    public static void main(String[] args) {
        Vehicle regular = new Vehicle();
        ElectricCar tesla = new ElectricCar();
        
        regular.start();
        regular.stop();
        
        tesla.start();
        tesla.stop();
        tesla.charge();
    }
}
