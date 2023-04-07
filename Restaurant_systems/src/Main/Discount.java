package Main;
public class Discount {
    private Double price1;
    private Double price2;
    private Double discount;

    public Discount(Double price1, Double price2, Double discount) {
        this.price1 = price1;
        this.price2 = price2;
        this.discount = discount;
    }

    public Double getPrice1() {
        return price1;
    }

    public void setPrice1(Double price1) {
        this.price1 = price1;
    }

    public Double getPrice2() {
        return price2;
    }

    public void setPrice2(Double price2) {
        this.price2 = price2;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
