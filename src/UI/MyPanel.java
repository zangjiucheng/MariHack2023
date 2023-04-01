package UI;

import javax.swing.*;
import java.awt.*;
import main.Main;

public class MyPanel extends JPanel {
    Image logo = new ImageIcon("NutriScan Logo.png").getImage();

    MyPanel() {
        this.setPreferredSize(Main.FULLSCREEN);
        this.setBackground(Color.GRAY);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(logo, -20, 0, 400, 65 * Main.FULLSCREEN.height / 100, null);
    }
}
