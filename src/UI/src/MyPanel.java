import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    Image logo = new ImageIcon("GitHealthy.png").getImage();
    MyPanel(){
        this.setPreferredSize(Main.FULLSCREEN);
        this.setBackground(Color.GRAY);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(logo,-70,0,470,65*Main.FULLSCREEN.height/100, null);
    }
}
