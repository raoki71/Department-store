package dept_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegisterDatabase {

private String regId;
private HashMap<String, CashRegister> regList=new HashMap<>();
	
	private Cash cash=null;
	public CashRegister getRegister(String regId) {
		return new CashRegister(regId);
	}
	
	/**
	 * 
	 * This method adds the specified cash amount to the Register of regId
	 * @param cash
	 * @param regId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public boolean addCash(Cash cash, String regId) throws ClassNotFoundException {
		if(this.getRegister(regId)!=null) {
			CashRegister cashReg = getRegister(regId);
			regList.put(regId, cashReg);
			return cashReg.addCash(cash);
		}
		return false;
	}
	
	public boolean removeCash(String regId) {
		
		return false;
	}
	
	
	
	/**
	 * 
	 * This method counts the number of cash in the specified CashRegister with regId 
	 * @param regId
	 * @return - 
	 * @throws ClassNotFoundException
	 */
	public double countCash(String regId) throws ClassNotFoundException {
		CashRegister cashReg= regList.get(regId);
		if(cashReg!=null) {
			return cashReg.countCash();
		}
		return 0.0;
	}

	private Cash getCashInstance() {
		if(cash==null)
			cash=new Cash();
		return cash;
	}
}
