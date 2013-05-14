package assignment.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import assignment.Driver;
import assignment.instruction.ClassInstruction;

/**
 * Generate *.tjc-file with list of *.tjp-file names
 *
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 */
public class ClassRepository implements Serializable {

    private static final long serialVersionUID = 1863262272546990821L;
    private List<String> files;
    private String mainName;
    private final StringBuilder log;

    public ClassRepository(final String mainName, final StringBuilder log) {
        files = new ArrayList<String>();
        this.log = log;
        this.mainName = mainName;
    }

    public ClassRepository(final File repoFile, final StringBuilder log) {
        files = new ArrayList<String>();
        this.log = log;
        this.mainName = repoFile.getName();
        PathManager.getInstance().addRepositoryFolder(repoFile.getName());
        read(repoFile);

    }

    public void addClassFile(final ClassFile classfile) {
        files.add(classfile.getFileName());
    }

    /**
     * Set name of main class to *.tjc-file
     *
     * @param mainName main class name
     */
    public void setMainName(final String mainName) {
        this.mainName = mainName;
    }

    /**
     * Create *.tjr-file. Save contents of repository.
     */
    public void save() {
        try {
            final FileOutputStream fos = new FileOutputStream(PathManager.getInstance().getPath() + mainName + ".tjr");
            final ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(files);
            oos.close();
            fos.close();
        } catch (IOException e) {
            log.append(Arrays.toString(e.getStackTrace()));
            log.append(e.getMessage());
        }
    }

    /**
     * Read class repository *.tjr-file.
     *
     * @param file of repository
     */
    @SuppressWarnings("unchecked")
    public final void read(final File file) {
        try {
            final FileInputStream fis = new FileInputStream(file);
            final ObjectInputStream ois = new ObjectInputStream(fis);
            final Object read = ois.readObject();
            ois.close();
            fis.close();
            if (read instanceof List<?>) {
                files = (List<String>) read;
            } else {
                throw new IOException();
            }

        } catch (IOException e) {
            log.append(Arrays.toString(e.getStackTrace()));
            log.append(e.getMessage());
        } catch (ClassNotFoundException ce) {
            log.append(Arrays.toString(ce.getStackTrace()));
            log.append(ce.getMessage());
        }
    }

    public List<ClassInstruction> getClassInstructions() {
        final List<ClassInstruction> instructions = new ArrayList<ClassInstruction>();
        for (final String file : files) {
            final ClassFile classfile = new ClassFile(new File(file), log);
            instructions.add(classfile.getClassInstruction());
        }
        return instructions;
    }
}
