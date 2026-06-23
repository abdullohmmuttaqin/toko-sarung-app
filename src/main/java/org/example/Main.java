package org.example;

import org.example.view.TokoSarungFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TokoSarungFrame frame = new TokoSarungFrame();
            frame.setVisible(true);
        });
    }
}