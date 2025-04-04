interface PaymentMethod {
    boolean authorize(double amount);
    void processPayment(double amount);
    void refund(double amount);
}

class CryptoPayment implements PaymentMethod {
    public boolean authorize(double amount) {
        System.out.println("Authorizing crypto payment...");
        return true;
    }
    
    public void processPayment(double amount) {
        System.out.println("Processing crypto payment of " + amount + " BTC");
    }
    
    public void refund(double amount) {
        System.out.println("Refunding " + amount + " BTC");
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentMethod payment = new CryptoPayment();
        
        if(payment.authorize(100.0)) {
            payment.processPayment(100.0);
        }
        
        payment.refund(25.0);
    }
}
