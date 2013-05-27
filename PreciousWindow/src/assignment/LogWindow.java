package assignment;
/**
 * Class adds log to GUI window
 */
import javax.swing.*;
import java.awt.*;

class LogWindow extends JFrame {
    private final Dimension dim;
    private final JTextArea log;

    public LogWindow(String title) {
        this.setTitle(title); //set title to each frame
        dim = Toolkit.getDefaultToolkit().getScreenSize();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        log = new JTextArea(30, 60);
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

    public void clearLog(){
        log.setText("");
        log.setCaretPosition(log.getDocument().getLength());
    }

}
