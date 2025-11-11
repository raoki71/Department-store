package use_cases;

import java.util.List;

public class FittingRoomQueue {
    private final String customerId;
    private final List<ClothingItem> items;

    public FittingRoomQueue(String customerId, List<ClothingItem> items) {
        this.customerId = customerId;
        this.items = items;
    }

    public String getCustomerId() { 
    	return customerId; 
    }
    public List<ClothingItem> getItems() {
    	return items; 
    }
}