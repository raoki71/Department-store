package dept_store;

public class ClearanceService {
    private ClearanceRepository repo;
    private Item item;

    public ClearanceService(ClearanceRepository repo){
        this.repo = repo;
    }

    public void putItemOnClearance(String id, double newPrice) {
        repo.putItemOnClearance(id,newPrice);
    }
}
