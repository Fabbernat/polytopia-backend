package console.app;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;

public class DesktopApp {

    private static final int ROWS = 16;
    private static final int COLS = 16;

    public DesktopApp() {
        SwingUtilities.invokeLater(DesktopApp::createAndShowUI);
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Polytopia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel gridPanel = new JPanel(new GridLayout(ROWS, COLS));

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JPanel tile = new JPanel();

                // Alternate colors just as an example
                if ((row + col) % 2 == 0) {
                    tile.setBackground(Color.GREEN);
                } else {
                    tile.setBackground(Color.BLUE);
                }

                tile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridPanel.add(tile);
            }
        }

        frame.add(gridPanel);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
