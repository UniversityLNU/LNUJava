package com.second;
import java.awt.*;
import javax.swing.*;

public class TrochoidGraph extends JFrame {
    private final DrawingPanel drawingPanel;
    private final JLabel nameLabel;

    public TrochoidGraph() {
        drawingPanel = new DrawingPanel();
        nameLabel = new JLabel("Seniuk - #10");

        setLayout(new BorderLayout());
        add(drawingPanel, BorderLayout.CENTER);
        add(nameLabel, BorderLayout.SOUTH);

        setTitle("Trochoid Graph");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrochoidGraph::new);
    }
}