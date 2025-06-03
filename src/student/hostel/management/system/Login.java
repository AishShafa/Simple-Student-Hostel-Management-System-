
package student.hostel.management.system;

import javax.swing.JFrame;


public class Login{
    public static void main(String[] a) {
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Student Hostel Management System");
        frame.setBounds(20, 20, 370, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new java.awt.Color(204, 204, 255));
        frame.setVisible(true);
    }
}
