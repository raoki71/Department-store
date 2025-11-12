package dept_store;

public class StoreSystem {
    public void notifyWorker(CartInterface cart){
        ShiftWork shiftWork = new ShiftWork();
        // Note that Employee is an abstract class DOSENT WORK ---> new Employee("Emily", 0.00, "some role");
        // Instead create a concrete class (e.g.) Casher
        Employee employee;
        employee.returnItemsToShelves(cart);
    }
}
