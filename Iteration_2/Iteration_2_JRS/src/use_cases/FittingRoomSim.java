// Jaida Slife
// jaidarm@iastate.edu
// 385211868

package use_cases;

import java.util.Arrays;
import java.util.List;

public class FittingRoomSim {
    
    public static void main(String[] args) {
        // Initialize with a limited resource: only 2 rooms
        FittingRoomManager manager = new FittingRoomManager(3); 
        
        // Customer 1 and 2 take rooms 1 and 2
        manager.enterLine("CUST-1", Arrays.asList(new ClothingItem("Jacket", "S"),
        										  new ClothingItem("Jeans", "6"),
        										  new ClothingItem("Dress", "M")));
        //Customer 2
        manager.enterLine("CUST-2", Arrays.asList(new ClothingItem("Dress", "L")));
        
        // Customer 3 arrives - Queue is now needed
        manager.enterLine("CUST-3", Arrays.asList(new ClothingItem("Jeans", "4"),
        										  new ClothingItem("Sweatpants","M"),
        										  new ClothingItem("Sweatpants", "S")));
        
        //customer 4 - needs in queue
        manager.enterLine("CUST-4", Arrays.asList(new ClothingItem("Pants", "8"),
        									      new ClothingItem("Skirt", "L"),
        									      new ClothingItem("Jacket", "L")));
        
        manager.displayQueueStatus(); // CUST-4 is waiting

        // Customer 1 checks out (vacates Room 1)
        List<ClothingItem> cust1Returned = Arrays.asList(new ClothingItem("Jacket", "S")); // Kept the Jeans and dress
        manager.vacateRoomAndCheckQueue(1, cust1Returned); 
        
        // *** CUST-4 is automatically assigned to Room 1 ***
        
        //Customer 2 to request new size for dress
       manager.requestNewItem(2, "Dress", "S");
       
       //customer 2 checks out
       List<ClothingItem> cust2Returned = Arrays.asList(new ClothingItem("Dress", "M")); // Kept the size S
       manager.vacateRoomAndCheckQueue(2, cust2Returned); 
       
       //Customer 3 checks out
       List<ClothingItem> cust3Returned = Arrays.asList(new ClothingItem("Sweatpants", "S")); //Kept the size M sweats and jeans
       manager.vacateRoomAndCheckQueue(3, cust3Returned);
       
       
       //customer 4 checks out, but with wrong number of initial items
       List<ClothingItem> cust4Returned = Arrays.asList(new ClothingItem("Pants", "8"),
    		   											new ClothingItem("Jacket", "L"));
       manager.vacateRoomAndCheckQueue(1, cust4Returned);
       
        manager.displayQueueStatus(); // Queue is now empty
    }
}
