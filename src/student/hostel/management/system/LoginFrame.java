
package student.hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.Container;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {
    
    
    Container container = getContentPane();
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton ("Login");
    JButton resetButton = new JButton ("Reset");
    JCheckBox showPassword = new JCheckBox("Show Password");

    LoginFrame()
    {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    
    public void setLayoutManager()
    {
        container.setLayout(null);
    }
    
    public void setLocationAndSize()
    {
        Font titleFont = new Font("Rockwell", Font.ITALIC, 15);
        JLabel titleLabel = new JLabel("Student Hostel Management System");
        titleLabel.setBounds(50, 50, 250, 80);
        titleLabel.setFont(titleFont);
        container.add(titleLabel);
        
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);
        
    }
    
    public void addComponentsToContainer()
    {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
    
    public void addActionEvent()
    {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
    
    @Override
    
   
    
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == loginButton) {
            String userText = userTextField.getText();
            String pwdText = new String(passwordField.getPassword());
            
            try (BufferedReader br = new BufferedReader(new FileReader("login.txt"))){
                String line;
                boolean isLoginSuccessful = false;
                while ((line = br.readLine()) != null){
                    String[] parts = line.split(",");
                    String username = parts[0];
                    String password = parts[1];
                    if (userText.equalsIgnoreCase(username) && pwdText.equalsIgnoreCase(password)){
                        JOptionPane.showMessageDialog(this, "Login Successful");
                        isLoginSuccessful = true;
                        break;
                    }
                }
                if (isLoginSuccessful){
                AdminMenu dialogBox = new AdminMenu();
                dialogBox.setVisible(true);
            } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        
        }
    
    
        if (e.getSource()==resetButton){
            userTextField.setText("");
            passwordField.setText("");
        }
        
        if ( e.getSource()==showPassword){
            if(showPassword.isSelected()){
                passwordField.setEchoChar((char)0);
            }else{
                passwordField.setEchoChar('*');
            }
        }
    }
    public static void main(String[] args) {
        new LoginFrame();
    }
} 


