class Employee {
    String name;
    int id;
    String department;
    
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
        this.department = "General";
    }
   
    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }
    
    void displayInfo() {
        System.out.println(name + " (ID:" + id + ") - " + department + " Dept.");
    }
}

class TestConstructorOverloading {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", 1001);
        Employee emp2 = new Employee("Bob", 1002, "Engineering");
        emp1.displayInfo();
        emp2.displayInfo();
    }
}
