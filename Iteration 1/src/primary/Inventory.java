package primary;

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
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                items.add(Item.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No existing inventory file found.");
        }
    }

    @Override
    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Item item : items) {
                bw.write(item.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

    public void addItem(Item newItem) {
        items.add(newItem);
        saveToFile();
    }

    public void updateItem(String id, int newQty) {
        for (Item item : items) {
            if (item.getItemID().equals(id)) {
                item.updateStock(newQty);
                break;
            }
        }
        saveToFile();
    }

    public void checkStock() {
        if (items.isEmpty()) System.out.println("No items found in inventory.");
        else items.forEach(System.out::println);
    }
}

