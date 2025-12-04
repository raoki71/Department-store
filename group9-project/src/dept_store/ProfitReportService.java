package dept_store;

public class ProfitReportService {
    private SaleRepository sales;

    public ProfitReportService(SaleRepository s){
            this.sales = s;
    }

    public ProfitReport createProfitReport(){
        double totalSales = sales.getTotalSales();
        double refundTotals = sales.getTotalRefunds();
        return new ProfitReport(totalSales,refundTotals);

    }
}
