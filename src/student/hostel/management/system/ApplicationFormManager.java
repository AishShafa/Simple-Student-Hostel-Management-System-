package student.hostel.management.system;

import java.io.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ApplicationFormManager extends JFrame{
    
    private final String filename = "HostelApplications.txt";
    
    
    public void addRegistrationData(String studentid1, String studentname1, String studentnumber1, String studenthostel1, String roomtype1, String payment1, String status1) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename, true));
            writer.println(studentid1 + "," + studentname1 + "," + studentnumber1 + "," + studenthostel1 + "," + roomtype1 + "," + payment1 + "," + status1);
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error adding application information: " + ex.getMessage());
        }
    }

    public void editRegistrationData(String studentid1, String studentname1, String studentnumber1, String studenthostel1, String roomtype1, String payment1, String status1) {
        try {
            File inputFile = new File("HostelApplications.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

            String line;
            boolean foundEntry = false;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(studentid1)) {
                    writer.println(studentid1 + "," + studentname1 + "," + studentnumber1 + "," + studenthostel1 + "," + roomtype1 + "," + payment1 + "," + status1);
                    foundEntry = true;
                } else {
                    writer.println(line);
                }
            }

            reader.close();
            writer.close();

            if (inputFile.delete()) {
                if (tempFile.renameTo(inputFile)) {
                    if (foundEntry) {
                        System.out.println("Application data edited successfully.");
                    } else {
                        System.out.println("Entry with Student ID " + studentid1 + " not found.");
                    }
                } else {
                    System.out.println("Error editing application data: Could not rename temp file.");
                }
            } else {
                System.out.println("Error editing application data: Could not delete input file.");
            }
        } catch (IOException ex) {
            System.out.println("Error editing application data: " + ex.getMessage());
        }
    }
    
    public void deleteRegistrationData(String studentid1, String studentname1, String studentnumber1, String studenthostel1, String roomtype1, String payment1, String status1) {
        try {
            File inputFile = new File("HostelApplications.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

            String line;
            boolean foundEntry = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (!data[0].equals(studentid1)) {
                    writer.println(line);
                } else {
                    foundEntry = true;
                }
            }

            reader.close();
            writer.close();

            if (inputFile.delete()) {
                if (tempFile.renameTo(inputFile)) {
                    if (foundEntry) {
                        System.out.println("Application data deleted successfully.");
                    } else {
                        System.out.println("Entry with Student ID " + studentid1 + " not found.");
                    }
                } else {
                    System.out.println("Error deleting application data: Could not rename temp file.");
                }
            } else {
                System.out.println("Error deleting application data: Could not delete input file.");
            }
        } catch (IOException ex) {
            System.out.println("Error deleting application data: " + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationFormManager formManagerGUI = new ApplicationFormManager();
                formManagerGUI.setVisible(true);
            }
        });
    }
}
