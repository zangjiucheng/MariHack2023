package GUI;

import javax.swing.*;
import java.awt.*;

public class UserForm extends JFrame {
    private JLabel titleLabel, nameLabel, ageLabel, photoLabel, backgroundLabel;
    private JTextField nameField, ageField;
    private JCheckBox diabetesCheckBox, hypertensionCheckBox;
    private JButton submitButton, uploadButton;

    public UserForm() {
        // Set up the window
        setTitle("User Form");
        setSize(1730, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the name label and field
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        nameLabel.setForeground(new Color(71, 71, 71));
        nameLabel.setBounds(100, 50, 100, 50);
        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 24));
        nameField.setBounds(210, 50, 300, 50);

        // Create the age label and field
        ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        ageLabel.setForeground(new Color(71, 71, 71));
        ageLabel.setBounds(100, 110, 100, 50);
        ageField = new JTextField();
        ageField.setFont(new Font("Arial", Font.PLAIN, 24));
        ageField.setBounds(210, 110, 100, 50);

        // Create the diabetes and hypertension check boxes
        diabetesCheckBox = new JCheckBox();
        diabetesCheckBox.setIcon(new ImageIcon("diabetes.png"));
        diabetesCheckBox.setSelectedIcon(new ImageIcon("diabetes_checked.png"));
        diabetesCheckBox.setBorderPainted(false);
        hypertensionCheckBox = new JCheckBox();
        hypertensionCheckBox.setIcon(new ImageIcon("hypertension.png"));
        hypertensionCheckBox.setSelectedIcon(new ImageIcon("hypertension_checked.png"));
        hypertensionCheckBox.setBorderPainted(false);

        // // Create the submit button
        // JButton submitButton = new JButton("Submit");

        // // Create the panel and add the components to it
        // JPanel panel = new JPanel();
        // panel.add(nameLabel);
        // panel.add(nameField);
        // panel.add(ageLabel);
        // panel.add(ageField);
        // panel.add(diabetesCheckBox);
        // panel.add(hypertensionCheckBox);
        // panel.add(submitButton);

        // Create the submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        submitButton.setForeground(new Color(255, 255, 255));
        submitButton.setBackground(new Color(71, 71, 71));
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        submitButton.setFocusPainted(false);

        // Create the photo label
        photoLabel = new JLabel();
        photoLabel.setBorder(BorderFactory.createLineBorder(new Color(71, 71, 71), 2));
        photoLabel.setBounds(540, 170, 150, 150);

        // // Create the panel and add the components to it
        // JPanel panel = new JPanel();
        // panel.setLayout(null);
        // panel.setBackground(new Color(245, 245, 245));
        // panel.setBorder(BorderFactory.createLineBorder(new Color(71, 71, 71), 2));
        // panel.setBounds(520, 250, 690, 460);
        // panel.add(nameLabel);
        // panel.add(nameField);
        // panel.add(ageLabel);
        // panel.add(ageField);
        // panel.add(diabetesCheckBox);
        // panel.add(hypertensionCheckBox);
        // panel.add(submitButton);

        // Create the panel and add the components to it
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(238, 238, 238));
        // panel.add(titleLabel);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(diabetesCheckBox);
        panel.add(hypertensionCheckBox);
        panel.add(submitButton);
        // panel.add(uploadButton);
        panel.add(photoLabel);

        // Set the panel as the content pane of the frame
        setContentPane(panel);

        // Add the background image to the frame
        ImageIcon backgroundImage = new ImageIcon("background.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        panel.add(backgroundLabel);

        // Set the panel layout to null to position the components manually
        // panel.setLayout(null);

        // Position the components on the panel
        nameLabel.setBounds(200, 300, 100, 30);
        nameField.setBounds(350, 300, 300, 30);
        ageLabel.setBounds(200, 350, 100, 30);
        ageField.setBounds(350, 350, 100, 30);
        diabetesCheckBox.setBounds(200, 400, 150, 30);
        hypertensionCheckBox.setBounds(350, 400, 200, 30);
        submitButton.setBounds(200, 500, 100, 30);

        // // Create the name label and field
        // nameLabel = new JLabel("Name:");
        // nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        // nameLabel.setForeground(new Color(71, 71, 71));
        // nameField = new JTextField(20);
        // nameField.setFont(new Font("Arial", Font.PLAIN, 18));
        // nameField.setForeground(new Color(71, 71, 71));
        // nameField.setBorder(BorderFactory.createLineBorder(new Color(71, 71, 71),
        // 2));
        // nameField.setPreferredSize(new Dimension(300, 40));

        // // Create the age label and field
        // ageLabel = new JLabel("Age:");
        // ageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        // ageLabel.setForeground(new Color(71, 71, 71));
        // ageField = new JTextField(3);
        // ageField.setFont(new Font("Arial", Font.PLAIN, 18));
        // ageField.setForeground(new Color(71, 71, 71));
        // ageField.setBorder(BorderFactory.createLineBorder(new Color(71, 71, 71), 2));
        // ageField.setPreferredSize(new Dimension(100, 40));

        // // Create the photo label
        // photoLabel = new JLabel();
        // photoLabel.setBorder(BorderFactory.createLineBorder(new Color(71, 71, 71),
        // 2));
        // photoLabel.setBounds(540, 170, 150, 150);

        // // Create the background label and add it to the content pane
        // backgroundLabel = new JLabel();
        // backgroundLabel.setIcon(new ImageIcon("background.jpg"));
        // backgroundLabel.setBounds(0, 0, 1730, 1080);
        // getContentPane().add(backgroundLabel);

        // Add the title label and panel to the background label
        // backgroundLabel.add(title);
        // backgroundLabel.add(panel);

        // Display the window
        setVisible(true);
    }

    public static void main(String[] args) {
        UserForm form = new UserForm();
    }
}