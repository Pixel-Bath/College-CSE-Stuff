// Kevin Koepp
// CSE 174, Lab 2: Calculating Coffee Costs

// This class will print the total number of coffee bought for each size
// over three months. This class will also print the average cost for each
// size of coffee based on these three months.
public class CoffeeCosts {
  public static void main(String[] args) {
    
    // Constant coffee prices:
    final float SM_PRICE = 2.95f;
    final float MD_PRICE = 3.65f;
    final float LG_PRICE = 4.15f;
    
    // Values of coffee bought for each Month and Size:
    int febSm = 60;
    int febMd = 43;
    int febLg = 28;
    
    int marSm = 68;
    int marMd = 48;
    int marLg = 31;
    
    int aprSm = 63;
    int aprMd = 46;
    int aprLg = 30;
    
    // Total number of coffees for each size:
    int totalSmall = febSm + marSm + aprSm;
    int totalMedium = febMd + marMd + aprMd;
    int totalLarge = febLg + marLg + aprLg;
    
    // Calculating average price for each size:
    float averagePriceSmall = SM_PRICE * totalSmall / 3;
    float averagePriceMedium = MD_PRICE * totalMedium / 3;
    float averagePriceLarge = LG_PRICE * totalLarge / 3;
    
    System.out.println("Number of small coffees bought: " + totalSmall);
    System.out.println("Average price of buying small: $" + averagePriceSmall);
    
    System.out.println("Number of medium coffees bought: " + totalMedium);
    System.out.println("Average price of buying medium: $"
        + averagePriceMedium);
    
    System.out.println("Number of large coffees bought: " + totalLarge);
    System.out.println("Average price of buying large: $" + averagePriceLarge);
  }
} // end class
  