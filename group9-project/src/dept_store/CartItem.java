package dept_store;

public class CartItem extends Item{
    public CartItem(String itemID, String name, double price, int quantity) {
		super(itemID, name, price, quantity);
		// TODO Auto-generated constructor stub
	}

	private int cartItemId;
    private Item item;
    private int quantity; 
    private double unitPrice;

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

}
