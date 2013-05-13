package assignment;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * GUI management
 *
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 */
public class Window implements ActionListener {

    public static final String OPEN = "Open";
    public static final String QUIT = "Quit";
    public static final String RUN = "Run";
    public static final String COMPILE = "Compile";
    public static final String BUILD = "Build";
    public static final String SHOW = "Show";
    public static final String SYMBOL_TABLE = "Symbol table";
    public static final String INSTRUCTIONS = "Instructions";
    public static final String ABSTRACT_SYNTAX_TREE = "Abstract syntax tree";
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

    private JMenuBar createMenuBar() {
        final JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0x46801E));

        final JMenu menuFile = new JMenu("File");
        menuFile.setBackground(new Color(0x46801E));
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menuFile);
        menuFile.setOpaque(false);

        final JMenuItem fileOpen = new JMenuItem("Open...",
                KeyEvent.VK_O);
        fileOpen.setActionCommand(OPEN);
        fileOpen.addActionListener(this);
        menuFile.add(fileOpen);
        menuFile.addSeparator();

        final JMenuItem fileQuit = new JMenuItem(QUIT,
                KeyEvent.VK_Q);
        fileQuit.setActionCommand("Quit");
        fileQuit.addActionListener(this);
        menuFile.add(fileQuit);

        final JMenu menuRun = new JMenu(RUN);
        menuRun.setBackground(new Color(0x46801E));
        menuRun.setMnemonic(KeyEvent.VK_R);
        menuBar.add(menuRun);
        menuRun.setOpaque(false);

        final JMenuItem runCompile = new JMenuItem("Compile",
                KeyEvent.VK_C);
        runCompile.setActionCommand(COMPILE);
        runCompile.addActionListener(this);
        menuRun.add(runCompile);
        menuRun.addSeparator();

        final JMenuItem runBuild = new JMenuItem("Build",
                KeyEvent.VK_B);
        runBuild.setActionCommand(BUILD);
        runBuild.addActionListener(this);
        menuRun.add(runBuild);

        final JMenu menuShow = new JMenu(SHOW);
        menuShow.setBackground(new Color(0x46801E));
        menuShow.setMnemonic(KeyEvent.VK_S);
        menuBar.add(menuShow);
        menuShow.setOpaque(false);

        final JMenuItem showSymbolTable = new JMenuItem("Symbol table",
                KeyEvent.VK_S);
        showSymbolTable.setActionCommand(SYMBOL_TABLE);
        showSymbolTable.addActionListener(this);
        menuShow.add(showSymbolTable);
        menuShow.addSeparator();

        final JMenuItem showInstructions = new JMenuItem("Instructions",
                KeyEvent.VK_I);
        showInstructions.setActionCommand(INSTRUCTIONS);
        showInstructions.addActionListener(this);
        menuShow.add(showInstructions);
        menuShow.addSeparator();

        final JMenuItem showAST = new JMenuItem("Abstract syntax tree",
                KeyEvent.VK_A);
        showAST.setActionCommand(ABSTRACT_SYNTAX_TREE);
        showAST.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        final String action = e.getActionCommand();
        if (OPEN.equals(action)) {
            final JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            final FileFilter filter = new FileNameExtensionFilter("java files",
                    "java");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setFileFilter(filter);

            final int ret = fileChooser.showDialog(null, "Open file");
            if (ret == JFileChooser.APPROVE_OPTION) {
                setDriver = true;
                final File file = fileChooser.getSelectedFile();
                setupDriver(file.getAbsolutePath());
                frame.setTitle("Compiling " + file.getAbsolutePath());
                compileFile();
            }
        }
        if (QUIT.equals(action)) {

        }
        if (RUN.equals(action)) {

        }
        if (COMPILE.equals(action)) {

        }
        if (BUILD.equals(action)) {

        }
        if (SHOW.equals(action)) {

        }
        if (SYMBOL_TABLE.equals(action)) {

        }
        if (INSTRUCTIONS.equals(action)) {

        }
        if (ABSTRACT_SYNTAX_TREE.equals(action)) {

        }
    }
}
