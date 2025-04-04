class Notification {
 void send(String message) {
 System.out.println("Sending: " + message);
 }
}
class EmailNotification extends Notification {
 void setRecipient(String email) {
 System.out.println("Email to: " + email);
 }
}
class TestSingle2 {
 public static void main(String[] args) {
 EmailNotification email = new EmailNotification();
 email.setRecipient("user@example.com");
 email.send("Your order is confirmed");
 }
}
