package org.example;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.io.File;

import org.example.UI.MyFrame;

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
            new File("data.json").delete();
        } catch (Exception exception) {
        }
        new MyFrame();
    }
}