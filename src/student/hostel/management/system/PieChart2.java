package student.hostel.management.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PieChart2 extends JPanel {
    private int roomsAvailable;

    public PieChart2(int roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
        this.setPreferredSize(new Dimension(200, 200));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int totalRooms = 300;
        int startAngle = 0;

        int arcAngleAvailable = roomsAvailable * 360 / totalRooms;
        g.setColor(Color.GREEN);
        g.fillArc(25, 25, 150, 150, startAngle, arcAngleAvailable);

        int arcAngleUnavailable = (totalRooms - roomsAvailable) * 360 / totalRooms;
        g.setColor(Color.RED);
        g.fillArc(25, 25, 150, 150, startAngle + arcAngleAvailable, arcAngleUnavailable);
    }
}
