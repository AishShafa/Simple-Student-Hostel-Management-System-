
package student.hostel.management.system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Records {
    private int numberOfStudents;
    private int paidFees;
    private int unpaidFees;
    private int roomsAvailable;
    private int monthlyIncome;
    
    public void calculateInformation() {
        try (BufferedReader br = new BufferedReader(new FileReader("HostelApplications.txt"))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                numberOfStudents++;


                int payment;
                try {
                    payment = Integer.parseInt(data[5]);
                } catch (NumberFormatException e) {
                    payment = 0;
                }
                monthlyIncome += payment;

                if (data[6].equalsIgnoreCase("Paid"))
                    paidFees++;
                else if (data[6].equalsIgnoreCase("Pending"))
                    unpaidFees++;
            }

            roomsAvailable = 300 - numberOfStudents;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getPaidFees() {
        return paidFees;
    }

    public int getUnpaidFees() {
        return unpaidFees;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public static void main(String[] args) {
        Records records = new Records();
        records.calculateInformation();

        System.out.println("Number of Students: " + records.getNumberOfStudents());
        System.out.println("Paid Fees: " + records.getPaidFees());
        System.out.println("Unpaid Fees: " + records.getUnpaidFees());
        System.out.println("Rooms Available: " + records.getRoomsAvailable());
        System.out.println("Monthly Income: " + records.getMonthlyIncome());
    }
}
