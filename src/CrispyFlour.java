import java.time.LocalDate;

public class CrispyFlour extends Material {
    private int quantity;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        LocalDate now = LocalDate.now();
        LocalDate ex = this.getExpiryDate();
        if (now.isBefore(ex)) return 0;
        else if (now.isBefore(ex) && now.isAfter(ex.minusMonths(2)) || now.equals(ex.minusMonths(2)))
            return getAmount()*0.6;
        else if (now.isBefore(ex) && now.isAfter(ex.minusMonths(4)) || now.equals(ex.minusMonths(4)))
            return getAmount()*0.8;
        else return getAmount()*0.95;
    }
}
