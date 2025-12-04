package dept_store;


import java.util.HashMap;
import java.util.Map;

public class ClearanceRepository {
    private Map<String, Double> clearancePrices = new HashMap<>();

    public void putItemOnClearance(String ItemId, Double updatedPrice){
                clearancePrices.put(ItemId, updatedPrice);

    }

    public Double getClearancePrice(String itemId){
        return clearancePrices.get(itemId);
    }


}
