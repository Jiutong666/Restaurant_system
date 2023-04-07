package Main;
import java.io.FileNotFoundException;
import java.util.*;

public class MelbourneEats {
    private ArrayList<Restaurant> restaurants = new ArrayList<>();

    private HashMap<String, ArrayList<Restaurant>> menu = new HashMap<>();
    private HashMap<String, ArrayList<Restaurant.Food>> foods = new HashMap<>();

    private ArrayList<Discount> discounts = new ArrayList<>();
    private Delivery deliveryCost = null;


    public  static void main(String[] args) throws FileNotFoundException {
        MelbourneEats me =new MelbourneEats();
        me.method();
        me.run();
    }


    public void run() {
        System.out.println("Welcome to Melbourne Eats");
        boolean a = true;
         while (a) {
                System.out.println("\n------------------------\n" +
                        "1: Browse by category\n" +
                        "2: Search by restaurant\n" +
                        "3: Checkout\n" +
                        "4: Exit\n");
                System.out.print("Choose an option: ");
                Scanner input = new Scanner(System.in);
                int scan = 0;
                try {
                    scan = input.nextInt();
                } catch (Exception e) {

                }
                switch (scan) {
                    case 1:
                        menu();
                        break;
                    case 2:
                        search();
                        break;
                    case 3:
                        checkOut();
                        break;
                    case 4:
                        a = false;
                        break;
                    default:
                        System.out.println("Invalid option!!!");
                }

            }
        }



    public void method() throws FileNotFoundException{
        restaurants = File.readRes();

        for (Restaurant restaurant : restaurants) {
            if (!menu.keySet().contains(restaurant.getType())){
                menu.put(restaurant.getType(), new ArrayList<>());
            }
                menu.get(restaurant.getType()).add(restaurant);
        }
        discounts = File.readDis();
        deliveryCost = File.readCost();
    }



    public void menu() {
        ArrayList<String> b= new ArrayList<>();
        int a = 1;
        for (String s : menu.keySet()) {
            b.add(s);
            System.out.println( a +" "+ s);
            a++;
        }
        System.out.println( a +" " +"Go to main menu");

        System.out.println("Please select:");

        Scanner scanner = new Scanner(System.in);
        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
        }

        if (number> b.size() || number <= 0) {
            return;
        }

        String type = b.get(number - 1);
        System.out.println("Select food from "+ type +" list");

        for (int i = 0; i < menu.get(type).size(); i++) {
            System.out.println( i + 1 +" "+menu.get(type).get(i).getName());
        }

      
        System.out.println( menu.get(type).size()+1  + " " + "Go to main menu");
        System.out.print("Please select:");
        int number2 = 0;
        try {
            number2 = scanner.nextInt();
        } catch (Exception e) {
        }
        if (number2 > menu.get(type).size() || number2 <= 0){
            return;
        }

        String rName = menu.get(type).get(number2-1 ).getName();
        food(rName);
    }



    public void food(String name) {

        boolean fo= true;
        while (fo){
            System.out.println(" ");
            System.out.println("Select a food item from " + name);

            Restaurant select = null;

            for (Restaurant r : restaurants)
                if (r.getName().equals(name)) {
                    select = r;
                }

            if (select == null) {
                return;
            }
            for (int i = 0; i < select.getFoods().size(); i++) {
                System.out.println( i + 1+" "+
                 select.getFoods().get(i).getfName()+ "      $" + select.getFoods().get(i).getfPrice());
            }

            System.out.println(select.getFoods().size() + 1+" "+"No more");
            System.out.print("Please select:");

            Scanner scanner = new Scanner(System.in);
            int id = 0;
            try {
                id = scanner.nextInt();
            } catch (Exception e) {
            }

            if (id> select.getFoods().size() || id <= 0){
                return;
            }

            Restaurant.Food food = select.getFoods().get(id - 1);
            System.out.print("Please enter the amount of  you order：");
            int number= 0;
            try {
                number = scanner.nextInt();
            } catch (Exception e) {
            }

            if (number > 0) {
                if (!foods.keySet().contains(name))
                    foods.put(name, new ArrayList<>());
                    food.setAmount(number);
                    foods.get(name).add(food);
            }
        }
    }


    public void search() {
        System.out.print("Please enter a restaurant name:");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();
        int i = 1;
       ArrayList<String> se = new ArrayList<>();

        for (Restaurant r : restaurants) {
            if (r.getName().toUpperCase().contains(search.toUpperCase())) {
                se.add(r.getName());
                System.out.println( i+" "+ r.getName());
                ++i;
            }
        }
        System.out.println( i+" "+ "Go to main menu");
        System.out.print("Please select:");
        int number=0;
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
        }
        if (number > se.size() || number <= 0){
            return;
        }
        String rName = se.get(number - 1);
        food(rName);

    }


    public void checkOut() {

        System.out.println(" ");
        System.out.println("You have ordered the following items");
        System.out.println("--------------------------------------------------");
        double total = 0;
        double delivery = 0;

        for (String b : foods.keySet()) {
            System.out.println(b);

            for (Restaurant.Food f : foods.get(b)) {
                double tor= (f.getAmount() * f.getfPrice());
                System.out.println( f.getAmount()+ " "+f.getfName()+ "" + "             "+ "$" + tor);
                total += tor;
            }

            for (Restaurant restaurant : restaurants) {
                if (restaurant.getName().equals(b)) {
                    System.out.println( "Delivery fee:"+"              "+"$" + restaurant.getDfee());
                    delivery += restaurant.getDfee();
                }
            }
            System.out.println("--------------------------------------------------");
        }


        double td = 0;
        for (Discount d : discounts) {
            if (d.getPrice1() <= total && total < d.getPrice2()) {
                td = total * (100 - d.getDiscount()) / 100;
            }
        }

        double deliverydiscount =delivery;
        if (foods.keySet().size() >= deliveryCost.getDelAmount()) {
            deliverydiscount= delivery * (100 - deliveryCost.getDelDis()) / 100;
        }

        System.out.println( "Order price:"+"              " +"$" + td);
        System.out.println( "Delivery fee:"+ "             "+"$" +deliverydiscount);
        double totalnodis =total+delivery;
        double totaldis = td+deliverydiscount;

        double s=(totalnodis-totaldis);
        String save = String.format("%.2f", s);

        System.out.println( "You have saved:"+"           "+ "$"+ save);
        System.out.println( "Total amount to pay:"+"      "+ "$" + totaldis);
        foods.clear();
    }
}
