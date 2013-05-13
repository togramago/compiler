package assignment;

import javax.swing.*;
import java.awt.*;

public class LogWindow extends JFrame{
    private final Dimension dim;
    private final JTextArea log;

    public LogWindow() {
        dim = Toolkit.getDefaultToolkit().getScreenSize();


       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        log = new JTextArea(30, 60);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        final JScrollPane logScrollPane = new JScrollPane(log);

        add(logScrollPane, BorderLayout.CENTER);
        pack();
    }

    public void view() {
        final int width = (int) ((dim.getWidth() - getWidth()) / 2);
        final int height = (int) ((dim.getHeight() - getHeight()) / 2);
        setLocation(width, height);
        setVisible(true);
    }

    public void addToLog(final String logText) {
        log.setText("");
        log.append(logText);
        log.setCaretPosition(log.getDocument().getLength());
    }
}
