import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        showWelcomeMessage();

        boolean running = true;

        while (running) {

            showMenu();


            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                System.out.print("Describe your issue: ");
                String issue = scanner.nextLine();

                System.out.print("Enter priority (Low/Medium/High): ");
                String priority = scanner.nextLine();

                displayTicket(name, issue, priority);
            } else if (choice == 2) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option");
            }


        }

        scanner.close();


    }


    public static void showWelcomeMessage() {

        System.out.println("Welcome to the Help Desk Ticket System!");

    }

    public static void showMenu() {
        System.out.println("1. Create a ticket");
        System.out.println("2. Exit");

    }

    public static void displayTicket(String name, String issue, String priority) {
        System.out.println("\n-- TICKET DETAILS ---");
        System.out.println("User: " + name);
        System.out.println("Issue: " + issue);
        System.out.println("Priority: " + priority);
        System.out.println("-----------------------");
    }
}
