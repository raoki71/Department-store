package dept_store;

import java.time.LocalDateTime;

import dept_store.Sale;

public class ReturnRecords {
    private String returnId;
    private Sale sale;
    private java.time.LocalDateTime returnDate;
    private double refundAmount;

    public ReturnRecords(String returnId, Sale sale, LocalDateTime returnDate, double refundAmount) {
        this.returnId = returnId;
        this.sale = sale;
        this.returnDate = returnDate;
        this.refundAmount = refundAmount;
    }

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    @Override
    public String toString() {
        return "ReturnRecords{" +
                "returnId='" + returnId + '\'' +
                ", saleId=" + (sale != null ? sale.getSaleId() : null) +
                ", returnDate=" + returnDate +
                ", refundAmount=" + refundAmount +
                '}';
    }
    
}