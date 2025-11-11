import java.util.List;

import primary.*;

public interface CartInterface {
    void addItem(Item item);
    void removeItem(Item item);
    boolean isFull();
    int getItemCount();
    List<Item> getItems();
    CartStatus getStatus();
    void setStatus(CartStatus status);
}