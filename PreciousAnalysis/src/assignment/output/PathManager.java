package assignment.output;

import java.io.File;

/**
 * Manages output path for internal files .tjr and .tjc
 * User: margot
 * Date: 14.05.13
 * Time: 20:09
 * To change this template use File | Settings | File Templates.
 */
public class PathManager {
    private static String path;

    private static PathManager instance = null;
    private PathManager() {

    }
    public static PathManager getInstance() {
        if(instance == null) {
            instance = new PathManager();
        }
        return instance;
    }

    /**
     * Sets new output path
     * <p/>
     * Maybe broken.
     *
     * @param outputString path to location
     */
    public void setPath(final String outputString) {
        boolean hasNoOutput = (outputString == null);
        if   (!hasNoOutput) {
            final File file = new File(outputString);
            if (file.exists() && file.isDirectory()) {
               path = outputString;
            } else {
                hasNoOutput = true;
            }
        }
        if (hasNoOutput) {
            final File theDir = new File("repository/");
            if (!theDir.exists()) {
                theDir.mkdir();
            }

            path = theDir.getAbsolutePath()+ File.separator ;
            System.out.println("ERROR! Not valid path. Default path set.");
        }
        System.out.println("Path set to: " + path);
    }

    public void addRepositoryFolder(final String folderName) {
        path += folderName + File.separator;
    }

    public String getPath() {
        return path;
    }

}
