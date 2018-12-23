package OrderPickup_ChengFK;

import adt.SortedLinkedList;
import adt.SortedListInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Cheng Foong Kian
 * @param <T>
 */
public class Main {

    public static void mainMethod() {
        SortedListInterface<orderInterface> orderList = new SortedLinkedList<orderInterface>();

        orderList.add(new orderList("31/12/2018 17:08:40", "A003", "13-23 PV13 Block A", "Setapak", "UnPaid", 150.00, "None", "Pending"));
        orderList.add(new orderList("22/12/2018 20:30:21", "A002", "94 Taman Desa, Jalan Desa 32", "Johor", "UnPaid", 250.00, "None", "Pending"));
        orderList.add(new orderList("22/12/2018 11:25:51", "A005", "234 Taman Cannaught", "Cheras", "UnPaid", 300.00, "None", "Pending"));
        orderList.add(new orderList("17/12/2018 08:41:08", "A007", "11 Taman Cannaught", "Cheras", "UnPaid", 100.00, "None", "Pending"));
        orderList.add(new orderList("18/12/2018 07:52:24", "A008", "23 Jalan River", "Terrenganu", "UnPaid", 190.00, "None", "Pending"));

        SortedListInterface<pickupInterface> pickupList = new SortedLinkedList<pickupInterface>();

        pickupList.add(new pickupList("31/12/2018 17:08:40", "B003", "13-23 PV13 Block A", "Setapak", "UnPaid", 250.00, "None", "StandBy"));
        pickupList.add(new pickupList("22/12/2018 20:30:21", "B002", "94 Taman Desa, Jalan Desa 32", "Johor", "UnPaid", 300.00, "None", "StandBy"));
        pickupList.add(new pickupList("29/12/2018 11:25:51", "B047", "234 Taman Cannaught", "Sabah", "UnPaid", 360.00, "None", "StandBy"));
        pickupList.add(new pickupList("30/12/2018 08:41:08", "B015", "11 Taman Cannaught", "Kiching", "UnPaid", 180.00, "None", "StandBy"));
        pickupList.add(new pickupList("28/12/2018 07:52:24", "B010", "23 Jalan River", "Muar", "UnPaid", 10.00, "None", "StandBy"));

        Scanner scan = new Scanner(System.in);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:MM:ss");
        String dateToday = sdf.format(date);
        int feature = 0;
        int orderNum = 0;
        double total = 0;
        int picknume = 0;
        double totals = 0;

        do {
            System.out.println("\n==== Deliveries Module ====");
            System.out.print("1. Delivery List Today\n2. All deliveries\n3. Pickup List\n4. List of Pickup\n5. Back\nPlease choose (number): ");
            feature = scan.nextInt();
            if (feature == 1) {

                System.out.println("\nTodays List of Deliveries:   " + dateToday);
                System.out.printf("%3s  %-6s %-25s %-40s %-15s %-18s %-13s %-25s %-20s\n", "No.", "Order", "Date Created", "Address", "City", "PaymentStatus", "Amount", "Delivery Date/Time", "Status");
                for (int i = 1; i <= orderList.getLength(); i++) {
                    String DeliveryDate = orderList.getEntry(i).getCreatedDate();
                    if (dateToday.substring(0, 10).equalsIgnoreCase(orderList.getEntry(i).getCreatedDate().substring(0, 10))) {
                        System.out.printf("%-4d %-6s %-25s %-40s %-15s %-18s %-13s %-25s %-23s\n", i, orderList.getEntry(i).getOrderNo(), orderList.getEntry(i).getCreatedDate(), orderList.getEntry(i).getAddress(), orderList.getEntry(i).getCity(), orderList.getEntry(i).getPaymentStatus(), orderList.getEntry(i).getTotalAmount(), orderList.getEntry(i).getDeliveryTimestamp(), orderList.getEntry(i).getStatus());
                    }
                }
                System.out.print("Which order has been sent out?(Enter Number):");
                orderNum = scan.nextInt();

                System.out.println("\n-------------------------------------------------------");
                System.out.println("    Current time for customer delivery order");
                System.out.println("-------------------------------------------------------");

                System.out.printf("Total Amount of Product : %-23s\n", orderList.getEntry(orderNum).getTotalAmount());

                do {
                    System.out.print("please insert the current ringgit:");
                    total = scan.nextDouble();
                } while (total < orderList.getEntry(orderNum).getTotalAmount());

                orderList.getEntry(orderNum).updateStatus();
                orderList.getEntry(orderNum).updateTimestamp();
                orderList.getEntry(orderNum).updatePayment();

                System.out.println("\nBalance: RM " + (total - orderList.getEntry(orderNum).getTotalAmount()) + "\n");
                System.out.println(">>>>    This order have been updated !  <<<<");
                orderNum = 0;

            }
            if (feature == 2) {
                System.out.printf("%3s  %-6s %-25s %-40s %-15s %-15s %-11s %-25s %-20s\n", "No.", "Order", "Date Created", "Address", "City", "PaymentStatus", "Amount", "Delivery Date/Time", "Status");
                for (int i = 1; i <= orderList.getLength(); ++i) {
                    System.out.printf("%-4d %-6s %-25s %-40s %-15s %-15s %-12s %-25s  %-20s\n", i, orderList.getEntry(i).getOrderNo(), orderList.getEntry(i).getCreatedDate(), orderList.getEntry(i).getAddress(), orderList.getEntry(i).getCity(), orderList.getEntry(i).getPaymentStatus(), orderList.getEntry(i).getTotalAmount(), orderList.getEntry(i).getDeliveryTimestamp(), orderList.getEntry(i).getStatus());
                }
                System.out.println("Total List of Delivery: " + orderList.getLength());
                orderNum = 0;
            }
            if (feature == 3) {

                System.out.println("\nTodays List of Deliveries:   " + dateToday);
                System.out.printf("%3s  %-6s %-25s %-40s %-15s %-18s %-13s %-25s %-20s\n", "No.", "Order", "Date Created", "Address", "City", "PaymentStatus", "Amount", "Delivery Date/Time", "Status");
                for (int i = 1; i <= pickupList.getLength(); i++) {
                    String DeliveryDate = pickupList.getEntry(i).getCreatedDate();
                    if (dateToday.substring(0, 10).equalsIgnoreCase(orderList.getEntry(i).getCreatedDate().substring(0, 10))) {
                        System.out.printf("%-4d %-6s %-25s %-40s %-15s %-18s %-13s %-25s %-23s\n", i, pickupList.getEntry(i).getOrderNo(), pickupList.getEntry(i).getCreatedDate(), pickupList.getEntry(i).getAddress(), pickupList.getEntry(i).getCity(), pickupList.getEntry(i).getPaymentStatus(), pickupList.getEntry(i).getTotalAmount(), pickupList.getEntry(i).getDeliveryTimestamp(), pickupList.getEntry(i).getStatus());
                    }
                }
                System.out.print("Which order wantt to pick up?(Number):");
                picknume = scan.nextInt();

                System.out.println("\n-------------------------------------------------------");
                System.out.println("    Current time for customer pick up order");
                System.out.println("-------------------------------------------------------");
                System.out.printf("Total Amount of Product : %-23s\n", pickupList.getEntry(picknume).getTotalAmount());
                do {
                    System.out.print("please insert the current Ringgit:");
                    totals = scan.nextDouble();

                } while (totals < pickupList.getEntry(picknume).getTotalAmount());
                System.out.println("\nBalance: RM " + (totals - pickupList.getEntry(picknume).getTotalAmount()) + "\n");
                System.out.println("Customer pick up date and Time: " + dateToday + "\n");
                System.out.println(">>>>    This order have been updated !  <<<<");

                pickupList.getEntry(picknume).updateStatus();
                pickupList.getEntry(picknume).updateTimestamp();
                pickupList.getEntry(picknume).updatePayment();

                picknume = 0;

            }
            if (feature == 4) {
                System.out.printf("\n%3s  %-6s %-25s %-40s %-15s %-15s %-11s %-25s %-20s\n", "No.", "Order", "Date Created", "Address", "City", "PaymentStatus", "Amount", "Delivery Date/Time", "Status");
                for (int i = 1; i <= pickupList.getLength(); ++i) {
                    System.out.printf("%-4d %-6s %-25s %-40s %-15s %-15s %-12s %-25s  %-20s\n", i, pickupList.getEntry(i).getOrderNo(), pickupList.getEntry(i).getCreatedDate(), pickupList.getEntry(i).getAddress(), pickupList.getEntry(i).getCity(), pickupList.getEntry(i).getPaymentStatus(), pickupList.getEntry(i).getTotalAmount(), pickupList.getEntry(i).getDeliveryTimestamp(), pickupList.getEntry(i).getStatus());
                }
                System.out.println("Total List of Pick : " + pickupList.getLength());
                picknume = 0;
            } else if (feature == 5) {
                System.out.print("\n");
                break;
            }
        } while (orderNum == 0);

    }
}
