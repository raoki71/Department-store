// Jaida Slife
// jaidarm@iastate.edu
// 385211868

package use_cases;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// The FittingRoomSim calls the methods from this class

public class FittingRoomManager {
    private List<FittingRoom> rooms;
    // The Queue to hold customers waiting for a room
    private Queue<FittingRoomQueue> waitingLine; 

    public FittingRoomManager(int totalRooms) {
        rooms = new ArrayList<>();
        for (int i = 1; i <= totalRooms; i++) {
            rooms.add(new FittingRoom(i));
        }
        waitingLine = new LinkedList<>();
        System.out.println("Manager initialized with " + totalRooms + " rooms.");
    }

    /**
     * Attempts to assign a customer, adding them to the queue if full.
     */
    public void enterLine(String customerId, List<ClothingItem> items) {
        System.out.println("\n--- Customer " + customerId + " Arrived ---");
        
        // Try to find a vacant room immediately
        for (FittingRoom room : rooms) {
            if (!room.isOccupied()) {
                System.out.println("Room " + room.getRoomNumber() + " is available.");
                room.checkIn(items); // Use the checkIn method from previous response
                return; // Room assigned, job done
            }
        }

        // If no room was found, add them to the waiting queue
        FittingRoomQueue customer = new FittingRoomQueue(customerId, items);
        waitingLine.offer(customer); // 'offer' adds to the end of the queue
        System.out.println("All rooms busy. Customer " + customerId + " added to the waiting line.");
    }
    
    public void requestNewItem(int roomNumber, String newItem, String newSize) {
    	  FittingRoom vacantRoom = null;

          // 1. Find the correct room using a simple loop
          for (FittingRoom room : rooms) {
              if (room.getRoomNumber() == roomNumber) {
                  vacantRoom = room;
                  break; // Stop searching once found
              }
          }
          if (vacantRoom != null) {
        	  vacantRoom.requestItem(newItem, newSize);
          }
          
    }

    /**
     * Called when a customer checks out, which triggers a check for the waiting line.
     */
    public void vacateRoomAndCheckQueue(int roomNumber, List<ClothingItem> unwantedItems) {
        FittingRoom vacantRoom = null;

        // 1. Find the correct room using a simple loop
        for (FittingRoom room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                vacantRoom = room;
                break; // Stop searching once found
            }
        }

        if (vacantRoom != null) {
            // 2. Perform the verification/checkout process
            vacantRoom.checkOutAndVerify(unwantedItems); 
            
            // 3. Check the waiting line for the next customer
            if (!waitingLine.isEmpty()) {
                FittingRoomQueue nextCustomer = waitingLine.poll(); 
                System.out.println("\n*** Waiting Line Check ***");
                System.out.println("Customer " + nextCustomer.getCustomerId() + " is next, moving to Room " + roomNumber + ".");

                // Assign the now vacant room to the next waiting customer
                vacantRoom.checkIn(nextCustomer.getItems());
            } else {
                System.out.println("Waiting line is empty. Room " + roomNumber + " is now free.");
            }
        } else {
            // 4. Handle the case where the room number was invalid
            System.out.println("Error: Room number " + roomNumber + " not found in the manager's list.");
        }
    }
    
    // Add displayStatus() and the rest of your original methods here...
    // (Omitted for brevity, but they would remain the same)
    
    public void displayQueueStatus() {
        System.out.println("\n--- Waiting Line Status ---");
        System.out.println("Customers waiting: " + waitingLine.size());
        if (!waitingLine.isEmpty()) {
            System.out.println("Next customer up: " + waitingLine.peek().getCustomerId());
        }
    }
}
