package dept_store;

public class CartItem {

    private String lineId;
    private String name;
    private double unitPrice;
    private int quantity;

    public CartItem(String lineId, String name, double unitPrice, int quantity) {
        this.lineId = lineId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getLineId() {
        return lineId;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}