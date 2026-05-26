import java.util.*;
import java.io.IOException;

public class VersionManager {

    private int version = 0;
    private List<Version> history = new ArrayList<>();
    private FileStorage storage = new FileStorage();

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
}