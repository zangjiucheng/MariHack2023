package UI;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import main.Food_Attribute;
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
    String[] titles = { "Calories", "Fat", "Sugar" };
    String[][] data = new String[1][3];
    JTable table = new JTable(data, titles);
    JScrollPane sp = new JScrollPane(table);
    public static String fileName = "";
    Image picture = new ImageIcon("").getImage();

    public MyFrame2() {
        setTitle("NutriScan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(MAXIMIZED_BOTH);

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
        getConditionText();

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

        add(nameLB2);
        add(ageLB2);
        add(genderLB2);
        add(weightLB2);
        add(conditionLB2);

        add(takePicBtn);
        add(selectPicBtn);

        add(sp);

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

                    Desktop desktop = Desktop.getDesktop();
                    File picture = new File("img.jpg");
                    Food_Attribute food = JsonParser.createFoodAttribute();

                    resultLB.setVisible(true);
                    repaint();

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void getConditionText() {
        if (MyFrame.condition[0]) {
            conditionLB2.setText("Diabetes type 2");
        } else if (MyFrame.condition[1]) {
            conditionLB2.setText("Obesity");
        } else {
            conditionLB2.setText("Staying Healthy");
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        picture = new ImageIcon(MyFrame2.fileName).getImage();
        g.drawImage(picture, 457, 0, 600, 500, null);
    }
}