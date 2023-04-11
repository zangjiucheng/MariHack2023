package org.example.UI;


import javax.swing.*;

import java.awt.*;

public class MyPanel2 extends JPanel {
    public MyPanel2() {
        this.setPreferredSize(MyFrame.FULLSCREEN);
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g.drawLine(250, 0, 250, 1080);
        g.drawLine(0, 50, 250, 50);
        g2D.setStroke(new BasicStroke(5));
        g.drawRect(459, 2, 600, 496);
    }
}
