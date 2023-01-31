package travelpackagesignup;

import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class TravelPackageSignup {
    static Scanner input= new Scanner(System.in);//create static Scanner for input use
    static TravelPackage travel= new TravelPackage();//create travel class
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//specify date format  
    static Date date = new Date();//create date object
    public static String choice, membership;
    public static int quantity;
    
    public static void main(String[] args) {
        System.out.println(formatter.format(date));//print current date and time  
        //print opening header
        System.out.println("\n-Travel Package Signup System-\n");
        System.out.println("Select the task you wish to perform:\n1. Show package\n2. Subscribe\n3. Exit");
        System.out.print("\nSelection: "); 
        String task;
        //do-while loop to loop selection menu
        do{
        task= input.nextLine();
            switch (task) {
                //user selects task 1 to see package information
                case "1":
                    packageHeader();//call method to display package header
                    showPackage();//call method to display package information
                    choice= input.nextLine().toUpperCase();
                    switch(choice){
                        //when choice input is A, B, C, D or E, exit switch case
                        case "A": case "B": case "C": case "D" : case "E":
                            break;  
                        default:
                            //do-while loop to validate input for choice variable  
                            do{
                            //print error message and allow user to reenter input
                            System.out.println("Package does not exist. Please enter available package choice.");
                            System.out.print("Package: ");
                            choice= input.nextLine().toUpperCase();
                            //exit loop when choice input is A, B, C, D or E
                            }while(!"A".equals(choice)&&!"B".equals(choice)&&!"C".equals(choice)&&!"D".equals(choice)&&!"E".equals(choice));  
                            break;
                    }     
                    System.out.println("Package "+choice+" is chosen.");
                    //prompt for task selection to continue signup process
                    System.out.print("\nInsert number 1,2,3 to continue:\n1. Show package\n2. Subscribe\n3. Exit\n\nSelection: ");
                    break;
                //user selects task 2 to subscribe and get price for selected package    
                case "2":
                    System.out.println("Are you a member? Press Y for YES and N for NO:");
                    System.out.print("Y or N: ");
                    membership= input.nextLine().toUpperCase();
                    switch(membership){
                        //when membership input is Y or N, exit switch case
                        case "Y": case "N":
                            break;
                        default:
                            //do-while loop to validate input for membership variable
                            do{
                            //print error message and allow user to reenter input
                            System.out.println("\nPlease only insert Y or N.");
                            System.out.println("Are you a member? Press Y for YES and N for NO:");
                            System.out.print("Y or N: ");
                            membership= input.nextLine().toUpperCase();
                            }while(!"Y".equals(membership)&&!"N".equals(membership));//exit loop when membership input is Y or N
                            break;
                    }       
                    System.out.println("\nHow many packages do you want?");
                    System.out.print("Quantity: ");
                    //for-loop nested with if-else to ensure user input is an integer that is larger than 0
                    for(;;){
                        if(input.hasNextInt()){//check whether input is an integer
                            String num= input.nextLine();//if input is integer, assign to variable num
                            quantity= Integer.parseInt(num);//transforms num from String to integer data type, assign to quantity variable
                            if (quantity>=1)
                                break;//exit if-else and for loop if quantity larger or equals to 1
                            else{//print error message if quantity less than 1
                                System.out.println("\nPlease only enter a number more than 0 to select number of packages.");
                                System.out.print("Quantity: ");
                            }
                        }else{//print error message and prompt input again if input is not an integer
                            System.out.println("\nPlease only enter a number to select number of packages.");
                            System.out.print("Quantity: ");
                            input.nextLine();
                        }
                    }
                    travel.packagePrice(choice, membership, quantity);//call method to calculate package price
                    travel.printInfo(quantity);//call method to print price information
                    //prompt for task selection to continue signup process
                    System.out.print("\nInsert number 1,2,3 to continue:\n1. Show package\n2. Subscribe\n3. Exit\n\nSelection: ");            
                    break;
                //user selects task 3 to print receipt with package selection and price information
                case "3":
                    printReceipt(choice);//call method to print receipt
                    System.out.println("\nThank you for buying our package(s).\nWe hope you'll enjoy your holiday!");
                    break;   
                default://print error message when input is not 1,2 or 3.
                    System.out.print("\nInvalid input.\n\nPlease insert number 1,2,3 to continue:\n1. Show package\n2. Subscribe\n3. Exit\n\nSelection: ");
                    break;
            }
        }while(!"3".equals(task));//exit do-while loop when input is 3
    }
    
    public static void packageHeader(){//print package header
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.println("|               Package                 |            Price(RM)          |");
        System.out.println("|                                       |-------------------------------|");
        System.out.println("|                                       |     Member    |   Non-Member  |");
        System.out.println("|---------------------------------------|---------------|---------------|");
    } 
    
    public static void showPackage(){//print package information
        //create object packageA that refers to TravelPackage class 
        TravelPackage packageA = new TravelPackage("|Package A \t\t\t\t|\t\t|\t\t|\n|-3D2N Penang Free & Leisure\t\t|\t\t|\t\t|\n"
                + "|-Hotel: Lexis Suites Penang\t\t|\t\t|\t\t|\n|-Food: 3 meals per day \t\t|",999, 1299);
        TravelPackage packageB = new TravelPackage("|Package B \t\t\t\t|\t\t|\t\t|\n|-4D3N Langkawi GoGoGo\t\t\t|\t\t|\t\t|\n"
                + "|-Hotel: The Ritz-Carlton\t\t|\t\t|\t\t|\n|-Food: 3 meals per day\t\t\t|", 1199,1599);
        TravelPackage packageC = new TravelPackage("|Package C \t\t\t\t|\t\t|\t\t|\n|-2D1N Historical Malacca \t\t|\t\t|\t\t|\n"
                + "|-Hotel: Casa del Rio Melaka\t\t|\t\t|\t\t|\n|-Food: 3 meals per day\t\t\t|", 388, 499);
        TravelPackage packageD = new TravelPackage("|Package D \t\t\t\t|\t\t|\t\t|\n|-3D2N Sabah Island Adventure \t\t|\t\t|\t\t|\n"
                + "|-Hotel: Gaya Island Resort \t\t|\t\t|\t\t|\n|-Food: 3 meals per day \t\t|\t\t|\t\t|\n|*include flight ticket\t\t\t| ", 1399, 1699);
        TravelPackage packageE = new TravelPackage("|Package E \t\t\t\t|\t\t|\t\t|\n|-3D2N Explore Redang Island \t\t|\t\t|\t\t|\n"
                + "|-Hotel: Laguna Redang Island \t\t|\t\t|\t\t|\n|-Food: 3 meals per day\t\t\t|", 799, 999);
        System.out.println(packageA);//use toString method to print packageA details
        System.out.println("|---------------------------------------|---------------|---------------|");
        System.out.println(packageB);
        System.out.println("|---------------------------------------|---------------|---------------|");
        System.out.println(packageC);
        System.out.println("|---------------------------------------|---------------|---------------|");
        System.out.println(packageD);
        System.out.println("|---------------------------------------|---------------|---------------|");
        System.out.println(packageE);
        System.out.println("|---------------------------------------|---------------|---------------|");
        System.out.println("**All price is subjected to 2% travelling tax.");
        System.out.println("\nPlease select your desired package.");
        System.out.print("Package: ");
    }    
    
    public static void printReceipt(String choice){//print receipt
        System.out.println("------------------------------------------------------------------");
        System.out.println(formatter.format(date)); 
        System.out.println("Your subscription:\n");
        System.out.println("Package "+choice);
        //print package selection and details according to user's choice input
        switch(choice){
            case "A":
                System.out.println("-3D2N Penang Free & Leisure\n-Hotel: Lexis Suites Penang\n-Food: 3 meals per day");
                break;
            case "B":
                System.out.println("-4D3N Langkawi GoGoGo\n-Hotel: The Ritz-Carlton\n-Food: 3 meals per day");
                break;
            case "C":
                System.out.println("-2D1N Historical Malacca\n-Hotel: Casa del Rio Melaka\n-Food: 3 meals per day");
                break;
            case "D":
                System.out.println("-3D2N Sabah Island Adventure\n-Hotel: Gaya Island Resort\n-Food: 3 meals per day\n- 1 flight ticket");
                break;
            case "E":
                System.out.println("-3D2N Explore Redang Island\n-Hotel: Laguna Redang Island\n-Food: 3 meals per day");
                break;
        }
        travel.printInfo(quantity);//call method to print price information
    }
}