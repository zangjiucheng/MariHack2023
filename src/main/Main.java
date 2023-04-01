package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import UI.MyFrame;
import UI.MyFrame2;

/**
 * 
 * Main class to run the program
 * 
 * @author Jiucheng
 * 
 */

public class Main {
    public static final Dimension FULLSCREEN = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String args[]) {
        // try {
        // RunPython.executive("src/Datas/IMG_5259.HEIC");
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }
        // Food_Attribute food = JsonParser.createFoodAttribute();
        // System.out.println(food);
        // // Toolkit.getDefaultToolkit().getScreenSize();
        new MyFrame();
        // new MyFrame2();
    }

}