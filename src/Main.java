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

                String priority;

                while (true){
                    System.out.print("Enter priority (Low/Medium/High): ");
                    priority = scanner.nextLine();

                    if (priority.equalsIgnoreCase("Low") || priority.equalsIgnoreCase("Medium")
                                                                     || priority.equalsIgnoreCase("High"))
                    {
                        break;
                    }
                    System.out.println("Invalid priority. Please enter Low, Medium, or High");
                }

                Ticket ticket = new Ticket(name, issue, priority);
                ticket.display();
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

}
