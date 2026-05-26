import java.io.IOException;
import java.nio.file.*;

public class FileStorage {

    public void saveFile(String sourcePath, String destPath) throws IOException {

        Path targetPath = Paths.get(destPath);

        // create parent folder (IMPORTANT FIX)
        Files.createDirectories(targetPath.getParent());

        Files.copy(
            Paths.get(sourcePath),
            targetPath,
            StandardCopyOption.REPLACE_EXISTING
        );
    }
}