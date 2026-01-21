package console.app;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;

public class DesktopApp {

    private static final int ROWS = 16;
    private static final int COLS = 16;
    private static final double SCALE = 0.15; // lower = larger regions

    public DesktopApp() {
        SwingUtilities.invokeLater(DesktopApp::createAndShowUI);
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Polytopia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel gridPanel = new JPanel(new GridLayout(ROWS, COLS));
        PerlinNoise noise = new PerlinNoise(System.currentTimeMillis());

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JPanel tile = new JPanel();

                double value = noise.noise(row * SCALE, col * SCALE);
                double normalized = (value + 1) / 2.0;

                if (normalized > 0.4) {
                    tile.setBackground(Color.GREEN); // land
                } else {
                    tile.setBackground(Color.BLUE);  // water
                }

                tile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridPanel.add(tile);
            }
        }

        frame.add(gridPanel);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
