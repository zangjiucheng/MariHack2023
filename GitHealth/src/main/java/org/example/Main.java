package org.example;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.io.File;

import org.example.UI.MyFrame;
import org.example.UI.MyFrame2;

/**
 * 
 * Main class to run the program
 * 
 * @authors Jiucheng, Gabriel
 *
 */

public class Main {

    public static void main(String args[]) {

        try {
            new File("img.jpg").delete();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        new MyFrame();
    }
}