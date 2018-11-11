package fioreflowershop.customizedFA;

import fioreflowershop.Models.FlowerArrangementStyle;
import java.util.ArrayList;

/**
 * @author Samuel Wong Kim Foong
 */
public class CustomizedFloralArrangementTestMain {

    public static void main(String[] args) {
        ArrayList<FlowerArrangementStyle> fas = Utility.generateFlowerArrangementStyles();

        while (true) {
            // Start main menu
            int choice = Utility.mainMenu();
            if (choice == 1) {
                choice = Utility.displayFlowerArrangementStyle(fas);
                if (choice != 9) {
                    // Insert into list
                    System.out.println(String.format("Selected Arrangement Style:\n%s - %s - RM%.2f\n", fas.get(choice - 1).getFlowerArrangementStyleID(), fas.get(choice - 1).getFlowerArrangementStyleName(), fas.get(choice - 1).getPrice()));
                }
            }
        }
    }
}
