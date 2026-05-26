import java.time.LocalDateTime;

public class Version {

    int versionNumber;
    String message;
    LocalDateTime timestamp;
    String filePath;

    public Version(int versionNumber, String message, String filePath) {
        this.versionNumber = versionNumber;
        this.message = message;
        this.filePath = filePath;
        this.timestamp = LocalDateTime.now();
    }
}