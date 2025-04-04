class BankAccount {
    String accountHolder;
    double balance;
    
    public BankAccount(String name, double initialDeposit) {
        this.accountHolder = name;
        this.balance = initialDeposit;
        System.out.println("Account created for " + name + " with $" + initialDeposit);
    }
    
    void displayBalance() {
        System.out.println("Balance for " + accountHolder + ": $" + balance);
    }
}

class TestConstructor {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", 1000.0);
        account.displayBalance();
    }
}
