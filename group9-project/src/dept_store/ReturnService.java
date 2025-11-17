package dept_store;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReturnService {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    public ReturnService(InventoryService inv, PaymentService pay) {
        this.inventoryService = inv;
        this.paymentService = pay;
    }

    public ReturnRecords processReturn(Sale sale, String itemName, boolean conditionOk) {
        if (sale == null) throw new IllegalArgumentException("Sale not found");
        if (!conditionOk) throw new IllegalStateException("Item not in good quality");


        System.out.println("Items in sale " + sale.getReceiptNumber() + ":");
        sale.getCartItems().forEach(ci ->
                System.out.println(" - " + ci.getName() + " x" + ci.getQuantity())
        );

        CartItem item = sale.getCartItems()
                .stream()
                .filter(ci -> ci.getName().equals(itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item not in sale"));

        int refundInt = (int) (item.getUnitPrice() * item.getQuantity());

        inventoryService.addBackToInventory(item.getName(), item.getQuantity());
        paymentService.issueRefund(refundInt);

        return new ReturnRecords(
                UUID.randomUUID().toString(),
                sale,
                LocalDateTime.now(),
                refundInt
        );
    }
}