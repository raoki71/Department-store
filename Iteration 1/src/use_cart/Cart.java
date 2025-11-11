import java.util.ArrayList;
import java.util.List;
import primary.*;

public class Cart implements CartInterface {
    private String cartId;
    private List<Item> items;
    private int capacity;
    private CartStatus status;

    public Cart(String cartId, int capacity){
        this.cartId = cartId;
        this.capacity = capacity;
        this.items = new ArrayList<>();
        this.status = CartStatus.NOT_OCCUPUED;
    }

    @Override
    public void addItem(Item item){
        if (!isFull()){
            items.add(item);
        }
        else {
            System.out.println("Your cart is full. Remove items or get a larger cart.");
        }
    }

    @Override
    public void removeItem(Item item) {
        if (items.remove(item)){
            System.out.println("Item removed successfully.");
        }
        else {
            System.out.println("Failed to remove item.");
        }
    }

    @Override
    public boolean isFull(){
        return items.size() >= capacity;
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    @Override
    public List<Item> getItems(){
        return items;
    }

    @Override
    public CartStatus getStatus(){
        return status;
    }

    public void setStatus(CartStatus status){
        this.status = status;
    }
}
