package console.app;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;  // <-- ide kell!
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
        java.util.List<Point> capitals = new ArrayList<>();

        while (placed < count) {
            int row = random.nextInt(ROWS - 4) + 2; // At least 2 tiles from the edges and from other capitals
            int col = random.nextInt(COLS - 4) + 2;

            JPanel tile = tiles[row][col];

            if (tile.getBackground().equals(LAND) && isFarEnough(row, col, capitals, 2)) {
                tile.setBackground(CAPITAL);
                capitals.add(new Point(row, col));
                placed++;
            }
        }
    }

    private static boolean isFarEnough(int row, int col, java.util.List<Point> capitals, int minDistance) {
        for (Point p : capitals) {
            int dist = Math.abs(p.x - row) + Math.abs(p.y - col); // Manhattan distance
            if (dist < minDistance) {
                return false; // túl közel
            }
        }
        return true; // jó hely
    }

}
