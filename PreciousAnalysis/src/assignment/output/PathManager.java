package assignment.output;

import java.io.File;

/**
 * Manages output path for internal files .tjr and .tjc
 * User: margot
 * Date: 14.05.13
 * Time: 20:09
 */
public class PathManager {
    private static String path;

    private static PathManager instance = null;

    public static PathManager getInstance() {
        if (instance == null) {
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
        if (!hasNoOutput) {
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

            path = theDir.getAbsolutePath() + File.separator;
        }
        System.out.println("Path set to: " + path);
    }

    public String getPath() {
        return path;
    }

}
