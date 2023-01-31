package travelpackagesignup;

public class TravelPackage {
    //declare private variables
    private double basePrice;
    private double totalPrice;
    private int memPrice, nonMemPrice;
    private String packageInfo;

    public TravelPackage(){//constructor
    }
    
    TravelPackage(String packageInfo, int memPrice, int nonMemPrice){//overloading on constructor
        //use of "this" to eliminate confusion between class attributes and parameters of the same name
        this.packageInfo = packageInfo;
        this.memPrice = memPrice;
        this.nonMemPrice = nonMemPrice;
    }
    
    public void packagePrice(String choice, String membership, int quantity){//method to determine package price
        switch (choice){
            case "A":
                basePrice="Y".equals(membership)?999:1299;
                break;
            case "B":
                basePrice="Y".equals(membership)?1199:1599;
                break; 
            case "C":
                basePrice="Y".equals(membership)?388:499;                
                break; 
            case "D":
                basePrice="Y".equals(membership)?1399:1699;
                break; 
            case "E":
                basePrice="Y".equals(membership)?799:999;
                break; 
            }
        totalPrice= basePrice*quantity;
        }
    
    public void printInfo(int quantity){//method to print price information
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("Quantity\t\t\t: "+quantity);
        System.out.printf("Price per Package\t\t: RM %.2f",basePrice);
        System.out.printf("\nTotal Price\t\t\t: RM %.2f",totalPrice);//price multiply with quantity to get total price
        System.out.printf("\nTotal Amount Payable (+2%% tax)\t: RM %.2f",(totalPrice*1.02));//total price plus 2% travelling tax to get final price
        System.out.println("\n------------------------------------------------------------------");
    }    
    
    @Override
    public String toString(){//toString method to print package information
        return packageInfo + "\t" + memPrice + "\t|\t" + nonMemPrice+"\t|";
    } 
}