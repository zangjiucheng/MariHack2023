package UI;

import javax.swing.*;

import java.awt.*;

public class MyPanel extends JPanel {
    Image logo = new ImageIcon("src/Resources/GitHealthy.png").getImage();

    MyPanel() {
        this.setPreferredSize(MyFrame.FULLSCREEN);
        this.setBackground(Color.GRAY);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(logo, -20, 0, 400, 65 * MyFrame.FULLSCREEN.height / 100, null);
    }
}
