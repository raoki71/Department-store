import java.util.HashMap;
import return_item.Sale;

public class InMemorySaleRepository implements SaleRepository {

    private HashMap<String, Sale> saleDb = new HashMap<>();

    @Override
    public Sale findByReceiptNumber(String receiptNumber) {
        return saleDb.get(receiptNumber); 
    }

    // Optional helper: add a sale to the in-memory "database"
    public void save(Sale sale) {
        if (sale != null && sale.getReceiptNumber() != null) {
            saleDb.put(sale.getReceiptNumber(), sale);
        }
    }
}