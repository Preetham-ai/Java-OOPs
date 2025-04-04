class Vehicle {
 void startEngine() {
 System.out.println("Engine started");
 }
}
class Car extends Vehicle {
 void accelerate() {
 System.out.println("Car accelerating");
 }
}
class ElectricCar extends Car {
 void chargeBattery() {
 System.out.println("Battery charging");
 }
}
class TestMulti1 {
 public static void main(String[] args) {
 ElectricCar tesla = new ElectricCar();
 tesla.startEngine();
 tesla.accelerate();
 tesla.chargeBattery();
 }
}
