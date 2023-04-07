package Main;
import java.util.ArrayList;


public class Restaurant {
    private String name;
    private String type;
    private Double dfee;
    private ArrayList<Food> foods;

    public Restaurant(String name, String type, Double dfee, ArrayList<Food> foods) {
        this.name = name;
        this.type =type;
        this.dfee = dfee;
        this.foods =  foods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getDfee() {
        return dfee;
    }

    public void setDfee(Double dfee) {
        this.dfee = dfee;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }


    //For Food
public static class Food {
     private int amount;
     private String fName;
     private Double fPrice;


     public Food(String fName, Double fPrice){
            this.fName = fName;
            this.fPrice = fPrice;
     }

     public int getAmount() {
         return amount;
     }

     public void setAmount(int amount) {
            this.amount = amount;
     }

     public String getfName() {
            return fName;
     }

     public void setfName(String fName) {
            this.fName = fName;
     }

     public Double getfPrice() {
            return fPrice;
     }

     public void setfPrice(Double fPrice) {
            this.fPrice = fPrice;
     }
    }
}





