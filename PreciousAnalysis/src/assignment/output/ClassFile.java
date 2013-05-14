package assignment.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

import assignment.Driver;
import assignment.instruction.ClassInstruction;

/**
 * Object to serialize class file to be saved.
 */
public class ClassFile implements Serializable {
    private static final long serialVersionUID = -7508666799814289076L;

    /**
     * Class to write
     */
    private ClassInstruction record;

    private final StringBuilder log;
    private final static String FILE_EXTENSION = ".tjc";

    public ClassFile(final ClassInstruction record, final StringBuilder log) {
        this.record = record;
        this.log = log;
    }

    public ClassFile(final File file, final StringBuilder log) {
        this.log = log;
        readFromFile(file);
    }

    /**
     * Saves serialized ClassFile object to *.tjc-file file
     */
    public void save() {
        if (record != null) {
            try {
                final FileOutputStream fos = new FileOutputStream(getFileName());
                final ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(record);
                oos.close();
                fos.close();
            } catch (IOException e) {
                log.append(Arrays.toString(e.getStackTrace()));
                log.append(e.getMessage());
            }
        }
    }

    /**
     * Reads ClassInstruction from file
     *
     * @param file where instructions are written
     */
    public final void readFromFile(final File file) {
        try {
            final FileInputStream fis = new FileInputStream(file);
            final ObjectInputStream ois = new ObjectInputStream(fis);
            final Object read = ois.readObject();
            ois.close();
            fis.close();
            if (read instanceof ClassInstruction) {
                record = (ClassInstruction) read;
            }
        } catch (IOException e) {
            log.append(Arrays.toString(e.getStackTrace()));
            log.append(e.getMessage());
        } catch (ClassNotFoundException ce) {
            log.append(Arrays.toString(ce.getStackTrace()));
            log.append(ce.getMessage());
        }
    }

    /**
     * @return name of generated file
     */
    public String getFileName() {
        return Driver.outputString() + record.getName() + FILE_EXTENSION;
    }

    public ClassInstruction getClassInstruction() {
        return record;
    }

}
