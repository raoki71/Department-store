package primary;

public class Item {
    private String itemID;
    private String name;
    private double price;
    private int quantity;

    public Item(String itemID, String name, double price, int quantity) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void updateStock(int newQuantity) {
        this.quantity = newQuantity;
    }

    @Override
    public String toString() {
        return itemID + "," + name + "," + price + "," + quantity;
    }

    public static Item fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) return null; 
        try {
            return new Item(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String getItemID() { return itemID; }
    public int getQuantity() { return quantity; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

