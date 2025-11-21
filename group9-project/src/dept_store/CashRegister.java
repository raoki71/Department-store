package dept_store;

/**
 * @author Rei Aoki
 */
public class CashRegister {
	
	private String regId;
	private double total;
	
	private Cash cash=null;
	
	public CashRegister(String regId) {
		this.regId = regId;
		
	}
	public String getRegId() {
		return regId;
	}
	
	/**
	 * 
	 * This method adds the cash amount to the current register.
	 * @param cash
	 * @return
	 */
	public boolean addCash(Cash cash) {
		if(cash.getTotal() > 0) {
			total += cash.getTotal();
			return true;
		}
		return false;
	}
	
	/**
	 * This method counts the cash amount of the current register.
	 * @param regId
	 * @return - 
	 * @throws ClassNotFoundException
	 */
	public double countCash() throws ClassNotFoundException {
		return this.getCashInstance().getTotal();
	}

	private Cash getCashInstance() {
		if(cash==null)
			cash=new Cash();
		return cash;
	}
}
