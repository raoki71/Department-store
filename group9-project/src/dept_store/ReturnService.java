package dept_store;
public class ReturnService {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    public ReturnService(InventoryService inv, PaymentService pay) {
        this.inventoryService = inv;
        this.paymentService = pay;
    }

    public ReturnRecord processReturn(Sale sale, String lineId, boolean conditionOk) {
        if (sale == null) throw new IllegalArgumentException("Sale not found");
        if (!conditionOk) throw new IllegalStateException("Item not in good quality");

        SaleLineItem item = sale.getLineItems()
                .stream()
                .filter(li -> li.getLineId().equals(lineId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item not in sale"));

        double refund = item.getUnitPrice() * item.getQuantity();

        // update inventory
        inventoryService.addBackToInventory(item.getProduct(), item.getQuantity());

        // issue refund
        paymentService.issueRefund(refund);

        // create return record
        ReturnRecord rec = new ReturnRecord();
        rec.setReturnId(java.util.UUID.randomUUID().toString());
        rec.setSale(sale);
        rec.setReturnDate(java.time.LocalDateTime.now());
        rec.setRefundAmount(refund);

        return rec;
    }
    
}