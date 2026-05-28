import java.io.*;
import java.time.LocalDateTime;

public class HistoryManager {

    private final String HISTORY_FILE =
            "../storage/history.txt";

    // SAVE COMMIT HISTORY
    public void saveHistory(int version,
                            String message) throws IOException {

        FileWriter fw =
                new FileWriter(HISTORY_FILE, true);

        BufferedWriter bw =
                new BufferedWriter(fw);

        bw.write(
                "v" + version
                + " | "
                + message
                + " | "
                + LocalDateTime.now()
        );

        bw.newLine();

        bw.close();
    }

    // SHOW HISTORY
    public void showHistory() throws IOException {

        File file = new File(HISTORY_FILE);

        if (!file.exists()) {

            System.out.println("No history found!");

            return;
        }

        BufferedReader br =
                new BufferedReader(
                        new FileReader(file)
                );

        String line;

        while ((line = br.readLine()) != null) {

            System.out.println(line);
        }

        br.close();
    }
}