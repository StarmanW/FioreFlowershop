package mainpackage;

import adt.LList;
import adt.ListInterface;
import model.Accessory;
import model.Consumer;
import model.Corporate;
import model.Flower;
import model.Invoice;
import model.Order;
import model.Product;
import model.ProductOrder;
import model.ProductType;
import model.PromotionCatalogue;
import catalogueorder.Utility;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Wong Kim Foong
 */
public class SampleData {

    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    // Create and initialize catalogue(list of products) with dummy values
    public static ListInterface<Product> generateCatalogue(ListInterface<Flower> flowerList, ListInterface<ProductType> productTypeList, ListInterface<Accessory> accessoryList) {
        ListInterface<Product> catalogue = new LList<>();
        catalogue.add(new Product("PD001", "Fresh Rose", 7.0, 10, productTypeList.get(2), flowerList.get(3), null, "Fresh red rose sourced locally.", true, false));
        catalogue.add(new Product("PD002", "Wax Flower Bouquet", 234.0, 5, productTypeList.get(1), flowerList.get(4), accessoryList.get(1), "A bouquet of fresh wax flowers.", true, false));
        catalogue.add(new Product("PD003", "Rose Bouquet", 20.0, 5, productTypeList.get(1), flowerList.get(3), accessoryList.get(1), "A bouquet of fresh rose.", true, false));
        return catalogue;
    }

    // Create and initialize flower list with dummy values
    public static ListInterface<Flower> generateFlowerList() {
        ListInterface<Flower> flowerList = new LList<>();
        flowerList.add(new Flower("FL001", "Rose", 100, 7.0));
        flowerList.add(new Flower("FL002", "Baby's Breath", 0, 7.8));
        flowerList.add(new Flower("FL003", "Wax Flower", 50, 7.8));
        flowerList.add(new Flower("FL004", "Lily Asiatic", 67, 7.2));
        flowerList.add(new Flower("FL005", "Dahlia", 20, 21.0));
        return flowerList;
    }

    public static PromotionCatalogue generatePromoCatalogue(ListInterface<Product> catalogue) {
        PromotionCatalogue promoCatalogue = new PromotionCatalogue();
        promoCatalogue.setPromotionName("Winter Sales");
        promoCatalogue.setPromotionMonth(Month.DECEMBER);
        promoCatalogue.setPromotionDiscount(50);
        promoCatalogue.addPromoProduct(catalogue.get(1));
        catalogue.get(1).setInPromotion(true);
        promoCatalogue.addPromoProduct(catalogue.get(2));
        catalogue.get(2).setInPromotion(true);
        promoCatalogue.setIsInitialized(true);
        return promoCatalogue;
    }

    //create and initialize accessory list with dummy values
    public static ListInterface<Accessory> generateAccessoryList() {
        ListInterface<Accessory> accessoryList = new LList<>();
        accessoryList.add(new Accessory("Decorative Red Gems", 8.0));
        accessoryList.add(new Accessory("Red Stones", 5.0));
        accessoryList.add(new Accessory("Wrapping Paper", 5.0));
        return accessoryList;
    }

    //create and initialize product type list with dummy values
    public static ListInterface<ProductType> generateProductTypeList() {
        ListInterface<ProductType> productTypeList = new LList<>();
        productTypeList.add(new ProductType("PT001", "Fresh Flower", false));
        productTypeList.add(new ProductType("PT002", "Flower Bouquet", true));
        productTypeList.add(new ProductType("PT003", "Flower Arrangement", true));
        return productTypeList;
    }

    public static ListInterface<Order> generateOrder(ListInterface<Product> productList, ListInterface<Corporate> corporateList) {
        // Create product order list for corporate 1
        ListInterface<ProductOrder> productOrderList = new LList<>();
        ListInterface<ProductOrder> productOrderList1 = new LList<>();

        // Create product order list for corporate 2
        ListInterface<ProductOrder> productOrderList2 = new LList<>();
        ListInterface<ProductOrder> productOrderList3 = new LList<>();

        // Create new order list
        ListInterface<Order> orderList = new LList<>();

        // Product Order List for first order of corporate 1
        productOrderList.add(new ProductOrder(productList.get(0), 1));
        productOrderList.add(new ProductOrder(productList.get(1), 2));

        // Product Order List for second order of corporate 1
        productOrderList1.add(new ProductOrder(productList.get(0), 3));
        productOrderList1.add(new ProductOrder(productList.get(1), 2));

        // Product Order List for first order of corporate 2
        productOrderList2.add(new ProductOrder(productList.get(0), 4));
        productOrderList2.add(new ProductOrder(productList.get(1), 5));

        // Product Order List for second order of corporate 2
        productOrderList3.add(new ProductOrder(productList.get(0), 5));
        productOrderList3.add(new ProductOrder(productList.get(1), 10));

        try {
            // Order List for corporate 1
            orderList.add(new Order("OD0001", corporateList.get(0), productOrderList, SIMPLE_DATE_FORMAT.parse("11-12-2018"), SIMPLE_DATE_FORMAT.parse("20-12-2018"), corporateList.get(0).getAddress(), 475.00));
            orderList.add(new Order("OD0002", corporateList.get(0), productOrderList1, SIMPLE_DATE_FORMAT.parse("15-12-2018"), SIMPLE_DATE_FORMAT.parse("20-12-2018"), corporateList.get(0).getAddress(), 489.00));

            // Order List for corporate 2
            orderList.add(new Order("OD0003", corporateList.get(2), productOrderList2, SIMPLE_DATE_FORMAT.parse("04-11-2018"), SIMPLE_DATE_FORMAT.parse("10-12-2018"), corporateList.get(2).getAddress(), 1198.00));
            orderList.add(new Order("OD0004", corporateList.get(2), productOrderList3, SIMPLE_DATE_FORMAT.parse("08-11-2018"), SIMPLE_DATE_FORMAT.parse("15-12-2018"), corporateList.get(2).getAddress(), 2375.00));
        } catch (ParseException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orderList;
    }

    // Method to get hardcoded Corporates
    public static ListInterface<Corporate> generateCorporateList() {
        ListInterface<Corporate> corporateList = new LList<>();
        corporateList.add(new Corporate("CO0001", "Apple Arts Sdn. Bhd.", "144 Lrg Zamrud 3/1 Taman Pekan Baru 08000 Sungai Petani 08000, Malaysia", "03745625", 12500.0, 1200.0));
        corporateList.add(new Corporate("CO0002", "Alpinetime Sdn. Bhd.", "288 Lt Avenue, Jalan Petagas, WP, Kuala Lumpur, Malaysia", "03954622", 6500.0, 2000.0));
        corporateList.add(new Corporate("CO0003", "Robin Corporation", "350, Jalan Tun Fuad, 82000, WP, Kuala Lumpur, Malaysia", "03455895", 7000.0, 400.0));
        corporateList.add(new Corporate("CO0004", "Moonlit Ltd.", "6812 Murphy Dale, Jalan Penampang, 82000, Wangsa Maju, WP, Kuala Lumpur, Malaysia", "03455688", 15000.0, 200.0));
        corporateList.add(new Corporate("CO0005", "Pixycloud Ltd.", "Lt 280, Jalan Luyang, 25000, WP, Kuala Lumpur, Malaysia", "03467855", 8500.0, 1400.0));
        return corporateList;
    }

    // Method to get hardcoded Consumers
    public static ListInterface<Consumer> generateConsumerList() {
        ListInterface<Consumer> consumerList = new LList<>();
        consumerList.add(new Consumer("CN0001", "John Starling", "658874123356", "1590 W San Marcos Blvd #UNT 145, San Marcos, CA, 92078", "0214446598"));
        consumerList.add(new Consumer("CN0002", "Derek Bernas", "985546213598", "Cardinal, Climax Springs, MO, 65324", "0153226854"));
        consumerList.add(new Consumer("CN0003", "Kim Mary", "789952123364", "19 Sheppard Ln, Lee, NH, 03861", "01123265649"));
        consumerList.add(new Consumer("CN0004", "Hank Anderson", "895512302548", "809 W 2nd Ave, Flandreau, SD, 57028", "0015589796"));
        consumerList.add(new Consumer("CN0005", "Michelle Jane", "924456215597", "50 Watertown St, Watertown, MA, 02472", "0125568753"));
        return consumerList;
    }

    // Method to get hardcoded Invoice
    public static ListInterface<Invoice> generateInvoiceList(ListInterface<Order> orderList) {
        ListInterface<Invoice> invoiceList = new LList<>();

        ListInterface<Order> corporateOrderList1 = new LList<>();
        corporateOrderList1.add(orderList.get(0));
        corporateOrderList1.add(orderList.get(1));

        ListInterface<Order> corporateOrderList2 = new LList<>();
        corporateOrderList2.add(orderList.get(2));
        corporateOrderList2.add(orderList.get(3));

        try {
            invoiceList.add(new Invoice("INV0001", orderList.get(0).getCustomer(), SIMPLE_DATE_FORMAT.parse("30-11-2018"), SIMPLE_DATE_FORMAT.parse("7-12-2018"), corporateOrderList1, 0));
            invoiceList.add(new Invoice("INV0002", orderList.get(2).getCustomer(), SIMPLE_DATE_FORMAT.parse("30-12-2018"), SIMPLE_DATE_FORMAT.parse("7-01-2019"), corporateOrderList2, 0));
        } catch (ParseException ex) {
            System.err.println("Unable to parse date.");
        }

        return invoiceList;
    }
}
