class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    
    int add(int a, int b, int c) {
        return a + b + c;
    }
    
    double add(double a, double b) {
        return a + b;
    }
}

class TestMethodOverloading1 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Sum (2+3): " + calc.add(2, 3));
        System.out.println("Sum (2+3+4): " + calc.add(2, 3, 4));
        System.out.println("Sum (2.5+3.7): " + calc.add(2.5, 3.7));
    }
}
