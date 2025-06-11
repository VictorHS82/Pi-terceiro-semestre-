package gui;

import javax.swing.SwingUtilities;

/**
 * Maina para iniciair interface gráfica
 */
public class Main {
    /**
     * Classe main para iniciar telas
     * @param args argumento generico
     */
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
