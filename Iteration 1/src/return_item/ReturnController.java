import return_item.ReturnService;

public class ReturnController {

    private final SaleRepository saleRepo;
    private final ReturnService returnService;

    public ReturnController(SaleRepository saleRepo, ReturnService returnService) {
        this.saleRepo = saleRepo;
        this.returnService = returnService;
    }

    public ReturnRecord startReturn(String receiptNumber, String lineId, boolean conditionOk) {
        Sale sale = saleRepo.findByReceiptNumber(receiptNumber);
        return returnService.processReturn(sale, lineId, conditionOk);
    }
}