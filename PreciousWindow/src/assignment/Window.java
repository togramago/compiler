package assignment;

import assignment.execution.Interpreter;

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
 */
public class Window implements ActionListener {

    private static final String FILE = "File";
    private static final String OPEN = "Open...";
    private static final String CLEAR_LOG = "Clear log";
    private static final String QUIT = "Quit";
    private static final String RUN = "Run";
    private static final String EXECUTE = "Execute";
    private static final String COMPILE = "Compile";
    private static final String BUILD = "Build";
    private static final String SHOW = "Show";
    private static final String SYMBOL_TABLE = "Symbol table";
    private static final String INSTRUCTIONS = "Instructions";
    private static final String ABSTRACT_SYNTAX_TREE = "Abstract syntax tree";

    private static final String TITLE = "MiniJava Compiler";
    private static final String COMPILING = "Compiling ";
    private static final String EXECUTING = "Executing ";

    private final LogWindow frame;
    private final Driver driver;
    private JMenu menuShow;
    private JMenuItem runExecute;


    private Window() {
        driver = new Driver();

        // clean log window
        frame = new LogWindow(TITLE);

        // add menu
        frame.add(createMenuBar(), BorderLayout.PAGE_START);
        frame.pack();

    }

    /**
     * create main menu
     *
     * @return created menu
     */
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

        final JMenuItem fileClearLog = new JMenuItem(CLEAR_LOG,
                KeyEvent.VK_L);
        fileClearLog.setActionCommand(CLEAR_LOG);
        fileClearLog.addActionListener(this);
        menuFile.add(fileClearLog);
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
        menuRun.addSeparator();

        runExecute = new JMenuItem(EXECUTE,
                KeyEvent.VK_B);
        runExecute.setActionCommand(EXECUTE);
        runExecute.addActionListener(this);
        runExecute.setEnabled(false);
        menuRun.add(runExecute);

        menuShow = new JMenu(SHOW);
        menuShow.setMnemonic(KeyEvent.VK_S);
        menuBar.add(menuShow);
        menuShow.setEnabled(false);
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
    void show() {
        frame.view();
    }

    /**
     * send file to driver
     *
     * @param fileName of test program
     */
    private void setupDriver(final String fileName) {
        driver.setFile(fileName);
    }

    /**
     * compile test program
     */
    private boolean compileFile(final File file) {
        frame.setTitle(COMPILING + (file == null ? "" : file.getAbsolutePath()));
        driver.compile();
        frame.addToLog(driver.getLog());
        boolean valid = driver.isValidBuild();
        enableMenu(valid);
        return valid;
    }

    public static void main(final String[] args) {
        new Window().show();
    }

    private void enableMenu(final boolean enabled) {
        menuShow.setEnabled(enabled); // resets the show button for next compile
        runExecute.setEnabled(enabled);
    }

    /**
     * All action listeners for the main form
     *
     * @param e performed action on form
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        final String action = e.getActionCommand();
        File chosenFile = null;
        if (OPEN.equals(action)) {
            enableMenu(false);
            final JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            final FileFilter filter = new FileNameExtensionFilter("java files",
                    "java");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setFileFilter(filter);

            final int ret = fileChooser.showDialog(null, "Open file");
            if (ret == JFileChooser.APPROVE_OPTION) {
                chosenFile = fileChooser.getSelectedFile();
                setupDriver(chosenFile.getAbsolutePath());
                compileFile(chosenFile);
            }
        }
        if (CLEAR_LOG.equals(action)){
            frame.clearLog();
        }
        if (QUIT.equals(action)) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
        if (COMPILE.equals(action)) {
            compileFile(chosenFile);
        }
        if (BUILD.equals(action)) {

            if (compileFile(chosenFile)) {
                frame.clearLog();
                execute();
            }
        }
        if (EXECUTE.equals(action)) {
            frame.clearLog();
            execute();
        }
        if (SYMBOL_TABLE.equals(action)) {
            frame.setTitle(TITLE);
            LogWindow symbolTableLog = new LogWindow("Print symbol table");
            symbolTableLog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            symbolTableLog.addToLog(driver.printSymbolTable());
            symbolTableLog.view();
        }
        if (INSTRUCTIONS.equals(action)) {
            frame.setTitle(TITLE);
            LogWindow instructionLog = new LogWindow("Print instructions");
            instructionLog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            instructionLog.addToLog(driver.printInstructions());
            instructionLog.view();
        }
        if (ABSTRACT_SYNTAX_TREE.equals(action)) {
            frame.setTitle(TITLE);
            LogWindow syntaxTreeLog = new LogWindow("Print abstract syntax tree");
            syntaxTreeLog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            syntaxTreeLog.addToLog(driver.printTree());
            syntaxTreeLog.view();
        }
    }

    private void execute() {
        try {
            frame.setTitle(TITLE + " - " + EXECUTING);
            final Interpreter interpreter = new Interpreter(driver.getClassRepositoryPath());

            interpreter.execute();
            frame.addToLog(interpreter.showLog());
        } catch (Exception e) {
            frame.addToLog("\n\nExecution failed.\n\n\n");
        }
    }
}
