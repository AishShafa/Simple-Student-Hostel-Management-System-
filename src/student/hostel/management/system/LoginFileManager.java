package student.hostel.management.system;

import java.io.*;

public class LoginFileManager {
    private static final String FILE_PATH = "login.txt";

    public static void editLogin(String loginId, String newPassword) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            boolean loginFound = false;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                String password = parts[1];
                if (loginId.equalsIgnoreCase(username)) {
                    fileContent.append(loginId).append(",").append(newPassword).append("\n");
                    loginFound = true;
                } else {
                    fileContent.append(line).append("\n");
                }
            }

            if (loginFound) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                    bw.write(fileContent.toString());
                    System.out.println("Login edited successfully");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Login not found");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void addLogin(String loginId, String password) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(loginId + "," + password);
            bw.newLine();  // Add a new line after each login entry
            System.out.println("Login added successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
