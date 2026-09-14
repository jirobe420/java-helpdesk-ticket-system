import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TicketManager {

    private ArrayList<Ticket> tickets = new ArrayList<>();

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

    private Ticket findTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }

        return null;
    }

    private void saveTicketsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("tickets.txt"))) {
            for (Ticket ticket : tickets) {
                writer.println(ticket.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Could not save tickets to file.");
        }


    }

}
