package dept_store;

import java.time.LocalDateTime;
import java.util.List;

public class ReturnDemo {

    public static void main(String[] args) {

        // Services
        InventoryService inventoryService = new InventoryService();
        PaymentService paymentService = new PaymentService();
        ReturnService returnService = new ReturnService(inventoryService, paymentService);

        Item item1  = new Item("I001", "Shirt", 20.00, 4);
        Item item2  = new Item("I002", "Pants", 35.00, 1);
        Item item3  = new Item("I003", "Shoes", 60.00, 2);

        CartItem ci1 = new CartItem("LINE-1", item1.getName(), item1.getPrice(), item1.getQuantity());
        CartItem ci2 = new CartItem("LINE-2", item2.getName(), item2.getPrice(), item2.getQuantity());
        CartItem ci3 = new CartItem("LINE-3", item3.getName(), item3.getPrice(), item3.getQuantity());

        Sale sale1 = new Sale();
        sale1.setSaleId(1);
        sale1.setReceiptNumber("R10001");
        sale1.setSaleDate(LocalDateTime.now());
        sale1.setAmount(item1.getQuantity() * item1.getPrice());
        sale1.setCartItems(List.of(ci1));

        Sale sale2 = new Sale();
        sale2.setSaleId(2);
        sale2.setReceiptNumber("R10002");
        sale2.setSaleDate(LocalDateTime.now());
        sale2.setAmount(
                (item2.getPrice() * item2.getQuantity()) +
                        (item3.getPrice() * item3.getQuantity())
        );
        sale2.setCartItems(List.of(ci2, ci3));

        System.out.println("=== Processing return for sale " + sale2.getReceiptNumber() + " item Shoes ===");
        ReturnRecords rec1 = returnService.processReturn(sale2, "Shoes", true);

        System.out.println("Return created:");
        System.out.println("Return ID: " + rec1.getReturnId());
        System.out.println("Sale receipt: " + rec1.getSale().getReceiptNumber());
        System.out.println("Refund amount: $" + rec1.getRefundAmount());
        System.out.println("Return date: " + rec1.getReturnDate());

        System.out.println("\n=== Processing return for sale" + sale1.getReceiptNumber() + " item Shirt ===");
        ReturnRecords rec2 = returnService.processReturn(sale1, "Shirt", true);

        System.out.println("Return created:");
        System.out.println("Return ID: " + rec2.getReturnId());
        System.out.println("Sale receipt: " + rec2.getSale().getReceiptNumber());
        System.out.println("Refund amount: $" + rec2.getRefundAmount());
        System.out.println("Return date: " + rec2.getReturnDate());
    }
}