package assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import assignment.Driver;

/**
 * GUI management
 *
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 */
public class Window {

    private final Dimension dim;
    private final JFrame frame;
    private final JTextArea log;
    private final JButton printSymbolTableButton;
    private final JButton printASTButton;
    private final JButton printInstructionsButton;
    private final JButton recompileButton;

    private final Driver driver;
    private boolean setDriver;

    private final ActionListener openListener = new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent arg0) {
            final JFileChooser fileopen = new JFileChooser();
            fileopen.setCurrentDirectory(new File("."));

            final FileFilter filter = new FileNameExtensionFilter("java files",
                    "java");
            fileopen.setAcceptAllFileFilterUsed(false);
            fileopen.setFileFilter(filter);

            final int ret = fileopen.showDialog(null, "Open file");
            if (ret == JFileChooser.APPROVE_OPTION) {
                setDriver = true;
                final File file = fileopen.getSelectedFile();
                setupDriver(file.getAbsolutePath());
                frame.setTitle("Compiling " + file.getAbsolutePath());
                compileFile();
                printASTButton.setEnabled(true);
                printInstructionsButton.setEnabled(driver
                        .canGenerateInstructions());
                printSymbolTableButton.setEnabled(true);
                recompileButton.setEnabled(true);
            }

        }
    };

    private final ActionListener printSymbolTableListener = new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent arg0) {
            if (setDriver) {
                log.append(driver.printSymbolTable());
                log.setCaretPosition(log.getDocument().getLength());
            }
        }
    };

    private final ActionListener printASTListener = new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent arg0) {
            if (setDriver) {
                log.append(driver.printTree());
                log.setCaretPosition(log.getDocument().getLength());
            }
        }
    };

    private final ActionListener printInstructionsListener = new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent arg0) {
            if (setDriver) {
                log.append(driver.printInstructions());
                log.setCaretPosition(log.getDocument().getLength());
            }
        }
    };

    private final ActionListener recompileListener = new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent arg0) {
            if (setDriver) {
                driver.compile();
                log.append(driver.getLog());
                log.setCaretPosition(log.getDocument().getLength());
            }
        }
    };

    public Window() {
        driver = new Driver();
        setDriver = false;

        dim = Toolkit.getDefaultToolkit().getScreenSize();

        frame = new JFrame("TinyJava Compiler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        log = new JTextArea(30, 60);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        final JScrollPane logScrollPane = new JScrollPane(log);

        final JButton openButton = new JButton("Open...");
        openButton.addActionListener(openListener);
        printASTButton = new JButton("AS-Tree");
        printASTButton.addActionListener(printASTListener);
        printASTButton.setEnabled(false);
        printSymbolTableButton = new JButton("Symbol Table");
        printSymbolTableButton.addActionListener(printSymbolTableListener);
        printSymbolTableButton.setEnabled(false);
        printInstructionsButton = new JButton("Instructions");
        printInstructionsButton.addActionListener(printInstructionsListener);
        printInstructionsButton.setEnabled(false);
        recompileButton = new JButton("Recompile");
        recompileButton.addActionListener(recompileListener);
        recompileButton.setEnabled(false);

        final JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(printASTButton);
        buttonPanel.add(printSymbolTableButton);
        buttonPanel.add(printInstructionsButton);
        buttonPanel.add(recompileButton);

        frame.add(buttonPanel, BorderLayout.PAGE_START);
        frame.add(logScrollPane, BorderLayout.CENTER);
        frame.pack();

    }

    public void show() {
        final int width = (int) ((dim.getWidth() - frame.getWidth()) / 2);
        final int height = (int) ((dim.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(width, height);
        frame.setVisible(true);
    }

    private void setupDriver(final String fileName) {
        driver.setFile(fileName);
    }

    private void compileFile() {
        log.setText("");
        driver.compile();
        log.append(driver.getLog());
        log.setCaretPosition(log.getDocument().getLength());
    }

    public static void main(final String[] args) {
        new Window().show();
    }
}
