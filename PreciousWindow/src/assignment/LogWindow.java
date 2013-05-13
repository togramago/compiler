package assignment;

import javax.swing.*;
import java.awt.*;

public class LogWindow {
    private final Dimension dim;
    private final JFrame frame;
    private final JTextArea log;

    public LogWindow() {
        dim = Toolkit.getDefaultToolkit().getScreenSize();

        frame = new JFrame("TinyJava Compiler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        log = new JTextArea(30, 60);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        final JScrollPane logScrollPane = new JScrollPane(log);

        frame.add(logScrollPane, BorderLayout.CENTER);
        frame.pack();
    }

    public void show() {
        final int width = (int) ((dim.getWidth() - frame.getWidth()) / 2);
        final int height = (int) ((dim.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(width, height);
        frame.setVisible(true);
    }

    public void addToLog(final StringBuilder logText) {
        log.setText("");
        log.append(logText.toString());
        log.setCaretPosition(log.getDocument().getLength());
    }
}
