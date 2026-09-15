import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TicketManager ticketManager = new TicketManager();

        showWelcomeMessage();

        boolean running = true;

        while (running) {

            showMenu();


            System.out.print("Choose an option: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine()); // Reads input and tries to convert it into an integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number");
                continue;
            }

            if (choice == 1) {
                String name = readNonEmptyLine(scanner, "Enter your name: ");

                String issue = readNonEmptyLine(scanner, "Describe your issue: ");

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
                ticketManager.addTicket(ticket);

                System.out.println("Ticket created successfully!");
                ticket.display();

            } else if (choice == 2) {
                ticketManager.displayAllTickets();
            } else if (choice == 3) {
                System.out.print("Enter the ticket ID to close: ");
                int idToClose;
                // if the user types hello instead of a number, the program will show an error
                // and return to the menu instead of crashing.
                try {
                    idToClose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID. Please enter a number.");
                    continue;
                }

                ticketManager.closeTicket(idToClose);
            } else if (choice == 4) {
                System.out.println("Enter the ticket ID to search: ");

                try {
                    int idToSearch = Integer.parseInt(scanner.nextLine());
                    ticketManager.displayTicketById(idToSearch);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID. Please enter a number.");
                }

            } else if (choice == 5) {
                System.out.println("\n1. View open tickets");
                System.out.println("2. View closed tickets");
                System.out.println("3. Filter by priority");
                System.out.println("Choose a filter: ");

                String filterChoice = scanner.nextLine();

                if (filterChoice.equals("1")) {
                    ticketManager.displayTicketByStatus("Open");

                } else if (filterChoice.equals("2")) {
                    ticketManager.displayTicketByStatus("Closed");

                } else if (filterChoice.equals("3")) {
                    System.out.println("Enter priority (Low/Meidum/High): ");
                    String priority = scanner.nextLine();

                    if (priority.equalsIgnoreCase("Low")
                            || priority.equalsIgnoreCase("Medium")
                            || priority.equalsIgnoreCase("High")) {

                        ticketManager.displayTicketsByPriority(priority);
                    } else {
                        System.out.println("Invalid priority.");
                    }

                } else {
                    System.out.println("Invalid filter option.");
                }

            } else if (choice == 6) {
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
        System.out.println("4. Search for a ticket");
        System.out.println("5. Filter tickets");
        System.out.println("6. Exit");


    }

    public static String readNonEmptyLine(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("This field cannot be empty.");


        }
    }


}
