abstract class Delivery {
    protected String trackingNumber;
    protected double weight;
    
    public Delivery(String trackingNumber, double weight) {
        this.trackingNumber = trackingNumber;
        this.weight = weight;
    }
    
    abstract double calculateShippingCost();
    abstract int getDeliveryDays();
    
    void printLabel() {
        System.out.println("Tracking #: " + trackingNumber);
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(String trackingNumber, double weight) {
        super(trackingNumber, weight);
    }
    
    double calculateShippingCost() {
        return 10 + (weight * 2.5);
    }

    int getDeliveryDays() {
        return 1;
    }
}

public class LogisticsDemo {
    public static void main(String[] args) {
        Delivery express = new ExpressDelivery("EXP123456", 3.5);
        
        express.printLabel();
        System.out.printf("Shipping cost: $%.2f%n", express.calculateShippingCost());
        System.out.println("Estimated delivery days: " + express.getDeliveryDays());
    }
}
