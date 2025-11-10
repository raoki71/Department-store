package Iteration1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.loadFromFile();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Check Stock\n2. Add Item\n3. Update Item Quantity");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> inventory.checkStock();
            case 2 -> {
                System.out.print("Enter ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Price: ");
                double price = sc.nextDouble();
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                inventory.addItem(new Item(id, name, price, qty));
            }
            case 3 -> {
                System.out.print("Enter Item ID to update: ");
                String id = sc.nextLine();
                System.out.print("Enter new Quantity: ");
                int newQty = sc.nextInt();
                inventory.updateItem(id, newQty);
            }
            default -> System.out.println("Invalid option.");
        }
    }
}

