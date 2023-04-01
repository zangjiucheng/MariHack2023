package UI;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * This class is include some useful utiles.
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-31
 * 
 */

public class Utiles {

    /**
     * @param path
     * @param width
     * @param height
     * @param alpha
     * @return ImageIcon
     */
    public static ImageIcon readImage(String path, int width, int height, int alpha) {
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File(path));
            myPicture = ScaledImage(myPicture, width, height);
            myPicture = img_alpha(myPicture, alpha);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Image not found");

        }
        return new ImageIcon(myPicture);
    }

    /**
     * @param Image
     * @param w
     * @param h
     * @return BufferedImage
     */
    public static BufferedImage ScaledImage(BufferedImage Image, int w, int h) {
        BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        java.awt.Graphics2D g = resizedImage.createGraphics();
        g.setRenderingHint(java.awt.RenderingHints.KEY_INTERPOLATION,
                java.awt.RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(Image, 0, 0, w, h, null);
        g.dispose();
        return resizedImage;
    }

    /**
     * @param java.awt.Color(0
     * @param 0
     * @param 0
     * @param imgsrc
     * @param alpha
     */
    public static void transparentPanel(JPanel panel) { // make panel transparent
        // https://stackoverflow.com/questions/2545214/how-to-set-a-transparent-background-of-jpanel
        panel.setOpaque(false);
        panel.setBackground(new java.awt.Color(0, 0, 0, 0));
    }

    /**
     * @param imgsrc
     * @param alpha
     * @return BufferedImage
     */
    public static BufferedImage img_alpha(BufferedImage imgsrc, int alpha) { // make image transparent (alpha)
                                                                             // https://blog.csdn.net/luanpeng825485697/article/details/78157263
        try {
            BufferedImage back = new BufferedImage(imgsrc.getWidth(), imgsrc.getHeight(), BufferedImage.TYPE_INT_ARGB);
            int width = imgsrc.getWidth();
            int height = imgsrc.getHeight();
            for (int j = 0; j < height; j++) {
                for (int i = 0; i < width; i++) {
                    int rgb = imgsrc.getRGB(i, j);
                    Color color = new Color(rgb);
                    Color newcolor = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
                    back.setRGB(i, j, newcolor.getRGB());
                }
            }
            return back;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}