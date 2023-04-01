package UI;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import main.Food_Attribute;
import main.JsonParser;
import main.RunPython;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import UI.MyFrame;

public class MyFrame2 extends JFrame {

    Font bold = new Font("myFont", Font.BOLD, 40);
    Font arial = new Font("myFont", Font.PLAIN, 20);
    Font bold2 = new Font("myFont", Font.BOLD, 20);
    MyPanel2 panel2 = new MyPanel2();
    JLabel title = new JLabel("NutriScan");
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
    String[] titles = { "Calories", "Fat", "Sugar" };
    String[][] data = new String[1][3];
    JTable table = new JTable(data, titles);
    JScrollPane sp = new JScrollPane(table);
    public static String fileName = "";
    Image picture = new ImageIcon("").getImage();
    ArrayList personList = new ArrayList();
    Image bad = new ImageIcon("src/Resources/Bad.png").getImage();
    Image good = new ImageIcon("src/Resources/Good.png").getImage();

    public MyFrame2() {
        setTitle("NutriScan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(MAXIMIZED_BOTH);

        fillList();

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
        JTableHeader header = table.getTableHeader();

        header.setFont(bold2);
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

        // add(takePicBtn);
        add(selectPicBtn);

        // add(sp);

        add(panel2);
        setVisible(true);

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
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }

                try {
                    if (!Desktop.isDesktopSupported()) {
                        System.out.println("Not supported");
                        return;
                    }

                    // Desktop desktop = Desktop.getDesktop();
                    // File picture = new File(fileName);
                    Food_Attribute food = JsonParser.createFoodAttribute();
                    System.out.println(food);
                    System.out.println(MyFrame.person);
                    // Boolean status2 = true;
                    String text = "";
                    if (MyFrame.person.isGoodCalorie(food.getCalories())) {
                        // data[0][0] = "Good";
                    } else {
                        // data[0][0] = "Bad";
                        text += "Calorie too much!";
                        // resultLBDetail.setText("Calorie too much!");
                        // System.out.println("Bad calorie");
                        status2 = false;
                    }

                    if (MyFrame.person.isGoodFat(food.getFat())) {
                        // data[0][1] = "Good";
                    } else {
                        // data[0][1] = "Bad";
                        text += "Fat too much!";
                        // resultLBDetail.setText("Fat too much!");
                        // System.out.println("Bad fat");
                        status2 = false;
                    }

                    if (MyFrame.person.isGoodSodium(food.getSodium())) {
                        // data[0][2] = "Good";
                    } else {
                        // data[0][2] = "Bad";
                        text += "Sodium too much!";
                        // resultLBDetail.setText("Sodium too much!");
                        // System.out.println("Bad sodium");
                        status2 = false;
                    }

                    resultLBDetail.setText(text);
                    if (status2) {
                        resultLB.setText("Good");
                    } else {
                        resultLB.setText("Bad");
                    }

                    resultLB.setVisible(true);
                    resultLBDetail.setVisible(true);
                    // Thread.sleep(4000);
                    repaint();

                    // dispose();
                    // paint(getGraphics()).dispose();
                    // new MyFrame2();

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

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

    public void fillList() {
        personList.add(MyFrame.name);
        personList.add(MyFrame.age);
        personList.add(MyFrame.gender);
        personList.add(MyFrame.weight);
        personList.add(getConditionText());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        picture = new ImageIcon(fileName.split(".")[0] + ".jpg").getImage();
        g.drawImage(picture, 457, 0, 600, 500, null);
        // dispose();
        // picture = new ImageIcon(MyFrame2.fileName).getImage();
        // g.drawImage(picture, 457, 0, 600, 500, null);
        if (status2) {
            g.drawImage(good, 1338, 100, 60, 60, null);
        } else {
            g.drawImage(bad, 1338, 100, 60, 60, null);
        }
    }

    boolean status2 = true;
}
