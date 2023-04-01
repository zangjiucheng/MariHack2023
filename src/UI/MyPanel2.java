package UI;

import javax.swing.*;

import main.Main;

import java.awt.*;

public class MyPanel2 extends JPanel {
    public MyPanel2() {
        this.setPreferredSize(Main.FULLSCREEN);
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(250, 0, 250, 1080);
        g.drawLine(0, 50, 250, 50);
    }
}
