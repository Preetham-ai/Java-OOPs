class Payment {
 void processPayment(double amount) {
 System.out.println("Processing payment of $" + amount);
 }
}
class CreditCardPayment extends Payment {
 void verifyCard(String cardNumber) {
 System.out.println("Verifying card: " + cardNumber.substring(12));
 }
}
class TestSingle1 {
 public static void main(String[] args) {
 CreditCardPayment cc = new CreditCardPayment();
 cc.verifyCard("1234567812345678");
 cc.processPayment(99.99);
 }
}
