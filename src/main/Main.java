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
        try {
            RunPython.executive("src/Datas/IMG_5257.HEIC");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Food_Attribute food = JsonParser.createFoodAttribute();
        System.out.println(food);
    }

}