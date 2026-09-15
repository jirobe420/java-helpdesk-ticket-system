import java.io.*;
import java.util.ArrayList;

public class TicketManager {

    private final ArrayList<Ticket> tickets = new ArrayList<>();


    // Load previously saved tickets when the manager is created
    public TicketManager() {
        loadTicketsFromFile();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        saveTicketsToFile();
    }

    public void displayAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets have been created.");
            return;
        }

        System.out.println("\n--- ALL TICKETS ---");

        for (Ticket ticket : tickets) {
            ticket.display();
        }
    }

    public void closeTicket(int id) {
        Ticket ticket = findTicketById(id);

        if (ticket == null) {
            System.out.println("Ticket ID not found.");
        } else if (ticket.close()) {
            saveTicketsToFile();
            System.out.println("Ticket " + id + " closed successfully.");
        } else {
            System.out.println("Ticket " + id + " is already closed.");
        }
    }

    public void deleteTicket(int id) {
        Ticket ticket = findTicketById(id);

        if (ticket == null) {
            System.out.println("Ticket ID not found.");
        } else {
            tickets.remove(ticket);
            saveTicketsToFile();
            System.out.println("Ticket " + id + " deleted successfully");
        }
    }

    public void displayTicketById(int id) {
        Ticket ticket = findTicketById(id);

        if (ticket == null) {
            System.out.println("Ticket ID not found.");
        } else {
            ticket.display();
        }
    }


    // Returns the ticket with the matching ID, or null if it does not exist.
    private Ticket findTicketById(int id) {

        // check each ticket object inside the tickets list.
        for (Ticket ticket : tickets) {

            if (ticket.getId() == id) {
                return ticket;
            }
        }

        return null;
    }

    private void saveTicketsToFile() {

        // Replace tickets.txt with the current contents of the ticket list
        try (PrintWriter writer = new PrintWriter(new FileWriter("tickets.txt"))) {
            for (Ticket ticket : tickets) {
                writer.println(ticket.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Could not save tickets to file.");
        }


    }


    // Read saved tickets and recreate the Ticket objects.
    private void loadTicketsFromFile() {
        File file = new File("tickets.txt");

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length != 5) {
                    continue;
                }

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String issue = parts[2];
                String priority = parts[3];
                String status = parts[4];

                Ticket ticket = new Ticket(id, name, issue, priority, status);

                tickets.add(ticket);
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Could not load tickets from file");
        }


    }

    public void displayTicketByStatus(String status) {
        boolean found = false;

        for (Ticket ticket : tickets) {
            if (ticket.getStatus().equalsIgnoreCase(status)) {
                ticket.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No " + status + " ticket found.");
        }

    }

    public void displayTicketsByPriority(String priority) {
        boolean found = false;

        for (Ticket ticket : tickets) {
            if (ticket.getPriority().equalsIgnoreCase(priority)) {
                ticket.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No " + priority + " priority tickets found.");
        }

    }


}
