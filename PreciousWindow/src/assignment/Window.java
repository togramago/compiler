package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * GUI management
 *
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 */
public class Window {

    private final Dimension dim;
    private final LogWindow frame;
//    private final JButton printSymbolTableButton;
//    private final JButton printASTButton;
//    private final JButton printInstructionsButton;
//    private final JButton recompileButton;

    private final Driver driver;
    private boolean setDriver;

//    private final ActionListener openListener = new ActionListener() {
//
//        @Override
//        public void actionPerformed(final ActionEvent arg0) {
//            final JFileChooser fileopen = new JFileChooser();
//            fileopen.setCurrentDirectory(new File("."));
//
//            final FileFilter filter = new FileNameExtensionFilter("java files",
//                    "java");
//            fileopen.setAcceptAllFileFilterUsed(false);
//            fileopen.setFileFilter(filter);
//
//            final int ret = fileopen.showDialog(null, "Open file");
//            if (ret == JFileChooser.APPROVE_OPTION) {
//                setDriver = true;
//                final File file = fileopen.getSelectedFile();
//                setupDriver(file.getAbsolutePath());
//                frame.setTitle("Compiling " + file.getAbsolutePath());
//                compileFile();
//                printASTButton.setEnabled(true);
//                printInstructionsButton.setEnabled(driver
//                        .canGenerateInstructions());
//                printSymbolTableButton.setEnabled(true);
//                recompileButton.setEnabled(true);
//            }
//
//        }
//    };

//    private final ActionListener printSymbolTableListener = new ActionListener() {
//
//        @Override
//        public void actionPerformed(final ActionEvent arg0) {
//            if (setDriver) {
//                frame.addToLog(driver.printSymbolTable());
//            }
//        }
//    };

//    private final ActionListener printASTListener = new ActionListener() {
//
//        @Override
//        public void actionPerformed(final ActionEvent arg0) {
//            if (setDriver) {
//                frame.addToLog(driver.printTree());
//            }
//        }
//    };

//    private final ActionListener printInstructionsListener = new ActionListener() {
//
//        @Override
//        public void actionPerformed(final ActionEvent arg0) {
//            if (setDriver) {
//                frame.addToLog(driver.printInstructions());
//            }
//        }
//    };

//    private final ActionListener recompileListener = new ActionListener() {
//
//        @Override
//        public void actionPerformed(final ActionEvent arg0) {
//            if (setDriver) {
//                driver.compile();
//                frame.addToLog(driver.getLog());
//            }
//        }
//    };

    public Window() {
        driver = new Driver();
        setDriver = false;

        dim = Toolkit.getDefaultToolkit().getScreenSize();

        frame = new LogWindow();

//        final JButton openButton = new JButton("Open...");
//        openButton.addActionListener(openListener);
//        printASTButton = new JButton("AS-Tree");
//        printASTButton.addActionListener(printASTListener);
//        printASTButton.setEnabled(false);
//        printSymbolTableButton = new JButton("Symbol Table");
//        printSymbolTableButton.addActionListener(printSymbolTableListener);
//        printSymbolTableButton.setEnabled(false);
//        printInstructionsButton = new JButton("Instructions");
//        printInstructionsButton.addActionListener(printInstructionsListener);
//        printInstructionsButton.setEnabled(false);
//        recompileButton = new JButton("Recompile");
//        recompileButton.addActionListener(recompileListener);
//        recompileButton.setEnabled(false);
//
//        final JPanel buttonPanel = new JPanel();
//        buttonPanel.add(openButton);
//        buttonPanel.add(printASTButton);
//        buttonPanel.add(printSymbolTableButton);
//        buttonPanel.add(printInstructionsButton);
//        buttonPanel.add(recompileButton);

//        frame.add(buttonPanel, BorderLayout.PAGE_START);

        frame.add(createMenuBar(), BorderLayout.PAGE_START);
        frame.pack();

    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0x64B62A));

        JMenu menuFile = new JMenu("File");
        menuFile.setBackground(new Color(0x46801E));
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuFile.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menuFile);

        JMenuItem fileOpen = new JMenuItem("Open...",
                KeyEvent.VK_O);
        fileOpen.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menuFile.add(fileOpen);

        menuFile.add(new JPopupMenu.Separator());

        JMenuItem fileQuit = new JMenuItem("Quit",
                KeyEvent.VK_Q);
        fileQuit.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menuFile.add(fileQuit);


        return menuBar;
    }

    public void show() {
        frame.view();
    }

    private void setupDriver(final String fileName) {
        driver.setFile(fileName);
    }

    private void compileFile() {
        frame.addToLog(driver.getLog());
    }

    public static void main(final String[] args) {
        new Window().show();
    }
}
