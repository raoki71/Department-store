package dept_store;

import java.time.LocalDateTime;
import java.util.List;

public class Sale {
    private int saleId;
    private String receiptNumber;
    private LocalDateTime saleDate;
    private List<CartItem> cartItems;
    private double amount;

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    // small rename: plural to match the field
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}