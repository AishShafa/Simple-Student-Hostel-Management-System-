
package student.hostel.management.system;

import javax.swing.JFrame;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;


public class HostelApplications extends JFrame  {
    
    public final String filename = "HostelForms.txt";
        
        public HostelApplications(){
            
        }
        
        public void updateRegistrationData(String studentid2, String studentname2, String studentnumber2, String studentroom2) {
            try {
                File inputFile = new File("HostelForms.txt");
                File tempFile = new File("temp.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

                String line;
                boolean updated = false;

                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 4 && data[0].trim().equals("Student ID") && data[1].trim().equals("Name") &&
                            data[2].trim().equals("Phone Number") && data[3].trim().equals("Hostel Room")) {
                        writer.println(line);
                        updated = true;
                    } else if (data.length == 4 && data[0].trim().equals(studentid2) &&
                            data[1].trim().equals(studentname2) && data[2].trim().equals(studentnumber2)) {
                        writer.println(studentid2 + "," + studentname2 + "," + studentnumber2 + "," + studentroom2);
                        updated = true;
                        } else {
                            writer.println(line);
                    }
                }

                if (!updated) {
                    writer.println("Student ID,Name,Phone Number,Hostel Room");
                    writer.println(studentid2 + "," + studentname2 + "," + studentnumber2 + "," + studentroom2);
                }

                reader.close();
                writer.close();

                if (inputFile.delete()) {
                    if (tempFile.renameTo(inputFile)) {
                        System.out.println("Application data edited successfully.");
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

}
    

