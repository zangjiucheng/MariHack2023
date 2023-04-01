package main;

/**
 * 
 * Main class to run the program
 * 
 * @author Jiucheng
 * 
 */

public class Main {
    public static void main(String args[]) {
        Food_Attribute food = JsonParser.createFoodAttribute();
        System.out.println(food);
    }
}
