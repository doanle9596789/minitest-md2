package material;

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
    public double getRealMoney() {
        LocalDate today = manufacturingDate;
        LocalDate ExpiryDate = getExpiryDate();
        if (today.isAfter(ExpiryDate.minusMonths(2))) {
            return getAmount() - (getAmount() * 0.4);
        } else if (today.isAfter(ExpiryDate.minusMonths(4))) {
            return getAmount() - (getAmount() * 0.2);
        } else {
            return getAmount() - (getAmount() * 0.05);
        }
    }

    @Override
    public double getAmount() {
        return getCost() * getQuantity();
    }

    @Override
    public LocalDate getExpiryDate() {
        return LocalDate.now().plusYears(1);
    }

    @Override
    public String toString() {
        return "Bột mỳ : " +
                "Số lượng =" + quantity +
                ",id='" + id + '\'' +
                ", tên='" + name + '\'' +
                ", ngày sản xuất=" + manufacturingDate +
                ", Giá =" + cost;
    }
}