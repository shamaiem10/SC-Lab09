import java.io.File;
import java.text.DecimalFormat;

public class RecursiveFileSizeCalculator {

    // Constructor
    public RecursiveFileSizeCalculator() {
        // Not needed for static methods
    }

    // Array of file extensions to exclude
    private static final String[] EXCLUDED_EXTENSIONS = {".tmp", ".log"};

    public static void main(String[] args) {
        // Use your folder path here (escaped backslashes)
        File folder = new File("C:\\Users\\shama\\OneDrive\\Desktop\\SPS-INTERNSHIP");

        long totalBytes = getDirectorySize(folder);
        System.out.println("Total folder size: " + totalBytes + " bytes");
        System.out.println("Readable size: " + readableFileSize(totalBytes));
    }

    // Main method to get total directory size
    public static long getDirectorySize(File folder) {
        return traverseFolder(folder);
    }

    // Mutual recursion: traverse folder, call processFile()
    public static long traverseFolder(File folder) {
        long totalSize = 0;

        if (folder == null || !folder.exists() || !folder.isDirectory()) {
            return 0;
        }

        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                totalSize += processFile(f);
            }
        }
        return totalSize;
    }

    // Process individual files or subfolders
    public static long processFile(File f) {
        if (isExcluded(f)) {
            return 0; // skip unwanted files
        }

        if (f.isFile()) {
            return f.length();
        } else if (f.isDirectory()) {
            return traverseFolder(f);
        }
        return 0;
    }

    // Check if file should be excluded
    private static boolean isExcluded(File f) {
        for (String ext : EXCLUDED_EXTENSIONS) {
            if (f.getName().toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }

    // Convert bytes into readable format
    public static String readableFileSize(long size) {
        if (size <= 0) return "0 B";
        final String[] units = {"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#")
                .format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }
}
