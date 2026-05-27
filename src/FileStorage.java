import java.io.IOException;
import java.nio.file.*;

public class FileStorage {

    public void saveFile(String sourcePath, String destPath) throws IOException {

        Path source = Paths.get(sourcePath);
        Path target = Paths.get(destPath);

        // create only storage folder
        Files.createDirectories(target.getParent());

        System.out.println("SOURCE: " + source);
        System.out.println("TARGET: " + target);

        Files.copy(
                source,
                target,
                StandardCopyOption.REPLACE_EXISTING
        );
    }
}