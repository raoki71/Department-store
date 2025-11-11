import java.util.Scanner;
import primary.*;

public class CartDemo {
    public static void main(String[] args) {
        // Create store system
        StoreSystem system = new StoreSystem();

        // Cart with capacity 3
        Cart cart = new Cart("C001", 3);

        // Create a customer
        Customer customer = new Customer("U001", "Bob");

        // Customer selects the cart
        customer.SelectCart(cart);

        // Create items
        Item item1 = new Item("I001", "Shirt", 15.99, 1);
        Item item2 = new Item("I002", "Pants", 19.99, 1);
        Item item3 = new Item("I003", "Shoes", 65.99, 1);
        Item item4 = new Item("I004", "Hat", 10.99, 1);

        // Add items to the cart
        customer.addItemToCart(item1);
        customer.addItemToCart(item2);
        customer.addItemToCart(item3);
        customer.addItemToCart(item4);

        // Remove an item from the cart
        customer.removeItemFromCart(item2);

        // Try to add item4 again
        customer.addItemToCart(item4);

        // Abandon cart
        customer.abandonCart(system);
    }
}
