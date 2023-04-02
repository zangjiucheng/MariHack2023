
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import UI.MyFrame;

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
            new File("img.jpg").delete();
        } catch (Exception exception) {
        }
        new MyFrame();
    }
}