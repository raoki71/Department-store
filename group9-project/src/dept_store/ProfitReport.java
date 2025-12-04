package dept_store;

public class ProfitReport {
    private SaleRepository saleRepository;
    public double totalSales;
    public double refundTotals;

    public ProfitReport(double sales, double refundTotals){
            this.totalSales = sales;
            this.refundTotals = refundTotals;
    }

    public double netProfit(){
        return totalSales - refundTotals;
    }

}
