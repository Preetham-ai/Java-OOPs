class Account {
    void withdraw(double amount) {
        System.out.println("Withdrawing $" + amount + " from generic account");
    }
    
    void deposit(double amount) {
        System.out.println("Depositing $" + amount + " to generic account");
    }
}

class SavingsAccount extends Account {
    void withdraw(double amount) {
        System.out.println("Withdrawing $" + amount + " from savings (2-day clearance)");
    }
    
    void deposit(double amount) {
        System.out.println("Depositing $" + amount + " to savings (earning interest)");
    }
    
    void applyInterest() {
        System.out.println("Applying monthly interest");
    }
}

class TestMethodOverriding2 {
    public static void main(String[] args) {
        Account generic = new Account();
        SavingsAccount mySavings = new SavingsAccount();
        
        generic.deposit(500);
        generic.withdraw(100);
        
        mySavings.deposit(1000);
        mySavings.withdraw(200);
        mySavings.applyInterest();
    }
}
