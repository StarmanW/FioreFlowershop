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
 * @author User
 */
public class CreditLimitCorporate {

    private static final boolean INITIAL_STOCK_STATUS = true;
    private static Scanner sc = new Scanner(System.in);

    public static ArrayList<Corporate> generateCorporateList() {
        ArrayList<Corporate> corps = new ArrayList<>();

        corps.add(new Corporate("CO0001", "Apple Arts Sdn. Bhd.", "144 Lrg Zamrud 3/1 Taman Pekan Baru 08000 Sungai Petani 08000, Malaysia", "03745625", 1400.00));
        corps.add(new Corporate("CO0002", "Alpinetime Sdn. Bhd.", "288 Lt Avenue, Jalan Petagas, WP, Kuala Lumpur, Malaysia", "03954622", 1800.00));
        corps.add(new Corporate("CO0003", "Robin Corporation", "350, Jalan Tun Fuad, 82000, WP, Kuala Lumpur, Malaysia", "034557895", 1200.00));
        corps.add(new Corporate("CO0004", "Moonlit Ltd.", "6812 Murphy Dale, Jalan Penampang, 82000, Wangsa Maju, WP, Kuala Lumpur, Malaysia", "03455688", 1500.00));
        corps.add(new Corporate("CO0005", "Pixycloud Ltd.", "Lt 280, Jalan Luyang, 25000, WP, Kuala Lumpur, Malaysia", "03467855", 2000.00));

        return corps;
    }

    //check for Corporate customer credit limit
    public static String showCerditLimit(ArrayList<Corporate> corps) {

        //arraylist
        ArrayList<ProductType> productTypeList = Utility.generateProductTypeList();
        ItemList<Flower> flowerList = Utility.generateFlowerList();
        ArrayList<CatalogOrder> catalogue = Utility.generateCatalogue();

        //inztiale
        ProductType productType = null;
        Flower flowerType = null;
        int Qty = 0;
        String catalogOrderID = " ";

        String corporateId = " ";
        int totalEntries = corps.getTotalEntries();

        String selection = " ";
        boolean choice = false;
        boolean custFound = false;
        boolean productInStock = INITIAL_STOCK_STATUS;

        while (true) {
            do {
                System.out.print("\n===== CORPORATE CUSTOMER ====\n\n");
                System.out.print("\nEnter ID : ");
                corporateId = sc.nextLine();

                for (int i = 0; i < corps.getTotalEntries(); i++) {

                    if (corporateId.equals(corps.get(i).getCorporateId())) {
                        Corporate creditlimit = (Corporate) corps.get(i);
                        System.out.println(String.format("\n %d. %s", i, creditlimit.getCorporateName()
                                + "\nTOTAL CREDIT LIMIT : " + creditlimit.getCreditLimit()));
                        custFound = true;
                    }
                }

                if (!custFound) {
                    System.out.println("No customer found.");
                }
            } while (!custFound);

            //ask if wether user want to add order or no
            do {
                System.out.print("\nDo you wish to add Order? (y/n): ");
                selection = sc.nextLine().toLowerCase();

                if (selection.matches("^[y/n]$")) {

                    if (selection.equals("y")) {
                        choice = true;
                    } else {
                        System.out.println("\n===Thank You for using our system.===\nSystem shut"
                                + "ting down now...\n");
                        System.exit(0);
                    }
                }
                break;
            } while (!choice);
            {
                productType = Utility.enterProductType(productTypeList);
                flowerType = Utility.enterFlowerType(flowerList);
                Qty = Utility.enterttlQty();

                catalogOrderID = Utility.generateCatalogOrderID(catalogue.getTotalEntries());

                catalogue.add(new CatalogOrder(catalogOrderID, productType, flowerType, Qty, productInStock));

                System.out.print("\n=====YOUR ORDER HAVE BEEN ADDED TO CART====\n");
                for (int a = 0; a < catalogue.getTotalEntries(); a++) {
                    CatalogOrder co = catalogue.get(a);
                    System.out.println(
                            co.getCatalogOrderID() + "\t"
                            + "\t" + co.getProductType().getProductTypeName()
                            + "\t" + co.getFlowerType().getFlowerName()
                            + "\t" + co.getQty()
                            + "\t" + co.isInStock() + "\n\n");

                }
                break;
            }
        }
        return corporateId;
    }

}
