class Shape {
 void draw() {
 System.out.println("Drawing shape");
 }
}
class Circle extends Shape {
 void calculateArea(double radius) {
 System.out.println("Circle area: " + (3.14 * radius * radius));
 }
}
class Square extends Shape {
 void calculateArea(double side) {
 System.out.println("Square area: " + (side * side));
 }
}
class TestHier1 {
 public static void main(String[] args) {
 Circle c = new Circle();
 Square s = new Square();
 c.draw();
 c.calculateArea(5.0);
 s.draw();
 s.calculateArea(4.0);
 }
}

