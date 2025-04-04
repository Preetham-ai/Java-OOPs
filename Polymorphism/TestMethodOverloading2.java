class Printer {
    void print(String text) {
        System.out.println("Printing: " + text);
    }
    
    void print(String text, int copies) {
        for(int i = 0; i < copies; i++) {
            System.out.println("Copy " + (i+1) + ": " + text);
        }
    }
  
    void print(String text, boolean uppercase) {
        System.out.println("Printing: " + (uppercase ? text.toUpperCase() : text));
    }
}

class TestMethodOverloading2 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print("Hello World");
        printer.print("Important Notice", 3);
        printer.print("confidential", true);
    }
}
