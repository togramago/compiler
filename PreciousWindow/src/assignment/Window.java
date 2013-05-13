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
        final JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0x46801E));

        final JMenu menuFile = new JMenu("File");
        menuFile.setBackground(new Color(0x46801E));
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menuFile);
        menuFile.setOpaque(false);

        final JMenuItem fileOpen = new JMenuItem("Open...",
                KeyEvent.VK_O);
        menuFile.add(fileOpen);
        menuFile.addSeparator();

        final JMenuItem fileQuit = new JMenuItem("Quit",
                KeyEvent.VK_Q);
        menuFile.add(fileQuit);

        final JMenu menuRun = new JMenu("Run");
        menuRun.setBackground(new Color(0x46801E));
        menuRun.setMnemonic(KeyEvent.VK_R);
        menuBar.add(menuRun);
        menuRun.setOpaque(false);

        final JMenuItem runCompile = new JMenuItem("Compile",
                KeyEvent.VK_C);
        menuRun.add(runCompile);
        menuRun.addSeparator();

        final JMenuItem runBuild = new JMenuItem("Build",
                KeyEvent.VK_B);
        menuRun.add(runBuild);

        final JMenu menuShow = new JMenu("Show");
        menuShow.setBackground(new Color(0x46801E));
        menuShow.setMnemonic(KeyEvent.VK_S);
        menuBar.add(menuShow);
        menuShow.setOpaque(false);

        final JMenuItem showSymbolTable = new JMenuItem("Symbol table",
                KeyEvent.VK_S);
        menuShow.add(showSymbolTable);
        menuShow.addSeparator();

        final JMenuItem showInstructions = new JMenuItem("Instructions",
                KeyEvent.VK_I);
        menuShow.add(showInstructions);
        menuShow.addSeparator();

        final JMenuItem showAST = new JMenuItem("Abstract syntax tree",
                KeyEvent.VK_A);
        menuShow.add(showAST);

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
