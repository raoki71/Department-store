package dept_store;

public class ItemPrinter {
    private ClearanceRepository clearanceRepository;

    public ItemPrinter(ClearanceRepository clearanceRepository ){
        this.clearanceRepository = clearanceRepository;
    }

    public void printItem(Item item){
        Double clearancePrice = clearanceRepository.getClearancePrice(item.getItemID());
        if (clearancePrice == null) {
            System.out.println(item.getName() + " | Price: $" + item.getPrice());
        } else {
            System.out.println(item.getName() + " | Original: $" + item.getPrice() + " | Clearance: $" + clearancePrice);
        }
    }
}
