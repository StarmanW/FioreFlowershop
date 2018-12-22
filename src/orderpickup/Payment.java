/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderpickup;

import java.util.ArrayList;
import java.util.Scanner;



/**
 * @author StarmanW
 */
public class Payment {

        private static  Scanner in = new  Scanner(System.in);
         public static ArrayList<FlowerName> generateFlowerArrangementStyles() {
        ArrayList<FlowerName> flower = new ArrayList<>();
                                    
        flower.add(new FlowerName("FAS001", "Alchemilla", 10.00));
        flower.add(new FlowerName("FAS002", "Alyssum. ", 8.00));
        flower.add(new FlowerName("FAS003", "Aquilegia", 7.00));
        flower.add(new FlowerName("FAS004", "Astilbe", 10.00));
        flower.add(new FlowerName("FAS005", "Astrantia", 12.00));
      
        
        return flower;
    }
         
       public static int mainMenu() {
        String choice = "";
        while (true) {
            System.out.print("**Please choose one**\n"
                    + "1. Order Pickup\n"
                    + "2. delivery order   \n"
                    + "3. make Payment\n"
                    + "4. Back\n"
                    + "Enter your choice: ");
            choice = in.nextLine();
            if (choice.matches("^[1-5]$")) {
                break;
            }
            System.out.println("Please enter again 1-4.\n");
        }
        return Integer.parseInt(choice);
    }

    public static int displayFlower(ArrayList<FlowerName> flower) {
        String choice = "", output = "\n Pease review all your order \n";
        int i = 0;
        
        for (i = 0; i < flower.size(); i++) {
            output += String.format("%d. %s = RM%.2f\n", i+1, flower.get(i).getFlowerName(), flower.get(i).getPrice());
        }
          output += String.format("%d. Make Payment\n", i+1);
        output += String.format("%d. Back\nEnter your choice: ", i+2);
        
        while (true) {
            System.out.print(output);
            choice = in.nextLine();
            if (choice.matches("^[1-" + (flower.size() + 1) + "]$") || choice.matches("7") ) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with only choice 1-7.\n");
        }
        return Integer.parseInt(choice);
    }
    
}