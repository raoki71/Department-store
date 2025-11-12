package dept_store;

import java.util.Scanner;


public class InventoryDemo {
    public static void run() {
        Inventory inventory = new Inventory();
        inventory.loadFromFile();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== INVENTORY MANAGEMENT SYSTEM ===");
            System.out.println("1. Check Stock");
            System.out.println("2. Add Item");
            System.out.println("3. Update Item Quantity");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number.\n");
                continue;
            }

            switch (choice) {
                case 1 -> inventory.checkStock();
                case 2 -> {
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price;
                    try {
                        price = Double.parseDouble(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println(" Invalid price.\n");
                        continue;
                    }
                    System.out.print("Enter Quantity: ");
                    int qty;
                    try {
                        qty = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println(" Invalid quantity.\n");
                        continue;
                    }
                    inventory.addItem(new Item(id, name, price, qty));
                }
                case 3 -> {
                    System.out.print("Enter Item ID to update: ");
                    String id = sc.nextLine();
                    System.out.print("Enter new Quantity: ");
                    try {
                        int newQty = Integer.parseInt(sc.nextLine());
                        inventory.updateItem(id, newQty);
                    } catch (NumberFormatException e) {
                        System.out.println(" Invalid quantity input.\n");
                    }
                }
                case 4 -> {
                    System.out.println(" Exiting Inventory System.");
                    return;
                }
                default -> System.out.println(" Invalid option.\n");
            }
        }
    }

    public static void main(String[] args) {
        run();
    }
}
