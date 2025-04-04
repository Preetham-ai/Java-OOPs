import java.util.*;

public class CollectionAnalyzer {
    public static <T> List<T> removeDuplicates(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }
    
    public static <T> Map<T, Integer> countOccurrences(List<T> list) {
        Map<T, Integer> counts = new HashMap<>();
        for(T item : list) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }
        return counts;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob");
        
        System.out.println("Original list: " + names);
        System.out.println("Without duplicates: " + removeDuplicates(names));
        System.out.println("Counts: " + countOccurrences(names));
    }
}

            Output :
              
16)
        a)
class InsufficientFundsException extends Exception {
    private double currentBalance;
    private double requestedAmount;
    
    public InsufficientFundsException(double current, double requested) {
        super(String.format("Current balance $%.2f is insufficient for $%.2f", current, requested));
        this.currentBalance = current;
        this.requestedAmount = requested;
    }
    
    public double getDeficit() {
        return requestedAmount - currentBalance;
    }
}

class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        balance -= amount;
        System.out.printf("Withdrawn $%.2f. New balance: $%.2f%n", amount, balance);
    }
}

public class Main {  
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.00);
        
        try {
            System.out.println("Initial balance: $500.00");
            account.withdraw(200.00);
            account.withdraw(350.00); // This will throw exception
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
            System.out.printf("You need $%.2f more to complete this transaction%n", e.getDeficit());
        }
        
        try {
            account.withdraw(100.00);
        } catch (InsufficientFundsException e) {
            System.out.println("This shouldn't be reached");
        }
    }
}
