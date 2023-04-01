package UI;

import javax.swing.*;

import main.JsonParser;
import main.RunPython;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MyFrame2 extends JFrame {

    Font bold = new Font("myFont", Font.BOLD, 40);
    Font arial = new Font("myFont", Font.PLAIN, 20);
    Font bold2 = new Font("myFont", Font.BOLD, 20);
    MyPanel2 panel2 = new MyPanel2();
    JLabel title = new JLabel("GitHealth");
    JLabel nameLB = new JLabel("Name");
    JLabel ageLB = new JLabel("Age");
    JLabel genderLB = new JLabel("Gender");
    JLabel weightLB = new JLabel("Weight (kg)");
    JLabel conditionLB = new JLabel("Condition");
    JLabel nameLB2 = new JLabel(MyFrame.name);
    JLabel ageLB2 = new JLabel(String.valueOf(MyFrame.age));
    JLabel genderLB2 = new JLabel(MyFrame.gender);
    JLabel weightLB2 = new JLabel(String.valueOf(MyFrame.weight));
    JLabel conditionLB2 = new JLabel();
    JButton takePicBtn = new JButton("Take a picture");
    JButton selectPicBtn = new JButton("Select a picture");
    JLabel resultLB = new JLabel("Result");
    JLabel resultLBDetail = new JLabel("");
    // String[] titles = { "Calories", "Fat", "Sugar" };
    String[][] data = { { "0", "0", "0", "0", "0" } };
    String[] titles = { "Calories", "Fat", "Sugar", "Protein", "Sodium" };
    // String[] data = {};
    JTable table = new JTable(data, titles);
    JScrollPane sp = new JScrollPane(table);
    public static String fileName = "";
    Image picture = new ImageIcon("").getImage();
    Image bad = new ImageIcon("src/Resources/Bad.png").getImage();
    Image good = new ImageIcon("src/Resources/Good.png").getImage();
    JLabel picLabel;

    public MyFrame2() {
        setTitle("NutriScan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(MAXIMIZED_BOTH);
        try {
            picLabel = new JLabel(Utiles.readImage(
                    "img.jpg",
                    600, 500, 255));
            picLabel.setBounds(457, 0, 600, 500);
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
        resultLB.setVisible(false);

        resultLBDetail.setFont(arial);
        resultLBDetail.setBounds(1288, 30, 200, 120);
        resultLBDetail.setVisible(false);

        nameLB2.setFont(arial);
        nameLB2.setBounds(20, 150, 200, 50);
        ageLB2.setFont(arial);
        ageLB2.setBounds(20, 300, 200, 50);
        genderLB2.setFont(arial);
        genderLB2.setBounds(20, 450, 200, 50);
        weightLB2.setFont(arial);
        weightLB2.setBounds(20, 600, 200, 50);
        conditionLB2.setFont(arial);
        conditionLB2.setBounds(20, 750, 200, 50);
        conditionLB2.setText(getConditionText());

        takePicBtn.setFont(bold2);
        takePicBtn.setBounds(250, 0, 200, 100);
        selectPicBtn.setFont(bold2);
        selectPicBtn.setBounds(250, 100, 200, 100);

        table.setFont(bold);
        table.setRowHeight(50);

        sp.setBounds(250, 500, 1200, 500);

        add(title);
        add(nameLB);
        add(ageLB);
        add(genderLB);
        add(weightLB);
        add(conditionLB);
        add(resultLB);
        add(resultLBDetail);

        add(nameLB2);
        add(ageLB2);
        add(genderLB2);
        add(weightLB2);
        add(conditionLB2);

        add(selectPicBtn);

        add(sp);

        add(panel2);
        setVisible(true);

        if (UIElements.food != null) {
            System.out.println("food is not null");
            information();

            table.repaint();
        }

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
                    try {
                        RunPython.executive(fileName);
                    } catch (IOException | InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }

                try {
                    if (!Desktop.isDesktopSupported()) {
                        System.out.println("Not supported");
                        return;
                    }

                    UIElements.status2 = true;
                    UIElements.food = JsonParser.createFoodAttribute();
                    System.out.println(UIElements.food);
                    System.out.println(MyFrame.person);

                    dispose();
                    new MyFrame2();

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }

    public void information() {
        UIElements.text = "";
        if (!MyFrame.person.isGoodCalorie(UIElements.food.getCalories())) {
            UIElements.text += "Calorie too much!";
            UIElements.status2 = false;
        }

        if (!MyFrame.person.isGoodFat(UIElements.food.getFat())) {
            UIElements.text += "Fat too much!";
            UIElements.status2 = false;
        }

        if (!MyFrame.person.isGoodSodium(UIElements.food.getSodium())) {
            UIElements.text += "Sodium too much!";
            UIElements.status2 = false;
        }

        resultLBDetail.setText(UIElements.text);
        if (UIElements.status2) {
            resultLB.setText("Good");
        } else {
            resultLB.setText("Bad");
        }

        data[0][0] = String.valueOf(UIElements.food.getCalories());
        if (UIElements.food.getCalories() == -1) {
            data[0][0] = "No Data";
        }
        data[0][1] = String.valueOf(UIElements.food.getFat());
        if (UIElements.food.getFat() == -1) {
            data[0][1] = "No Data";
        }
        data[0][2] = String.valueOf(UIElements.food.getSugar());
        if (UIElements.food.getSugar() == -1) {
            data[0][2] = "No Data";
        }
        data[0][3] = String.valueOf(UIElements.food.getProtein());
        if (UIElements.food.getProtein() == -1) {
            data[0][3] = "No Data";
        }
        data[0][4] = String.valueOf(UIElements.food.getSodium());
        if (UIElements.food.getSodium() == -1) {
            data[0][4] = "No Data";
        }

        resultLB.setVisible(true);
        resultLBDetail.setVisible(true);
    }

    public String getConditionText() {
        if (MyFrame.condition[0]) {
            return "Staying Healthy";
        } else if (MyFrame.condition[1]) {
            return "Obesity";
        } else if (MyFrame.condition[2]) {
            return "Diabetes T1";
        } else {
            return "Diabetes T2";
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (UIElements.status2) {
            g.drawImage(good, 1338, 200, 60, 60, null);
        } else {
            g.drawImage(bad, 1338, 200, 60, 60, null);
        }
    }

}
