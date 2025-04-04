public class InventoryItem {
    private String sku;
    private String name;
    private int quantity;
    private double price;
    
    public InventoryItem(String sku, String name, double price) {
        if(sku == null || sku.isEmpty()) throw new IllegalArgumentException("SKU cannot be empty");
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }
    
    public void restock(int amount) {
        if(amount <= 0) throw new IllegalArgumentException("Restock amount must be positive");
        this.quantity += amount;
    }
    
    public void sell(int amount) {
        if(amount <= 0) throw new IllegalArgumentException("Sale amount must be positive");
        if(amount > quantity) throw new IllegalStateException("Insufficient stock");
        this.quantity -= amount;
    }
    
    public double getInventoryValue() {
        return quantity * price;
    }
    
    public String getItemInfo() {
        return String.format("%s (%s) - %d units @ $%.2f", name, sku, quantity, price);
    }

    public static void main(String[] args) {
        InventoryItem laptop = new InventoryItem("LT1001", "Dell XPS 15", 1299.99);
        laptop.restock(10);
        System.out.println(laptop.getItemInfo());
        
        laptop.sell(3);
        System.out.println(laptop.getItemInfo());
        System.out.printf("Total inventory value: $%.2f%n", laptop.getInventoryValue());
    }
}
