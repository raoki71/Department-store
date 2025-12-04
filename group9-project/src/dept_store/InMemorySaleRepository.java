package dept_store;
import java.util.HashMap;

import dept_store.Sale;

public class InMemorySaleRepository implements SaleRepository {

    private HashMap<String, Sale> saleDb = new HashMap<>();

    @Override
    public Sale findByReceiptNumber(String receiptNumber) {
        return saleDb.get(receiptNumber); 
    }

    @Override
    public double getTotalSales() {
            return Math.random() * 2000;
    }

    @Override
    public double getTotalRefunds(){
        return  Math.random() * 500;
    }

    public void save(Sale sale) {
        if (sale != null && sale.getReceiptNumber() != null) {
            saleDb.put(sale.getReceiptNumber(), sale);
        }
    }

}