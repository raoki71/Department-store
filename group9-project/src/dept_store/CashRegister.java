package dept_store;

/**
 * @author Rei Aoki
 */
public class CashRegister {
	
	private String regId="";
	private double total=0;
	
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
		this.cash = cash;
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
	public double countCash() {
		System.out.println();
		System.out.println("Register ID: " + getRegId());
		return this.cash.countTotal();
	}
//
//	private Cash getCashInstance() {
//		if(cash==null)
//			cash=new Cash();
//		return cash;
//	}
}
