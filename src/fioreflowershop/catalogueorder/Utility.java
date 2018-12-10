package fioreflowershop.catalogueorder;

import fioreflowershop.Models.Flower;

import fioreflowershop.Models.ProductType;
import fioreflowershop.Models.Catalogue;
import fioreflowershop.Models.CatalogOrder;

import fioreflowershop.Models.ArrayList;
import fioreflowershop.Models.Corporate;
import fioreflowershop.Models.ItemList;
import java.util.Scanner;

/**
 *
 * @author Thiban
 */
public class Utility {

    private static Scanner sc = new Scanner(System.in);

    public static ItemList<Flower> generateFlowerList() {
        ItemList<Flower> flowerList = new ItemList<>();

        flowerList.add(new Flower("FL001", "Rose", 100, 7.0));
        flowerList.add(new Flower("FL002", "Baby's Breath", 0, 7.8));
        flowerList.add(new Flower("FL003", "Wax Flower", 50, 7.8));
        flowerList.add(new Flower("FL004", "Lily Asiatic", 67, 7.2));
        flowerList.add(new Flower("FL005", "Dahlia", 20, 21.0));

        return flowerList;
    }

    public static ArrayList<ProductType> generateProductTypeList() {
        ArrayList<ProductType> productTypeList = new ArrayList<>();

        productTypeList.add(new ProductType("Fresh Flower"));
        productTypeList.add(new ProductType("Flower Bouquet"));

        return productTypeList;
    }

    public static ArrayList<CatalogOrder> generateCatalogue() {
        ArrayList<CatalogOrder> catalogue = new ArrayList<>();

        catalogue.add(new CatalogOrder("Co-001",
                new ProductType("Fresh Flower"),
                new Flower("FL001", "Rose", 100, 7.0), 20, true));

        return catalogue;
    }

    public static int Menu() {

        String select = " ";

        while (true) {
            System.out.print("\n===== CATALOG ORDER ====\n\n"
                    + "1. Please Place Your Order Here\n"
                    + "2. Check credit limit for corporate customer \n"
                    + "3. Generate Sales Report \n"
                    + "\n4. Back\n"
                    + "\nEnter your choice : ");

            select = sc.nextLine();

            if (select.matches("^[1-4]$")) {
                break;
            }
            System.out.println("\nInvalid selection...Please try again.\n");
        }
        return Integer.parseInt(select);
    }

    public static ProductType enterProductType(ArrayList<ProductType> producTypeList) {
        ProductType selectedProductType = null;
        String selection = "";
        int selectionNumber = 0;
        int totalEntries = producTypeList.getTotalEntries();

        while (true) {
            System.out.println("\n\n=== Product Type ===\n");
            for (int i = 0; i < producTypeList.getTotalEntries(); i++) {
                ProductType tmpProductType = producTypeList.get(i);

                System.out.println(String.format("%d. %s", i + 1, tmpProductType.getProductTypeName()));
            }
            System.out.print("\nChoose your product type : ");
            selection = sc.nextLine();

            selectionNumber = stringToInt(selection);
            if (selectionNumber != -1 && selectionNumber <= totalEntries) {
                selectedProductType = producTypeList.get(selectionNumber - 1);
                break;
            }
            System.out.println("Please enter a valid number. (1 to " + totalEntries + ")\n");

        }
        return selectedProductType;
    }

    public static Flower enterFlowerType(ItemList<Flower> flowerList) {
        Flower selectedFlowerType = null;
        String selection = "";
        int selectionNumber = 0;
        int totalEntries = flowerList.getTotalEntries();

        while (true) {
            System.out.println("\n\n=== Flower List ===\n");
            for (int i = 0; i < flowerList.getTotalEntries(); i++) {
                Flower tmpFlowertype = (Flower) flowerList.get(i);

                System.out.println(String.format("%d. %s", i + 1,
                        tmpFlowertype.getFlowerName()
                        + "\t" + tmpFlowertype.getFlowerQty()
                        + "\t" + tmpFlowertype.getFlowerPrice()));
            }
            System.out.print("\nChoose your Flower : ");
            selection = sc.nextLine();

            selectionNumber = stringToInt(selection);
            if (selectionNumber != -1 && selectionNumber <= totalEntries) {
                selectedFlowerType = (Flower) flowerList.get(selectionNumber - 1);
                break;
            }

            System.out.println("\nPlease enter a valid number. (1 to " + totalEntries + ")\n");
        }

        return selectedFlowerType;
    }

    public static int enterttlQty() {
        String Qty = "";

        while (true) {
            System.out.print("\nEnter Quantity : ");
            Qty = sc.nextLine();

            if (Qty.matches("^([\\d])+$")) {
                break;
            }
            System.out.println("\nPlease enter a valid product quantity. (E.g. - 10)\n");
        }
        return Integer.parseInt(Qty);
    }

    //Ask user wan to add more order or no
    public static String generateCatalogOrderID(int productListEntries) {
        String catalogOrderID = "";

        catalogOrderID = "Co-" + String.format("%03d", productListEntries + 1);

        return catalogOrderID;
    }

    public static int stringToInt(String str) {
        int i = 0;

        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return - 1;
        }
        return i;
    }

}
