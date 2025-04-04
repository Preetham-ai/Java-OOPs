class Product {
    void display() {
        System.out.println("Displaying product");
    }
}

class Electronics extends Product {
    void checkWarranty() {
        System.out.println("Checking electronics warranty");
    }
}

class Clothing extends Product {
    void checkSize() {
        System.out.println("Checking clothing size");
    }
}

class Smartphone extends Electronics {
    void installApp() {
        System.out.println("Installing smartphone app");
    }
}

class TestHybrid2 {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone();
        Clothing shirt = new Clothing();
        phone.display();
        phone.checkWarranty();
        phone.installApp();
        shirt.display();
        shirt.checkSize();
    }
}
