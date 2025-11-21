package dept_store;

/**
 * Cash Register Controller class
 * @author Rei Aoki
 */
public class CashRegisterController implements CashRegisterControllerInterface {

	/**
	 * 
	 */
	private RegisterDatabase regDatabase=null;
	
	/**
	 * 
	 * This is effectively controller method that initiates the count of the Register with regId
	 * @param regId -
	 * @return - 
	 * @throws ClassNotFoundException
	 */
	@Override
	public double countCash(String regId) throws ClassNotFoundException {
		return this.getRegisterDatabaseInstance().countCash(regId);
	}
	
	/**
	 * Instanciate the Register Database
	 * @return
	 */
	private RegisterDatabase getRegisterDatabaseInstance() {
		if(regDatabase==null)
			regDatabase = new RegisterDatabase();
		return regDatabase;
	}
	

}
