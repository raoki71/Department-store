package dept_store;

public class Cash {
	private double physCash=0.0;
	private double digCash=0.0;
	
	private double total=0.0;
	
	public double getTotal() {
		System.out.println("Count cash of today: $" + total);
		return total;
	}
	
	public double getPhysicalCashAmount() {
		return physCash;
	}
	
	public double getDigitalCashAmount() {
		return digCash;
	}
	
	public boolean addAmount(double amount, boolean isDigit) {
		boolean result = false;
		if(isDigit) {
			digCash += amount;
			total += amount;
			System.out.println("Add Digital cash: $" + amount);
			result = true;
		} else {
			physCash += amount;
			total += amount;
			System.out.println("Added Physical cash: $" + amount);
			result = true;
		}
		return result;
	}
}
