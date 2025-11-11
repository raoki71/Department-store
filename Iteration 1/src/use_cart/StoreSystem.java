public class StoreSystem {
    public void notifyWorker(CartInterface cart){
        ShiftWork shiftWork = new ShiftWork();
        Employee employee = new Employee(0.00, shiftWork);
        employee.returnItemsToShelves(cart);
    }
}
