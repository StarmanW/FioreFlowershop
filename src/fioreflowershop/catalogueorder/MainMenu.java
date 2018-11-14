package fioreflowershop.catalogueorder;

import Model.CatalogueOrder;
import java.util.Scanner;
import fioreflowershop.Models.ArrayList;

/**
 *
 * @author Thiban
 */
public class MainMenu {

    public static void main(String[] args) {

        ArrayList<CatalogueOrder> co = MainMenu.generateCatalogueOrder();

        while (true) {
            int select = MainMenu.Menu();

            if (select == 1) {
                select = MainMenu.showCatalogueOrder(co);
                if (select != 7) {
                    System.out.println(String.format("\n========YOUR ORDER========\n\nFlower Name : %s \nFlower Price : RM%.2f "
                            + "\nTotal Quantity : %s \nTotal Item Selected : %s\n",
                            co.get(select - 1).getFlowerName(),
                            co.get(select - 1).getFlowerPrice(),
                            co.get(select - 1).getTtlQty(),
                            co.get(select - 1).getTtlItem()));
                }
            }

        }

    }

    //display
    private static Scanner input = new Scanner(System.in);

    public static ArrayList<CatalogueOrder> generateCatalogueOrder() {

        ArrayList<CatalogueOrder> co = new ArrayList<>();

        //Hardcoded Data
        co.add(new CatalogueOrder("ROSE", 2.00, 6, 2));
        co.add(new CatalogueOrder("Daisy family", 2.00, 6, 2));
        co.add(new CatalogueOrder("Orchids", 2.10, 6, 2));
        co.add(new CatalogueOrder("Aster", 2.00, 6, 2));
        co.add(new CatalogueOrder("Iris", 2.00, 6, 2));
        co.add(new CatalogueOrder("Sun Flower", 2.10, 6, 2));

        return co;
    }

    public static int Menu() {

        String select = "";

        while (true) {
            System.out.print("\n===== CATALOG ORDER ====\n\n"
                    + "1. Please Place Your Order Here\n"
                    + "2. Check credit limit for corporate customer \n"
                    + "3. Generate Sales Report \n"
                    + "\n4. Back\n"
                    + "\nEnter your choice : ");

            select = input.nextLine();

            if (select.matches("^[1-4]$")) {
                break;
            }
            System.out.println("\nInvalid selection...Please try again.\n");
        }
        return Integer.parseInt(select);

    }

    public static int showCatalogueOrder(ArrayList<CatalogueOrder> co) {

        String select = "", output = "\n\n\n===== PLACE YOUR ORDER HERE ====\n\n";
        int i = 0;
        String qty;
        String item;

        for (i = 0; i < co.size(); i++) {

            output += String.format("%s  %s    RM%.2f     %s  %s\n", i + 1,
                    co.get(i).getFlowerName(),
                    co.get(i).getFlowerPrice(),
                    co.get(i).getTtlQty(),
                    co.get(i).getTtlItem());
        }

        output += String.format("\n%d. Back\n\n"
                + "Enter your choice of flower : ", i + 1);

        while (true) {
            System.out.print(output);
            select = input.nextLine();

            if (select.matches("^[1-6]$")) {
                System.out.print("\nEnter Quantity : ");
                qty = input.nextLine();

                System.out.print("\nEnter Number Of Items : ");
                item = input.nextLine();

                System.out.print("\n========SUMMARY========" + "\nOuantity : " + qty + "\nNo of item selected : " + item + "\n\n");
            } else {
                System.out.println("\nInvalid selection...Please try again.\n");
            }

        }

    }
}
