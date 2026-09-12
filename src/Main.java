import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Ticket> tickets = new ArrayList<>();

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

                String priority;

                while (true) {
                    System.out.print("Enter priority (Low/Medium/High): ");
                    priority = scanner.nextLine();

                    if (priority.equalsIgnoreCase("Low") || priority.equalsIgnoreCase("Medium")
                            || priority.equalsIgnoreCase("High")) {
                        break;
                    }
                    System.out.println("Invalid priority. Please enter Low, Medium, or High");
                }

                Ticket ticket = new Ticket(name, issue, priority);
                tickets.add(ticket);

                System.out.println("Ticket created successfully!");
                ticket.display();

            } else if (choice == 2) {
                if (tickets.isEmpty()) {
                    System.out.println("No tickets have been created.");
                } else {
                    System.out.println("\n--- ALL TICKETS ---");

                    // Display every ticket sorted in the list
                    for (Ticket ticket : tickets) {
                        ticket.display();
                    }
                }


            } else if (choice == 3) {
                System.out.print("Enter the ticket ID to close: ");
                int idToClose = scanner.nextInt();
                scanner.nextLine();

                boolean found = false;

                for (Ticket ticket : tickets) {
                    if (ticket.getId() == idToClose) {
                        ticket.close();
                        found = true;
                        System.out.println("Ticket " + idToClose + " closed successfully.");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Ticket ID not found.");
                }

            } else if (choice == 4) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option.");
            }


        }

        scanner.close();


    }


    public static void showWelcomeMessage() {

        System.out.println("Welcome to the Help Desk Ticket System!");

    }

    public static void showMenu() {
        System.out.println("\n1. Create a ticket");
        System.out.println("2. View all tickets");
        System.out.println("3. Close a ticket");
        System.out.println("4. Exit");

    }

}
