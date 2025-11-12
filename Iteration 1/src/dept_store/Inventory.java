package dept_store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Inventory implements Manageable {
    private List<Item> items = new ArrayList<>();
    private final String FILE_NAME = "inventory.txt";

    @Override
    public void loadFromFile() {
        items.clear();
        System.out.println("Looking for file at: " + new java.io.File(FILE_NAME).getAbsolutePath());
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                Item item = Item.fromString(line);
                if (item != null) items.add(item);
            }
            System.out.println(" Inventory loaded successfully.\n");
        } catch (IOException e) {
            System.out.println(" No existing inventory file found. Starting fresh.\n");
        }
    }

    @Override
    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Item item : items) {
                bw.write(item.toString());
                bw.newLine();
            }
            System.out.println(" Inventory saved successfully.\n");
        } catch (IOException e) {
            System.out.println(" Error saving inventory.");
        }
    }

    public void addItem(Item newItem) {
        items.add(newItem);
        saveToFile();
        System.out.println(" Item added: " + newItem.getName() + "\n");
    }

    public void updateItem(String id, int newQty) {
        boolean found = false;
        for (Item item : items) {
            if (item.getItemID().equals(id)) {
                item.updateStock(newQty);
                found = true;
                break;
            }
        }
        if (found) {
            saveToFile();
            System.out.println(" Stock updated for item ID: " + id + "\n");
        } else {
            System.out.println(" Item not found in inventory.\n");
        }
    }

    public void checkStock() {
        if (items.isEmpty()) System.out.println(" No items found in inventory.\n");
        else {
            System.out.println(" Current Inventory:");
            System.out.printf("%-10s %-20s %-10s %-10s%n", "ItemID", "Name", "Price", "Qty");
            System.out.println("------------------------------------------------");
            for (Item item : items) {
                System.out.printf("%-10s %-20s %-10.2f %-10d%n",
                        item.getItemID(), item.getName(), item.getPrice(), item.getQuantity());
            }
            System.out.println();
        }
    }
}
