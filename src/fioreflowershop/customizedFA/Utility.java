package fioreflowershop.customizedFA;

import fioreflowershop.Models.FlowerArrangementStyle;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author StarmanW
 */
public class Utility {

    private static Scanner sc = new Scanner(System.in);

    public static ArrayList<FlowerArrangementStyle> generateFlowerArrangementStyles() {
        ArrayList<FlowerArrangementStyle> fas = new ArrayList<>();
                                    
        fas.add(new FlowerArrangementStyle("FAS001", "Elliptical flower arrangement", 10.00));
        fas.add(new FlowerArrangementStyle("FAS002", "Triangular flowers", 8.00));
        fas.add(new FlowerArrangementStyle("FAS003", "The 'S' shaped flower arrangement", 7.00));
        fas.add(new FlowerArrangementStyle("FAS004", "The oval shaped flower arrangement", 10.00));
        fas.add(new FlowerArrangementStyle("FAS005", "The cascade flower arrangement", 12.00));
        fas.add(new FlowerArrangementStyle("FAS006", "Floral Bouquets", 5.00));
        fas.add(new FlowerArrangementStyle("FAS007", "Floral Wreaths", 15.00));
        fas.add(new FlowerArrangementStyle("FAS008", "Floral Baskets", 12.00));
        
        return fas;
    }

    public static int mainMenu() {
        String choice = "";
        while (true) {
            System.out.print("===== Customized Floral Arrangement ====\n"
                    + "1. Select Flower Arrangement Style\n"
                    + "2. Select Flower Arrangement Size\n"
                    + "3. Select Flowers\n"
                    + "4. Select Accessories\n"
                    + "5. Back\n"
                    + "Enter your choice: ");
            choice = sc.nextLine();
            if (choice.matches("^[1-5]$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with only choice 1-5.\n");
        }
        return Integer.parseInt(choice);
    }

    public static int displayFlowerArrangementStyle(ArrayList<FlowerArrangementStyle> fas) {
        String choice = "", output = "\n===== Select Flower Arrangement Style ====\n";
        int i = 0;
        
        for (i = 0; i < fas.size(); i++) {
            output += String.format("%d. %s - RM%.2f\n", i+1, fas.get(i).getFlowerArrangementStyleName(), fas.get(i).getPrice());
        }

        output += String.format("%d. Back\nEnter your choice: ", i+1);
        
        while (true) {
            System.out.print(output);
            choice = sc.nextLine();
            if (choice.matches("^[1-" + (fas.size() + 1) + "]$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with only choice 1-9.\n");
        }
        return Integer.parseInt(choice);
    }
}
