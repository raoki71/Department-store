package dept_store;

import dept_store.Sale;

public interface SaleRepository {

    Sale findByReceiptNumber(String receiptNumber);

    double getTotalSales();
    double getTotalRefunds();
}