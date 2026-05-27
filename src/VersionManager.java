import java.util.*;
import java.io.IOException;
import java.nio.file.*;
import java.io.File;

public class VersionManager {

    private int version = 0;
    private List<Version> history = new ArrayList<>();
    private FileStorage storage = new FileStorage();


public VersionManager() {

    File folder = new File("../storage");

    File[] files = folder.listFiles();

    if (files != null) {
        version = files.length;
    }
}
    // COMMIT FUNCTION (MOST IMPORTANT)
    public void commit(String filePath, String message) throws IOException {

        version++;

        String baseDir = System.getProperty("user.dir");

String backupPath = baseDir + "\\..\\storage\\v" + version + ".txt";

        // STEP 1: COPY FILE
        storage.saveFile(filePath, backupPath);

        // STEP 2: SAVE METADATA
        Version v = new Version(version, message, backupPath);
        history.add(v);

        System.out.println("✅ Committed Version: v" + version);
    }

    // SHOW HISTORY
    public void showHistory() {

        if (history.isEmpty()) {
            System.out.println("No commits yet!");
            return;
        }

        for (Version v : history) {
            System.out.println(
                "v" + v.versionNumber +
                " | " + v.message +
                " | " + v.timestamp
            );
        }
    }
    public void restore(int versionNumber, String targetFilePath) throws Exception {

    String baseDir = System.getProperty("user.dir");

    // locate stored version file
    String sourcePath = baseDir + "\\..\\storage\\v" + versionNumber + ".txt";

    Path source = Paths.get(sourcePath);
    Path target = Paths.get(targetFilePath);

    // check version exists
    if (!Files.exists(source)) {
        System.out.println("❌ Version not found!");
        return;
    }

    // copy old version back
    Files.copy(
            source,
            target,
            StandardCopyOption.REPLACE_EXISTING
    );

    System.out.println("✅ Restored Version v" + versionNumber);
}
}