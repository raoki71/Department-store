package dept_store;

public class Customer {
    private String customerId;
    private String name;
    private CartInterface cart;

    public Customer(String customerId, String name){
        this.customerId = customerId;
        this.name = name;
    }

    public void SelectCart(CartInterface cart){
        this.cart = cart;
        cart.setStatus(CartStatus.OCCUPIED);
    }

    public void addItemToCart(Item item){
        cart.addItem(item);
    }

    public void removeItemFromCart(Item item){
        cart.removeItem(item);
    }

    public void abandonCart(StoreSystem system){
        cart.setStatus(CartStatus.ABANDONED);
        system.notifyWorker(cart);
    }
}
