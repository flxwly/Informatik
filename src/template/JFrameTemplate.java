package template;

import javax.swing.*;
import java.awt.*;

public abstract class JFrameTemplate extends JFrame {

    static final int frameWidth = 300;
    static final int frameHeight = 300;

    public JFrameTemplate() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(frameWidth, frameHeight);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        setResizable(false);
        getContentPane().setLayout(null);
        addComponents(getContentPane());
        setVisible(true);
    }

    public abstract void addComponents(Container cp);
}
