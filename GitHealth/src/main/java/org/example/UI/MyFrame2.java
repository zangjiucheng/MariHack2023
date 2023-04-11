package org.example.UI;


import javax.swing.*;
import javax.swing.table.JTableHeader;

import org.example.Process.JsonParser;
import org.example.Process.RunPython;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MyFrame2 extends JFrame {

    Font bold = new Font("myFont", Font.BOLD, 40);
    Font arial = new Font("myFont", Font.PLAIN, 20);
    Font bold2 = new Font("myFont", Font.BOLD, 20);
    MyPanel2 panel2 = new MyPanel2();
    JLabel title = new JLabel("GitHealthy");
    JLabel nameLB = new JLabel("Name");
    JLabel ageLB = new JLabel("Age");
    JLabel genderLB = new JLabel("Gender");
    JLabel weightLB = new JLabel("Weight (kg)");
    JLabel conditionLB = new JLabel("Condition");
    JLabel nameLB2 = new JLabel(MyFrame.name);
    JLabel ageLB2 = new JLabel(String.valueOf(MyFrame.age));
    JLabel genderLB2 = new JLabel(MyFrame.gender);
    JLabel weightLB2 = new JLabel(String.valueOf(MyFrame.weight));
    //JButton takePicBtn = new JButton("Take a picture");
    JButton selectPicBtn = new JButton("Select a picture");
    JLabel resultLB = new JLabel("Result");
    JLabel resultLBDetail = new JLabel("");
    String[][] data = { { "0", "0", "0", "0", "0" } };
    String[] titles = { "Calories", "Fat", "Sugars", "Protein", "Sodium" };
    JTable table = new JTable(data, titles);
    JScrollPane sp = new JScrollPane(table);
    public static String fileName = "";
    //Image picture = new ImageIcon("").getImage();
    //Image bad = new ImageIcon("src/main/resources/Bad.png").getImage();
    //Image good = new ImageIcon("src/main/resources/Good.png").getImage();
    //Image mid = new ImageIcon("src/main/resources/Mid.png").getImage();
    JLabel picLabel;
    boolean badResult = false;
    JButton helpBtn = new JButton("Help");
    JLabel result2LB = new JLabel();
    JLabel indicatorLB = new JLabel("Image Goes Here");
    int missingData = 0;
    JTextArea conditionsTA = new JTextArea();
    ImageIcon goodPic;
    ImageIcon badPic;
    ImageIcon midPic;
    JLabel iconLB = new JLabel();
    public MyFrame2() {
        setTitle("GitHealthy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(MAXIMIZED_BOTH);
        try {
            picLabel = new JLabel(Utiles.readImage(
                    "img.jpg",
                    600, 500, 255));
            picLabel.setBounds(459, 0, 600, 500);
            add(picLabel);
        } catch (Exception e) {
        }
        title.setFont(bold);
        title.setBounds(0, 0, 250, 50);
        nameLB.setFont(bold2);
        nameLB.setBounds(20, 100, 200, 50);
        ageLB.setBounds(20, 250, 200, 50);
        ageLB.setFont(bold2);
        genderLB.setFont(bold2);
        genderLB.setBounds(20, 400, 200, 50);
        weightLB.setFont(bold2);
        weightLB.setBounds(20, 550, 200, 50);
        conditionLB.setFont(bold2);
        conditionLB.setBounds(20, 700, 200, 50);
        resultLB.setFont(bold);
        resultLB.setBounds(1288, 0, 200, 50);

        resultLBDetail.setFont(arial);
        resultLBDetail.setBounds(1288, 30, 200, 120);
        resultLBDetail.setVisible(false);

        result2LB.setFont(bold);
        result2LB.setBounds(1298, 150, 200, 50);

        indicatorLB.setFont(bold);
        indicatorLB.setBounds(593, 215, 327, 48);

        conditionsTA.setFont(arial);
        conditionsTA.setBounds(20, 750, 200, 250);
        conditionsTA.setText(getConditionText());

        nameLB2.setFont(arial);
        nameLB2.setBounds(20, 150, 200, 50);
        ageLB2.setFont(arial);
        ageLB2.setBounds(20, 300, 200, 50);
        genderLB2.setFont(arial);
        genderLB2.setBounds(20, 450, 200, 50);
        weightLB2.setFont(arial);
        weightLB2.setBounds(20, 600, 200, 50);

        //takePicBtn.setFont(bold2);
        //takePicBtn.setBounds(250, 0, 200, 100);
        selectPicBtn.setFont(bold2);
        selectPicBtn.setBounds(250, 0, 207, 100);
        helpBtn.setFont(bold2);
        helpBtn.setBounds(250,100, 207, 100);

        table.setFont(bold);
        table.setRowHeight(50);
        JTableHeader header = table.getTableHeader();
        header.setFont(bold2);

        sp.setBounds(250, 500, 1290, 500);

        goodPic = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Good.png")));
        badPic = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Bad.png")));
        midPic = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Mid.png")));
        iconLB.setBounds(1322, 80, 60, 60);

        add(title);
        add(nameLB);
        add(ageLB);
        add(genderLB);
        add(weightLB);
        add(conditionLB);
        add(resultLB);
        add(resultLBDetail);
        add(result2LB);

        add(nameLB2);
        add(ageLB2);
        add(genderLB2);
        add(weightLB2);
        add(indicatorLB);

        add(selectPicBtn);
        add(helpBtn);

        add(sp);
        add(conditionsTA);
        add(iconLB);

        add(panel2);
        setVisible(true);

        if (UIElements.food != null) {
            System.out.println("food is not null");
            information();
            table.repaint();
        }

        helpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This application scans the nutrition facts of a food" +
                                "and tells the user if the food is healthy, considering the informations entered in the login page.\n" +
                                "If the food is healthy, the application will show a green happy face. Otherwise, it will show red mad face. " +
                                "A yellow face is shown when not enough data is present\n" +
                                "You will also see in a table the data collected from the product's nutrition facts.\n" +
                                "To select a picture, click the button named " +
                                "Select a picture. Once you chose a picture of a food's nutrition facts, it will be displayed and" +
                                " the results will be shown.\n\n The scans can take some time 10-15 sec, so please be patient.\n Also, you" +
                                " may want to rescan a picture if some of the data is missing as the data collected from the " +
                                "scans can differ. Lastly, make sure to only use .jpg or .heic files."
                        );
            }
        });

        selectPicBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int status = chooser.showOpenDialog(null);

                if (status == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    if (file == null) {
                        return;
                    }

                    fileName = chooser.getSelectedFile().getAbsolutePath();

                    if (!fileName.equals("")) {
                        try {
                            RunPython.executive(fileName);
                        } catch (IOException | InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                }

                try {
                    if (!fileName.equals("")) {
                        if (!Desktop.isDesktopSupported()) {
                            System.out.println("Not supported");
                            return;
                        }

                        missingData = 0;
                        UIElements.status2 = true;
                        UIElements.food = JsonParser.createFoodAttribute();
                        System.out.println(UIElements.food);
                        System.out.println(MyFrame.person);
                        badResult = false;

                        dispose();
                        new MyFrame2();
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }

    public void information() {
        UIElements.text = "";
        if (!MyFrame.person.isGoodCalorie(UIElements.food.getCalories())) {
            UIElements.text += "Too much Calories!";
            UIElements.status2 = false;
        }

        if (!MyFrame.person.isGoodFat(UIElements.food.getFat())) {
            UIElements.text += "Too much Fats!";
            UIElements.status2 = false;
        }

        if (!MyFrame.person.isGoodSodium(UIElements.food.getSodium())) {
            UIElements.text += "Too much Sodium!";
            UIElements.status2 = false;
        }

        resultLBDetail.setText(UIElements.text);
        if (UIElements.status2) {
            //resultLB.setText("Good");
            result2LB.setText("Good");
        } else {
            //resultLB.setText("Bad");
            badResult = true;
            result2LB.setText("Bad");
        }

        data[0][0] = String.valueOf(UIElements.food.getCalories());
        if (UIElements.food.getCalories() == -1) {
            data[0][0] = "No Data";
            missingData++;
        }
        data[0][1] = String.valueOf(UIElements.food.getFat());
        if (UIElements.food.getFat() == -1) {
            data[0][1] = "No Data";
            missingData++;
        }
        data[0][2] = String.valueOf(UIElements.food.getSugar());
        if (UIElements.food.getSugar() == -1) {
            data[0][2] = "No Data";
            missingData++;
        }
        data[0][3] = String.valueOf(UIElements.food.getProtein());
        if (UIElements.food.getProtein() == -1) {
            data[0][3] = "No Data";
            missingData++;
        }
        data[0][4] = String.valueOf(UIElements.food.getSodium());
        if (UIElements.food.getSodium() == -1) {
            data[0][4] = "No Data";
            missingData++;
        }

        resultLBDetail.setVisible(true);
    }

    public String getConditionText() {

        String text = "";

        if (MyFrame.condition[0]) {
           text += "Diabetes type 2\n";
        }
        if (MyFrame.condition[1]) {
            text += "Obesity\n";
        }
        if (MyFrame.condition[2]) {
            text += "Staying Healthy";
        }

        return text;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(2));

        if (missingData > 1) {
            iconLB.setIcon(midPic);
            //g.drawImage(mid, 1328, 100, 60, 60, null);
            result2LB.setText("Not enough data");
            result2LB.setBounds(1190, 150, 350, 50);
        } else if (UIElements.status2) {
            //g.drawImage(good, 1328, 100, 60, 60, null);
            iconLB.setIcon(goodPic);
            result2LB.setBounds(1298, 150, 200, 50);
        } else if (badResult) {
            //g.drawImage(bad, 1328, 100, 60, 60, null);
            iconLB.setIcon(badPic);
            result2LB.setBounds(1315, 150, 200, 50);
        }
    }
}
