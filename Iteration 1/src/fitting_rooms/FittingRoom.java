// Jaida Slife
// jaidarm@iastate.edu
// 385211868

package fitting_rooms;

import java.util.ArrayList;
import java.util.List;


//the FittingRoomManager calls the methods from this class

public class FittingRoom {
    private final int roomNumber;
    private boolean isOccupied;
    
    private List<ClothingItem> initialItems; //items that costumer started with

    public FittingRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
        this.initialItems = new ArrayList<>();
    }

    /**
     * Step 1: Attendant checks in the customer and items.
     * @param items A list of item IDs/descriptions.
     */
    public void checkIn(List<ClothingItem> items) {
        if (isOccupied) {
            System.out.println("Room " + roomNumber + " is busy.");
            return;
        }
        this.isOccupied = true;
        this.initialItems = new ArrayList<>(items); // Copy the list
        System.out.println("Room " + roomNumber + " assigned. Initial count: " + initialItems.size());
        System.out.println("Items: " + initialItems);
    }
    
    /**
     * Step 2: Customer requests size change / attendant assists.
     * This method simulates swapping items (e.g., exchanging item 'A' for 'A-L').
     * @param newItem The item description taken in (e.g., "Shirt-L").
     */
    public void requestItem(String newItem, String newSize) {
        if (!isOccupied) {
            System.out.println("Room " + roomNumber + " is vacant, exchange failed.");
            return;
        }
                
        // Find and remove the returned item from the initial list
        initialItems.add(new ClothingItem(newItem, newSize)); // Add the new item
        System.out.println("\n--- Item request in Room " + roomNumber + ": " + newItem + " in size " + newSize +  " ---" );
        System.out.println("Gave Room " + roomNumber + ": " + newItem + " in size " + newSize);
        System.out.println("Room " + roomNumber + " now has " + initialItems.size()+ " items");
        
        // once inventory is implemented and added
//        System.out.println("ERROR: Could not find item " + newItem + " for exchange.");
    }

    /**
     * Step 3 & 4: Customer checks out and returns unwanted items.
     * The final count verification happens here.
     * @param unwantedItems Items the customer is NOT keeping.
     */
    public void checkOutAndVerify(List<ClothingItem> unwantedItems) {
        if (!isOccupied) {
            System.out.println("Room " + roomNumber + " is already vacant.");
            return;
        }

        int finalReturnedCount = unwantedItems.size();
        int initialTotalCount = initialItems.size();
        
        System.out.println("\n--- Checkout & Verification for Room " + roomNumber + " ---");
        System.out.println("Items Customer is keeping: " + (initialTotalCount - finalReturnedCount));
        System.out.println("Items Returned to Attendant: " + finalReturnedCount);
        
        int check = initialTotalCount - finalReturnedCount;
        int check2 = check + finalReturnedCount;
        
        // Final verification check
        if (initialTotalCount == check2) {
            System.out.println("**VERIFICATION SUCCESS:** All " + initialTotalCount + " items accounted for.");
        } else if (finalReturnedCount < initialTotalCount) {
            // This assumes the items the customer *keeps* are not part of the returned list.
            System.out.println("!! VERIFICATION WARNING !!: Returned count (" + finalReturnedCount + ") is less than the initial count (" + initialTotalCount + ").");
            System.out.println("The customer might be keeping items, or there is a discrepancy.");
        } else {
             // This case is unlikely if we trust the initial count, but good practice to catch.
            System.out.println("!! VERIFICATION ERROR !!: Returned count is greater than initial count.");
        }

        // Finalize the checkout process
        this.isOccupied = false;
        this.initialItems.clear(); // Clear item list
        System.out.println("Room " + roomNumber + " is now vacant.");
    }
    
    //getters 
    public boolean isOccupied() {
    	return isOccupied;
    }
    public int getRoomNumber() { 
    	return roomNumber;
    }
    public int getInitialCount() {
    	return initialItems.size(); 
    }
}

