import java.util.Arrays;

public class MyCd {

    public static String myCd(String fromDir, String toDir) {
        String path = fromDir;

        if (isAbsolutePath(toDir)) {
            path = "/";
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
        if (temp.length > 0) {
            temp = Arrays.copyOf(temp, temp.length-1);
            return String.join("/", temp);
        }
        return path;
    }

    private static String normalizePath(String path) {
        path = path.replaceAll("/+", "/");
        return (path.startsWith("/") ? "" : "/") + path;
    }

}
