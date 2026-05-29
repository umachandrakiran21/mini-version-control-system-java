import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DiffManager {

    public void compareVersions(int v1,
                                int v2) throws IOException {

        String baseDir =
                System.getProperty("user.dir");

        String file1 =
                baseDir + "\\..\\storage\\v"
                        + v1 + ".txt";

        String file2 =
                baseDir + "\\..\\storage\\v"
                        + v2 + ".txt";

        // READ BOTH FILES
        List<String> lines1 =
                Files.readAllLines(Paths.get(file1));

        List<String> lines2 =
                Files.readAllLines(Paths.get(file2));

        // FIND MAX LINES
        int max =
                Math.max(lines1.size(),
                         lines2.size());

        System.out.println(
                "\n===== VERSION DIFFERENCE ====="
        );

        // COMPARE LINE BY LINE
        for (int i = 0; i < max; i++) {

            String l1 =
                    (i < lines1.size())
                    ? lines1.get(i)
                    : "";

            String l2 =
                    (i < lines2.size())
                    ? lines2.get(i)
                    : "";

            // CHECK DIFFERENCE
            if (!l1.equals(l2)) {

                System.out.println(
                        "\nLine " + (i + 1)
                );

                System.out.println(
                        "v" + v1 + " -> " + l1
                );

                System.out.println(
                        "v" + v2 + " -> " + l2
                );
            }
        }
    }
}