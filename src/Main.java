import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        VersionManager vm = new VersionManager();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== MINI VERSION CONTROL SYSTEM =====");
            System.out.println("1. Commit File");
            System.out.println("2. Show History");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter file path: ");
                    sc.nextLine(); // clear buffer
String path = sc.nextLine();

                    System.out.print("Enter commit message: ");
                    sc.nextLine();
                    String msg = sc.nextLine();

                    vm.commit(path, msg);
                    break;

                case 2:
                    vm.showHistory();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}