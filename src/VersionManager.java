import java.util.*;
import java.io.IOException;
import java.nio.file.*;
import java.io.File;

public class VersionManager {

    private int version = 0;

    private List<Version> history = new ArrayList<>();

    private FileStorage storage = new FileStorage();

    private HistoryManager historyManager =
        new HistoryManager();
    // CONSTRUCTOR
    public VersionManager() {

        File folder = new File("../storage");

        File[] files = folder.listFiles();

        if (files != null) {
            version = files.length;
        }

        System.out.println("Existing Versions = " + version);
    }

    
    // COMMIT FUNCTION
    public void commit(String filePath, String message) throws IOException {

        Path source = Paths.get(filePath);

if (!Files.exists(source)) {

    System.out.println("❌ File not found!");

    return;
}
        System.out.println("Current Version Before Increment = " + version);

        version++;

        System.out.println("Current Version After Increment = " + version);

        String baseDir = System.getProperty("user.dir");

        String backupPath =
                baseDir + "\\..\\storage\\v" + version + ".txt";

        // COPY FILE TO STORAGE
        storage.saveFile(filePath, backupPath);

        // STORE METADATA
        Version v = new Version(version, message, backupPath);

        history.add(v);
        historyManager.saveHistory(version, message);

        System.out.println("✅ Committed Version: v" + version);
    }

    // SHOW HISTORY
  public void showHistory() throws IOException {

    historyManager.showHistory();
}

    // RESTORE VERSION
    public void restore(int versionNumber,
                        String targetFilePath) throws Exception {

        String baseDir = System.getProperty("user.dir");

        String sourcePath =
                baseDir + "\\..\\storage\\v"
                        + versionNumber + ".txt";

        Path source = Paths.get(sourcePath);

        Path target = Paths.get(targetFilePath);

        // CHECK VERSION EXISTS
        if (!Files.exists(source)) {

            System.out.println("❌ Version not found!");

            return;
        }

        // COPY OLD VERSION BACK
        Files.copy(
                source,
                target,
                StandardCopyOption.REPLACE_EXISTING
        );

        System.out.println("✅ Restored Version v"
                + versionNumber);
    }
}
 
