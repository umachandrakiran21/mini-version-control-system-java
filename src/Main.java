import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        DiffManager diff =
        new DiffManager();
        VersionManager vm = new VersionManager();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== MINI VERSION CONTROL SYSTEM =====");
System.out.println("1. Commit File");
System.out.println("2. Show History");
System.out.println("3. Restore Version");
System.out.println("4. Compare Versions");
System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
case 1:

    sc.nextLine(); // clear buffer only once

    System.out.print("Enter file path: ");
    String path = sc.nextLine().trim();

    System.out.print("Enter commit message: ");
    String msg = sc.nextLine().trim();

   try {

    vm.commit(path, msg);

} catch (Exception e) {

    System.out.println("❌ Error: " + e.getMessage());

}

    break;

                case 2:
                    vm.showHistory();
                    break;

                    case 3:

    System.out.print("Enter version number: ");
    int v = sc.nextInt();

    sc.nextLine();

    System.out.print("Enter target file path: ");
    String target = sc.nextLine().trim();

    try {

    vm.restore(v, target);

} catch (Exception e) {

    System.out.println("❌ Error: " + e.getMessage());

}

    break;
    case 4:

    System.out.print("Enter first version: ");
    int first = sc.nextInt();

    System.out.print("Enter second version: ");
    int second = sc.nextInt();

    diff.compareVersions(first, second);

    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}