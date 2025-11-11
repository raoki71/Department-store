
import return_item.Sale;

public interface SaleRepository {

    Sale findByReceiptNumber(String receiptNumber);

}