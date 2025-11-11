// Jaida Slife
// jaidarm@iastate.edu
// 385211868

package fitting_rooms;

// this class gives clothing item a name and size

public class ClothingItem {
String itemName;
String size;
public ClothingItem(String itemName, String size){
	
	this.itemName = itemName;
	this.size = size;
	
	
}
public String toString() {
	return itemName + "-" + size;
	
}

	
}

