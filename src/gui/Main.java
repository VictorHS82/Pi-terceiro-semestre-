package gui;

import javax.swing.SwingUtilities;

/**
 * Classe para incialização da interface gráfica
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
