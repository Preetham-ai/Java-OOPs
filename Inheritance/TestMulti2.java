class Employee {
 void work() {
 System.out.println("Employee working");
 }
}
class Manager extends Employee {
 void conductMeeting() {
 System.out.println("Manager conducting meeting");
 }
}
class SeniorManager extends Manager {
 void approveBudget() {
 System.out.println("Approving department budget");
 }
}
class TestMulti2 {
 public static void main(String[] args) {
 SeniorManager sm = new SeniorManager();
 sm.work();
 sm.conductMeeting();
 sm.approveBudget();
 }
}