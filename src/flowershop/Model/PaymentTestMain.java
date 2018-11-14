/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop.Model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PaymentTestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ArrayList<FlowerName> flower = Payment.generateFlowerArrangementStyles();

        while (true) {
            int choice = Payment.mainMenu();
            if (choice == 3) {
                choice = Payment.displayFlower(flower);
              
                            }
            if (choice == 3) {
                choice = Payment.displayFlower(flower);
            }
        }
    
    }
    
}
