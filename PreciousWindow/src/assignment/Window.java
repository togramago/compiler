package assignment;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * GUI management
 *
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 */
public class Window implements ActionListener {

    public static final String FILE = "File";
    public static final String OPEN = "Open...";
    public static final String QUIT = "Quit";
    public static final String RUN = "Run";
    public static final String COMPILE = "Compile";
    public static final String BUILD = "Build";
    public static final String SHOW = "Show";
    public static final String SYMBOL_TABLE = "Symbol table";
    public static final String INSTRUCTIONS = "Instructions";
    public static final String ABSTRACT_SYNTAX_TREE = "Abstract syntax tree";
    private final LogWindow frame;
    private final Driver driver;

    public Window() {
        driver = new Driver();

        // clean log window
        frame = new LogWindow("MiniJava Compiler");

        // add menu
        frame.add(createMenuBar(), BorderLayout.PAGE_START);
        frame.pack();

    }

    private JMenuBar createMenuBar() {
        final JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0x46801E));

        final JMenu menuFile = new JMenu(FILE);
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menuFile);
        menuFile.setOpaque(false);

        final JMenuItem fileOpen = new JMenuItem(OPEN,
                KeyEvent.VK_O);
        fileOpen.setActionCommand(OPEN);
        fileOpen.addActionListener(this);
        menuFile.add(fileOpen);
        menuFile.addSeparator();

        final JMenuItem fileQuit = new JMenuItem(QUIT,
                KeyEvent.VK_Q);
        fileQuit.setActionCommand(QUIT);
        fileQuit.addActionListener(this);
        menuFile.add(fileQuit);

        final JMenu menuRun = new JMenu(RUN);
        menuRun.setMnemonic(KeyEvent.VK_R);
        menuBar.add(menuRun);
        menuRun.setOpaque(false);

        final JMenuItem runCompile = new JMenuItem(COMPILE,
                KeyEvent.VK_C);
        runCompile.setActionCommand(COMPILE);
        runCompile.addActionListener(this);
        menuRun.add(runCompile);
        menuRun.addSeparator();

        final JMenuItem runBuild = new JMenuItem(BUILD,
                KeyEvent.VK_B);
        runBuild.setActionCommand(BUILD);
        runBuild.addActionListener(this);
        menuRun.add(runBuild);

        final JMenu menuShow = new JMenu(SHOW);
        menuShow.setMnemonic(KeyEvent.VK_S);
        menuBar.add(menuShow);
        menuShow.setOpaque(false);

        final JMenuItem showSymbolTable = new JMenuItem(SYMBOL_TABLE,
                KeyEvent.VK_S);
        showSymbolTable.setActionCommand(SYMBOL_TABLE);
        showSymbolTable.addActionListener(this);
        menuShow.add(showSymbolTable);
        menuShow.addSeparator();

        final JMenuItem showInstructions = new JMenuItem(INSTRUCTIONS,
                KeyEvent.VK_I);
        showInstructions.setActionCommand(INSTRUCTIONS);
        showInstructions.addActionListener(this);
        menuShow.add(showInstructions);
        menuShow.addSeparator();

        final JMenuItem showAST = new JMenuItem(ABSTRACT_SYNTAX_TREE,
                KeyEvent.VK_A);
        showAST.setActionCommand(ABSTRACT_SYNTAX_TREE);
        showAST.addActionListener(this);
        menuShow.add(showAST);

        return menuBar;
    }

    /**
     * show the form
     */
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

    /**
     * All action listeners for the main form
     *
     * @param e performed action on form
     */
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
                final File file = fileChooser.getSelectedFile();
                setupDriver(file.getAbsolutePath());
                frame.setTitle("Compiling " + file.getAbsolutePath());
                compileFile(); //TODO: DOES NOT COMPILE!
            }
        }
        if (QUIT.equals(action)) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
        if (COMPILE.equals(action)) {

        }
        if (BUILD.equals(action)) {

        }
        if (SYMBOL_TABLE.equals(action)) {
            LogWindow symbolTableLog = new LogWindow("Print symbol table");
            symbolTableLog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            symbolTableLog.addToLog(driver.printSymbolTable());
            symbolTableLog.view();
        }
        if (INSTRUCTIONS.equals(action)) {
            LogWindow instructionLog = new LogWindow("Print instructions");
            instructionLog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            instructionLog.addToLog(driver.printInstructions());
            instructionLog.view();
        }
        if (ABSTRACT_SYNTAX_TREE.equals(action)) {
            LogWindow syntaxTreeLog = new LogWindow("Print abstract syntax tree");
            syntaxTreeLog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            syntaxTreeLog.addToLog(driver.printTree());
            syntaxTreeLog.view();
        }
    }
}
