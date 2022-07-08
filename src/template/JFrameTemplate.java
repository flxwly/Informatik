package template;

import javax.swing.*;
import java.awt.*;

public class JFrameTemplate extends JFrame {

    public JFrameTemplate() {
        // Frame-Initialisierung
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 300;
        int frameHeight = 300;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setResizable(false);
        getContentPane().setLayout(null);
        setVisible(true);

        addComponents(getContentPane());

    } // end of public DynErstellungFrame

    private void addComponents(Container cp) {

    }

    public static void main(String[] args) {
        new JFrameTemplate();
    }
}
