package console.app;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.util.Random;

public class DesktopApp {

    private static final int ROWS = 16;
    private static final int COLS = 16;
    private static final double SCALE = 0.15; // lower = larger regions

    private static final Color LAND = Color.GREEN;
    private static final Color WATER = Color.BLUE;
    private static final Color CAPITAL = new Color(139, 69, 19); // brown

    private static final JPanel[][] tiles = new JPanel[ROWS][COLS];
    private static final Random random = new Random();

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

                tile.setBackground(normalized > 0.4 ? LAND : WATER);
                tile.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                tiles[row][col] = tile;
                gridPanel.add(tile);
            }
        }

        // 2️⃣ Place tribe capitals AFTER generation
        replaceTilesWithTribeCapitals(4);

        frame.add(gridPanel);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void replaceTilesWithTribeCapitals(int count) {
        int placed = 0;

        while (placed < count) {
            int row = random.nextInt(ROWS - 2) + 1; // avoid borders
            int col = random.nextInt(COLS - 2) + 1;

            JPanel tile = tiles[row][col];

            if (tile.getBackground().equals(LAND)) {
                tile.setBackground(CAPITAL);
                placed++;
            }
        }
        }
}
