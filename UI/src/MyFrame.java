import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    Font bold = new Font("myFont", Font.BOLD, 30);
    Font arial = new Font("myFont", Font.PLAIN, 20);
    MyPanel panel = new MyPanel();
    JLabel title = new JLabel("SIGN IN");
    JLabel fNameLabel = new JLabel("Name");
    JLabel lNameLabel = new JLabel("Last Name");
    JLabel ageLabel = new JLabel("Age");
    JLabel conditionLabel = new JLabel("Condition");
    JButton confirmBtn = new JButton("CONFIRM");
    JTextField fNameTF = new JTextField();
    JTextField lNameTF = new JTextField();
    JTextField ageTF = new JTextField();
    String s1[] = { "","Staying Healthy", "Obesity", "Diabetes T1", "Diabetes T2"};
    String s2[] = { "","M", "F"};
    JComboBox conditionCB = new JComboBox(s1);
    JComboBox genderCB = new JComboBox(s2);
    JLabel weightLabel = new JLabel("Weight (kg)");
    JLabel genderLabel = new JLabel("Biological Gender");
    JTextField weightTF = new JTextField();
    JList test = new JList();
    public static String name = "";
    public static int age = 0;
    public static String gender = "";
    public static float weight = 0;
    public static boolean[] condition = new boolean[4];


    public MyFrame() {

        setTitle("Login");
        setSize(39*Main.FULLSCREEN.width/100,69*Main.FULLSCREEN.height/100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        title.setFont(bold);
        title.setBounds(400, -10, 250, 50);
        fNameLabel.setFont(arial);
        fNameLabel.setBounds(400, 30, 200, 50);
        lNameLabel.setBounds(400, 110, 200, 50);
        lNameLabel.setFont(arial);
        ageLabel.setFont(arial);
        ageLabel.setBounds(400, 190, 200, 50);
        conditionLabel.setFont(arial);
        conditionLabel.setBounds(400, 415, 200, 50);
        genderLabel.setBounds(400,270,200,50);
        genderLabel.setFont(arial);
        weightLabel.setFont(arial);
        weightLabel.setBounds(400, 345, 200, 50);


        confirmBtn.setFont(arial);
        confirmBtn.setBounds(400, 510, 200, 50);

        fNameTF.setFont(arial);
        fNameTF.setBounds(400, 75, 180, 30);
        lNameTF.setFont(arial);
        lNameTF.setBounds(400, 160, 180, 30);
        ageTF.setFont(arial);
        ageTF.setBounds(400,240, 180, 30);
        weightTF.setFont(arial);
        weightTF.setBounds(400, 390, 180, 30);

        conditionCB.setFont(arial);
        conditionCB.setBounds(400, 460, 180, 30);
        genderCB.setFont(arial);
        genderCB.setBounds(400, 320, 180, 30);

        add(lNameLabel);
        add(fNameLabel);
        add(ageLabel);
        add(conditionLabel);
        add(title);
        add(genderLabel);
        add(confirmBtn);
        add(weightLabel);

        add(fNameTF);
        add(lNameTF);
        add(ageTF);
        add(conditionCB);
        add(genderCB);
        add(weightTF);

        add(panel);
        setVisible(true);


        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (fNameTF.getText().equals("") && lNameTF.getText().equals("") && ageTF.getText().equals("") &&
                        genderCB.getSelectedItem().toString() == "" && weightTF.getText().equals("") &&
                        conditionCB.getSelectedItem().toString() == "") {

                    JOptionPane.showMessageDialog(null, "Please enter all the required information");

                }else {

                    dispose();
                    name = fNameTF.getText() + " " + lNameTF.getText();
                    age = Integer.parseInt(ageTF.getText());
                    weight = Float.parseFloat(weightTF.getText());
                    gender = genderCB.getSelectedItem().toString();

                    if (conditionCB.getSelectedItem() == s1[1]){
                        condition[0] = true;
                    }else if (conditionCB.getSelectedItem() == s1[2]) {
                        condition[1] = true;
                    }else if (conditionCB.getSelectedItem() == s1[3]) {
                        condition[2] = true;
                    }else {
                        condition[3] = true;
                    }

                    new MyFrame2();
                }
            }
        });

    }
}