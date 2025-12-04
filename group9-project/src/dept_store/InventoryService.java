package dept_store;

public class InventoryService {
    public void addBackToInventory(String itemName, int qty) {
        System.out.println("Inventory updated: +" + qty + " " + itemName);
    }
}
