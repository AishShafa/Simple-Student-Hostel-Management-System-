package student.hostel.management.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


public class PieChart extends JPanel {
    private int paidFees;
    private int unpaidFees;

    public PieChart(int paidFees, int unpaidFees) {
        this.paidFees = paidFees;
        this.unpaidFees = unpaidFees;
        this.setPreferredSize(new Dimension(200, 200));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int totalFees = paidFees + unpaidFees;
        int startAngle = 0;
        
        int arcAnglePaid = paidFees * 360 / totalFees;
        g.setColor(Color.GREEN);
        g.fillArc(25, 25, 150, 150, startAngle, arcAnglePaid);

        int arcAngleUnpaid = unpaidFees * 360 / totalFees;
        g.setColor(Color.RED);
        g.fillArc(25, 25, 150, 150, startAngle + arcAnglePaid, arcAngleUnpaid);      
    }
}
