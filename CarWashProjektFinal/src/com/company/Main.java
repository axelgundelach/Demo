package com.company;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/**
 * Main Class
 * Runs with method to keep nice and clean
 * @author Andreas, Axel, Daniel and Viktor
 */

public class Main {

    Scanner scan = new Scanner(System.in);
    Kortinformationer kortinformationer = new Kortinformationer();
    public boolean exit;
    public boolean exit2;
    public String name;
    public double addAmount;
    public double Balance = 0;
    public double economyWash = 50.0;
    public double standardWash = 80.0;
    public double deluxeWash = 119.0;
    final double DISCOUNT = 0.80;
    public String wash1 = "Economy wash";
    public String wash2 = "Standard wash";
    public String wash3 = "Deluxe wash";
    public int ecoCounter = 0;
    public int standCounter = 0;
    public int deluxeCounter = 0;
    public int earlyBirdCounter = 0;

    public static void main(String[] args) {
        Main main = new Main();
        main.runMenu();
    }



//_______________________________________FRONTMENU_______________________________________________________________
    /**
     * Method that runs our user interfaces
     * Uses a loop to keep the program running
     */
    public void runMenu() {
        headerMenu();
        frontMenu();
        while (!exit) {
            int choice = inputNumber();
            performActionFrontMenu(choice);

        }
        mainMenu();
        while (!exit2) {
            int choice = inputNumber();
            performActionMainMenu(choice);
        }
    }

    private void headerMenu() {
        System.out.println("_____________________________________________________________________________________");
        System.out.println("                    |+----------------------------+|");
        System.out.println("                    |         WELCOME TO           |");
        System.out.println("                    |         SVEND BENTS          |");
        System.out.println("                    |          WASH-HALL           |");
        System.out.println("                    |                              |");
        System.out.println("                    |         NEW DISCOUNT         |");
        System.out.println("                    |        Wash before 14:00     |");
        System.out.println("                    |        And get 20% off!      |");
        System.out.println("                    |+----------------------------+|");
        System.out.println("                                   |                ");
        System.out.println("                                   |                ");
        System.out.println("                                   |                ");
    }
    /**
     * Our first menu
     * Print lines
     * Connected with switch to go further in the program
     */
    private void frontMenu() {
        System.out.println("\nFront menu - 9 Stops the program");
        System.out.println("1. Insert card");
        System.out.println("2. Create card");
        System.out.println("_____________________________________________________________________________________");
        System.out.println("\nType menu number:");

    }

    /**
     * Switch case method
     * connected with frontMenu to make a user interface
     * Displays error message if you dont type a number
     * @param choice Type number to make case function
     */
    private void performActionFrontMenu(int choice) {

        scan.nextLine();
        switch (choice) {
            case 0:
                exit = true;
                headerMenu();
                break;
            case 1:
                insertCard();
                break;
            case 2:
                createCard();
                break;
            default:
                System.out.println("Please type a valid number");
        }
    }
//_________________________________________UDREGNINGER TIL FRONTMENU________________________________________________________

    /**
     * Method created with Kortinformationer class
     * Add names and balance into Arraylist
     * Prints name and balance of name you type in
     * Typing 0 takes you back to our main user interface
     */
    public void insertCard() {
        kortinformationer.add("Andreas" , 200);
        kortinformationer.add("Viktor" , 1000);
        kortinformationer.add("Daniel" , 0);
        System.out.println("Choose one of the following accounts: ");
        kortinformationer.printAll();
        System.out.println("\nType the name of the account you want to access: ");
        name = scan.nextLine();
        kortinformationer.searchPerson(name);
        System.out.printf("Welcome back %s, you card balance is: %.2f", name, kortinformationer.searchPerson(name));
        System.out.println("\n Press 0 to enter Main menu");
    }

    /**
     * Method to add user input into the Arraylist
     * Add a name and balance
     * Typing 0 takes you back to main user interface
     * Prints name and the balance you added
     */
    public void createCard() {
        System.out.println("\nType the name of your account:");
        name = scan.nextLine();
        System.out.println("\nWrite the amount of money you wish to deposit on your wash card:");
        if (!scan.hasNextInt()) {
        } else {
            Balance = scan.nextInt();
            kortinformationer.add(name, Balance);
            System.out.printf("\n%s, your card has been created with %.0f dkk", name, Balance);
            System.out.println("\nType 0 to enter menu");
        }
    }


//___________________________________________HOVEDEMENU________________________________________________________

    /**
     * Switch case that works with main user interface
     * Used in conjunction with other methods
     * Pressing 9 will exit the entire program
     * Pressing anything that isn't a case will give error message
     * After error message you can press 0 will take you back to main user interface
     * @param choice Type number to make the case function
     */
    public void performActionMainMenu(int choice) {
        scan.nextLine();
        switch (choice) {
            case 0:
                mainMenu();
                break;
            case 1:
                earlyBird(economyWash, DISCOUNT, wash1);
                break;
            case 2:
                earlyBird(standardWash, DISCOUNT, wash2);
                break;
            case 3:
                chooseWash(deluxeWash, wash3);
                break;
            case 4:
                rechargeCard();
                break;
            case 5:
                showBalance();
                break;
            case 6:
                System.out.println("Statistics for economy wash: " + ecoCounter);
                System.out.println("Statistics for standard wash: " + standCounter);
                System.out.println("Statistics for deluxe wash: " + deluxeCounter);
                System.out.println("Statistics for early bird discount: " + earlyBirdCounter);
                System.out.println("\nPress 0 to return to main menu");
                break;
            case 9:
                exit2 = true;
                System.out.println("THANKS FOR USING SVEND BENTS WASH HALL");
                break;
            default:
                System.out.println("Please type a valid number - press 0 to see options again.");
        }
    }
    /**
     * Main user interface
     * Prints options you can choose from in performActionMainMenu method
     */
    private void mainMenu() {
        System.out.println("\nMain Menu - 0 returns to main menu - 9 Stops the program\n");
        System.out.println("Choose car wash");
        System.out.println("1. Economy - 50kr");
        System.out.println("2. Standard - 80kr");
        System.out.println("3. Deluxe - 120kr");
        System.out.println("\nOther options: ");
        System.out.println("\n4. Recharge card");
        System.out.println("5. Check card Balance");
        System.out.println("_____________________________________________________________________________________");
        System.out.print("\nType a menu number to select option: ");

    }

    /**
     * Method that will check if a number is being typed
     * If a number is not typed in an error message will occur
     * @return returns the NUMBER that is typed
     */
    public int inputNumber() {
        int number = -1;
        if (!scan.hasNextInt()) {
            System.out.println("\nYou have to type a number! Press a number from the menu, to restart");
        }
        else {
            number = scan.nextInt();
        }
        return number;
    }

//____________________________________________UDREGNINGER TIL HOVEDEMENU_____________________________________________________________________

    /**
     * Use Kortinformationer and Person classes
     * Will check if enough balance is on chosen account
     * Tells user what their new balance is after purchase
     * Ask the user if they want a receipt with Receipt method
     * Use statistic method to count what was was chosen
     * @param washType double that substract money from balance dependent on chosen wash
     * @param washName String that contains name of the wash chosen
     */
    public void chooseWash(double washType, String washName) {
        if (kortinformationer.searchPerson(name) <= washType) {
            System.out.println("Not enough money man");
            System.out.println("\nPlease choose another wash: press 0 to return");
        } else {
            System.out.println("You have chosen: " + washName);
            System.out.printf("\n%.0f will be withdrawn from your balance", washType);
            System.out.printf("\nYour new balance is: %.0f\n", kortinformationer.balanceCalculator(name, washType));
            System.out.println("\nDo you want a receipt?\nWrite 1 for yes and and 2 for no\n");
            statistic(washType);
            Receipt(washType,date(),name,washName);
        }
    }

    /**
     * Method that takes 20% of the price of Economy and Standard wash
     * Only works if its a weekday (Monday-Friday)
     * Works between time period (00.00 - 14.00)
     * @param washPrice double that contains price tag of chosen wash
     * @param DISCOUNT double that contain 0.8 used to calculate early bird bonus
     * @param washName String with name of the wash chosen
     */
    public void earlyBird(double washPrice, double DISCOUNT, String washName) {
        if (deadlinetime() && deadlinedate()) {
            double Discountwash = washPrice * DISCOUNT;
            chooseWash(Discountwash, washName);
            earlyBirdCounter ++;
            statistic(washPrice);
        } else {
            chooseWash(washPrice, washName);
        }
    }

    /**
     * Method that allows the user to change the arraylists element values "Balance" to their given account
     * Works with created or already existing accounts
     * Uses Kortinformation class
     */
    public void rechargeCard() {
        System.out.println("Write the amount of money you wish to deposit on your Wash card:");
        addAmount = scan.nextInt();
        System.out.printf("\nYou have refilled your card with %.0f, your total balance is : %.0f" +
                "", addAmount, kortinformationer.changebalance(name, addAmount));
        System.out.println("\nPress 0 to return to main menu");
    }

    /**
     * Method that prints out users current balance
     * Can be used after a rechargeCard use to show amount after recharge
     * Typing 0 takes you back to main user interface
     */
    public void showBalance() {
        System.out.printf("\nYour card balance is: %.0f\n", kortinformationer.searchPerson(name));
        System.out.println("Press 0 to return to main menu");
    }

    /**
     * Method that gives you option of getting a receipt
     * Pressing 1 will print receipt
     * Pressing anything else will give you an option to return to main user interface
     * @param price String that contains price of purchased wash
     * @param date String that contains date
     * @param accountName String that contains name of customer
     * @param washType String that contains name of chosen wash
     */
    public void Receipt(double price, String date, String accountName, String washType) {
        if (inputNumber() == 1) {
            System.out.println("WASH RECEIPT: ");
            System.out.printf("\n%s you have purchased:\n %s  %.0f dkk", accountName, washType, price);
            System.out.println("\n" + date);
            if(price == deluxeWash){
            } else if (deadlinedate() && deadlinetime() && price == economyWash && price == standardWash)  {
                System.out.println("\nYou made it! Early bird discount has been cut from the price");
                System.out.println("You saved 20%");
            }
        } else {
            System.out.println("No reciept for you my dude");
        }
        System.out.println("\nThanks for washing your car at Svend-Bents wash hall");
        System.out.println("Press 0 to return to main menu");
    }

    /**
     * Method that will track which wash is chosen
     * Chosen wash will go up by 1
     * Used to show exactly how many times given wash was chosen
     * @param washType Can contain a number
     */
    public void statistic(double washType) {
         if (washType == economyWash)
            ecoCounter ++;
         else if (washType == standardWash)
            standCounter++;
         else if (washType == deluxeWash)
            deluxeCounter++;

    }
//_____________________________________________TID OG DATO____________________________________________________________________
    /**
     * Method that will show what day it is
     * Day is shown in numbers (2-6 = Monday - Friday) and (1 and 7 = Saturday and Sunday)
     * @return Returns what day it is with a number value
     */
    public boolean deadlinedate(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        boolean betweenMondayandFriday = (day >= 2 && day <= 6);
        return betweenMondayandFriday;
    }

    /**
     * Method that will show what time of day it is
     *
     * @return deadlinen for the eralybird discount
     */
    public boolean deadlinetime(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        boolean isDiscountTime = (hour <= 14);
        return  isDiscountTime;
    }
    public static String date() {
        Date date = new Date();
        return "\nDate of purchase:\n " + date;
    }
}