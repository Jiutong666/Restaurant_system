package Main;
public class Delivery {
    private Integer delAmount;
    private Double delDis;


    public Delivery(Integer delAmount, Double delDis) {
        this.delAmount = delAmount;
        this.delDis = delDis;
    }

    public Integer getDelAmount() {
        return delAmount;
    }

    public void setDelAmount(Integer delAmount) {
        this.delAmount = delAmount;
    }

    public Double getDelDis() {
        return delDis;
    }

    public void setDelDis(Double delDis) {
        this.delDis = delDis;
    }
}
