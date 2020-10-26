package com.company;
import java.util.ArrayList;
public class Kortinformationer {

    /**
     * Class that creates an Arraylist
     * Used with Person class to create account with name and balance
     * Save values of user input so they can be used in the system
     */
    private ArrayList<Person> kortinformationer = new ArrayList<Person>();


    public Kortinformationer() {

    }

    /**
     * Creates a person using the Person class
     * @param name String that contains a name
     * @param balance double that can be used to store balance
     */
    public void add(String name, double balance){
        Person person = new Person(name, balance);
        kortinformationer.add(person);
    }

    /**
     * Searches for person added in arraylist and get their name and balance
     * @param name String that contains a name
     * @return returns balance of person
     */
    public double searchPerson(String name){
        for(Person person : kortinformationer){
            if(name.compareTo(person.getName()) == 0){
                double mainBalance = person.getBalance();
                return mainBalance;
            }
        }
        return 0;
    }

    /**
     * Method that can be used to change balance of user
     * Types error message if it cant find chosen user
     * @param name String that contains name of chosen account
     * @param addamount double that can add balance to a card
     * @return
     */
    public double changebalance(String name, double addamount){
        for(Person person : kortinformationer){
            if(name.compareTo(person.getName()) == 0){
                double newBalance = addamount + person.getBalance();;
                return person.changeBalance(newBalance);
            }else{
                System.out.println("We couldnt find your account, card balance = ");
                return 0;
            }
        }
        return 0;
    }

    /**
     * Method that will calculate current balance
     * Displays error message if chosen user cant be found
     * @param name String contains name of chosen account
     * @param price Subtracts price of wash from balance
     * @return
     */
    public double balanceCalculator(String name, double price){
        for(Person person : kortinformationer){
            if(name.compareTo(person.getName()) == 0){
                return person.changeBalance((person.getBalance() - price));
            }
        }
        System.out.println("We couldnt find your account, card balance = ");
        return 0;
    }

    public void printAll(){
        for(Person person : kortinformationer){
            System.out.println(person);
        }
    }
}