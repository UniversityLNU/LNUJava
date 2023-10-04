package com.second;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Random;

public class DrawingPanel extends JPanel implements MouseListener {
    private BasicStroke graphStroke;
    private Color graphColor;
    private final Random random;

    public DrawingPanel() {
        super();

        graphStroke = new BasicStroke(2.0f);
        graphColor = Color.BLUE;
        random = new Random();

        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1.0f));
        g2d.drawLine(0, height / 2, width, height / 2);
        g2d.drawLine(width / 2, 0, width / 2, height);


        g2d.setColor(graphColor);
        g2d.setStroke(graphStroke);

        Path2D path = new Path2D.Double();
        double r = 80.0;
        double h = 50.0;
        double hCenter = height / 2.0;
        double wCenter = width / 2.0;

        double dTheta = 0.01;
        for (double t = 0; t <= 2 * Math.PI; t += dTheta) {
            double x = r * t - h * Math.sin(t);
            double y = r - h * Math.cos(t);
            if (t == 0) {
                path.moveTo(wCenter + x, hCenter - y);
            } else {
                path.lineTo(wCenter + x, hCenter - y);
            }
        }
        g2d.draw(path);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        float randomWidth = 1.0f + random.nextInt(5);
        graphStroke = new BasicStroke(randomWidth);
        float dash = 1 + random.nextInt(10);
        float[] dashPattern = {dash, dash};
            graphStroke = new BasicStroke(randomWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f, dashPattern, 0.0f);

        graphColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}