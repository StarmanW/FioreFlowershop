/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.orderList;


import fioreflowershop.ADT.ListInterface;
import fioreflowershop.Models.Consumer;
import fioreflowershop.Models.Corporate;
import fioreflowershop.Models.OrderList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cheng foong kian
 */
public class Utility {

    private static Scanner sc = new Scanner(System.in);
   public static char choices = 'n';
    // Method to get hardcoded Consumers
    public static ListInterface<OrderList> generateConsumerList() {
        ListInterface<OrderList> consumers = new LList<>();

        consumers.add(new OrderList("OL0001", "John Starling", "965332565225", "12/12/2018", "4:00pm","0214446598"));
        consumers.add(new OrderList("OL0002", "Jack", "652336541202", "12/12/2018", "6:30pm","0153226854"));
        consumers.add(new OrderList("OL0003", "Mary Key", "896554721552", "17/12/2018","5:00pm", "01123265649"));
        consumers.add(new OrderList("OL0004", "Andrew Tan", "032554025663", "19/12/2018","6:40pm", "0015589796"));
        consumers.add(new OrderList("OL0005", "Michelle Low", "924456215597", "22/12/2018","2:00pm", "0125568753"));

        return consumers;
        
   
    }
     
      
     
    // Method to display module's main menu
    public static int mainMenu() {
        String choice = "";
   
        while (true) {
            
            System.out.print("==== Customer Order List ====\n" 
                    + "1. Show customer Order list\n"
                    + "2. Back\n"
                    + "3. Delivery List\n"
                    + "Enter your choice: ");
            choice = sc.nextLine();
            if (choice.matches("^[1-3]$")) {
                break;
            }
            System.out.println("Invalid choice entered, please try again with only choice 1-2.\n");
        }
        return Integer.parseInt(choice);
    }

    // Method to show customer list
    public static int showCustomerList(ListInterface<OrderList> cons) {
        do
        {
        
String indate = Date();
             
boolean check = false;
            System.out.println("\n========== Delivery List ==========" );
            for(int g=0; g<cons.size();g++)
            {
                if(indate.matches(cons.get(g).getDate()))
                {
                    System.out.println("\nDelivery No: " + cons.get(g).getConsumerId()
                            + "\nRequired Delivery Date: " + cons.get(g).getDate() 
                            + "\nRequired Delivery Time: " + cons.get(g).getPickuptime());
                            
                 
                    check = true;
                }

            }
                 if(check == false)
            {
                System.out.println("\nSorry, Today do not have any order need to delivery.\n"); 
            }
            
            System.out.print("Do you want to search again? (yes/no): "); 
            choices = sc.next().charAt(0);
            
        }while(choices == 'y'|| choices == 'Y');
        
        

     
        
        
    
String choice = "";
 int i = 0;
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("No. %-12s \t %-30s \t %-12s \t %-12s  \t %-12s \t %-40s", "Consumer ID", "Consumer Name", "Contact Number", "IC Number", "Pick Up Date","Pick UP Time"));
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (i = 0; i < cons.size(); i++) {
                System.out.println(String.format("%d. %-15s \t %-30s \t %-15s \t %-12s  \t %-12s \t %-40s", i + 1, cons.get(i).getConsumerId(), cons.get(i).getConsumerName(), cons.get(i).getContactNo(), cons.get(i).getIcNum(), cons.get(i).getDate(), cons.get(i).getPickuptime()));
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

            System.out.println(String.format("Total %d order List(s).", i));
            
        while (true) {
            System.out.print("1. Back\n"
                    + "Enter your choice: ");
            choice = sc.nextLine();

            if (choice.matches("^[1]$")) {
                break;
            }

            System.out.println("Invalid choice entered, please try again with only choice 1.\n");
        }

      
        return Integer.parseInt(choice);
    }
     public static boolean ValidDate(int day,int month,int year){
		boolean valid = false;
		if(year > 2000 && year <=2100){
			switch(month){
			case 1:case 3:case 5:case 7:case 8: case 10: case 12:
					 if(day > 0 && day <=31){
						valid = true;
						break;
					 }
			case 2: if(year%4==0){
						if(day > 0 && day <=29)
							valid = true;
					}
					else {
						if(day > 0 && day <=28)
							valid = true;
					}
					break;
			case 4:case 6:case 9:case 11:
					if(day > 0 && day <=30){
						valid = true;
						break;
					}
			}
		}
		return valid;
	}
    
    public static boolean checkDigit(String input){
            boolean checkDigit = false;
            for(int r=0;r<input.length();r++){
                if(Character.isDigit(input.charAt(r))){
                checkDigit = true;
                }
                else{
                    checkDigit = false;
                    break;
                }
            }
            return checkDigit;
	}

	public static String Date(){
	    
		boolean validDate = false;
		int day = 0;
		int month = 0;
		int year = 0;
		String d="";
		String m="";
		String y="";
		do{
			boolean checkD = false;
			boolean checkM = false;
			boolean checkY = false;
			do{
				System.out.print("Enter Date(DD MM YYYY): ");
				d = sc.next();
				m = sc.next();
				y = sc.next();

				//Validation of day(Only can be digit)
				checkD = checkDigit(d);

				if(checkD == true){
					//Validation of month(Only can be digit)
					checkM = checkDigit(m);
				}

			    if(checkM == true){
			    	//Validation of year(Only can be digit)
					checkY = checkDigit(y);
				}

				if(!checkY){
					System.out.println("\nInvalid Date! Please enter again\n");
				}
			}while(!checkY);

			day = Integer.parseInt(d);
			month = Integer.parseInt(m);
			year = Integer.parseInt(y);
			validDate = ValidDate(day,month,year);

			if(!validDate){
				System.out.println("\nInvalid Date! Please enter again");
			}
		}while(!validDate);

		String date = day + "/" + month + "/" + year;
		return date;
}
   
    
}

