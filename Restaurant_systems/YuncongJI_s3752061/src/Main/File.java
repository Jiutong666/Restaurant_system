package Main;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class File {

    public static  ArrayList<Restaurant> readRes() throws FileNotFoundException {
        ArrayList<Restaurant> res = new ArrayList<>();

        Scanner scanner = new Scanner(new java.io.File("Restaurants.txt"));
            while (scanner.hasNextLine()) {
                String f = scanner.nextLine();
                String[] w = f.split(",");

                Restaurant restaurant = new Restaurant(w[0], w[1], Double.valueOf(w[2].substring(1)), new ArrayList<>());

                for (int i = 3; i < w.length; i++) {

                    String[] foods = w[i].split("-");

                    Restaurant.Food food = new Restaurant.Food(foods[0], Double.valueOf(foods[1].substring(1)));
                    restaurant.getFoods().add(food);
                }
                res.add(restaurant);
            }
        return res;
    }





    public static ArrayList<Discount> readDis() throws FileNotFoundException {
        ArrayList<Discount> res = new ArrayList<>();
        Scanner scanner = new Scanner(new java.io.File("Discounts.txt"));

            while (scanner.hasNextLine()) {
                String dis = scanner.nextLine();
                if ( dis.contains(")") ) {
                    String[] w1 = dis.split(",");

                    Discount discount = new Discount(Double.valueOf(w1[0].substring(1)),

                     w1[1].equals(")") ? Double.MAX_VALUE : Double.valueOf(w1[1].substring(0, w1[1].length() - 1)),

                     Double.valueOf(w1[2].substring(0, w1[2].length() - 1)));
                    res.add(discount);
                }
            }
        return res;
    }



    public static Delivery readCost() throws FileNotFoundException {
        Delivery cost = null;
        Scanner scanner = new Scanner(new java.io.File("Discounts.txt"));
            while (scanner.hasNextLine()) {
                String dis = scanner.nextLine();
                if (!dis.contains(")")) {
                    String[] w2 = dis.split(",");
                    cost = new Delivery(Integer.valueOf(w2[0]), Double.valueOf(w2[1].substring(0, w2[1].length() - 1)));
                }
            }

        return cost;
    }
}
