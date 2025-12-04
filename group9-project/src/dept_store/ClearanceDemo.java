package dept_store;

public class ClearanceDemo {

    public static void main(String[] args) throws Exception {

        double discount_rate = 0.40;
        Item item1 = new Item("I1", "Shirt", 20.0, 10);

        double clearance_price = item1.getPrice() * (1 - discount_rate);

        ClearanceRepository clearanceRepo = new ClearanceRepository();
        ClearanceService clearanceService = new ClearanceService(clearanceRepo);
        ItemPrinter printer = new ItemPrinter(clearanceRepo);

        System.out.println("Before clearance:");
        printer.printItem(item1);

        clearanceService.putItemOnClearance("I1", clearance_price);

        System.out.println("After clearance:");
        printer.printItem(item1);
    }
}
