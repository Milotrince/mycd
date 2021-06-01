import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class MyCd {

    public static String myCd(String fromDir, String toDir) {
        String path = fromDir;

        if (isAbsolutePath(toDir)) {
            return normalizePath(toDir);
        }

        for (String d : toDir.split("/")) {
            if (d.equals("..")) {
                path = removeLastDir(path);
            } else if (dirIsValid(d)) {
                path += "/" + d;
            } else if (!staySameDirectory(d)) {
                return getErrorMessage(toDir);
            }
        }

        return normalizePath(path);
    }

    public static String cheapMyCd(String fromDir, String toDir) {
        File fromFile = new File(fromDir);
        File toFile = new File(fromFile, toDir);
        try {
            return toFile.getCanonicalPath();
        } catch (IOException ex) {
            return getErrorMessage(toDir);
        }
    }

    private static boolean isAbsolutePath(String path) {
        return path.startsWith("/");
    }

    private static boolean staySameDirectory(String d) {
        return d.equals(".") || d.equals("");
    }

    private static String getErrorMessage(String toDir) {
        return toDir + ": No such file or directory";
    }

    private static boolean dirIsValid(String d) {
        return d.matches("[A-Za-z0-9]+");
    }

    private static String removeLastDir(String path) {
        String[] temp = path.split("/");
        temp = Arrays.copyOf(temp, temp.length-1);
        return String.join("/", temp);
    }

    private static String normalizePath(String path) {
        path = path.replaceAll("/+", "/");
        return (path.startsWith("/") ? "" : "/") + path;
    }

}
