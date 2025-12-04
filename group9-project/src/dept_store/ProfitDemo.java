package dept_store;

public class ProfitDemo {
        public static void main(String[] args) {

            InMemorySaleRepository saleRepo = new InMemorySaleRepository();
            ProfitReportService reportService = new ProfitReportService(saleRepo);

            ProfitReport report = reportService.createProfitReport();

            System.out.println("Total Sales: " + report.totalSales);
            System.out.println("Total Refunds: " + report.refundTotals);
            System.out.println("Net Profit: " + report.netProfit());
        }

}
