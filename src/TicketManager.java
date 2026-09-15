import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TicketManager {

    private ArrayList<Ticket> tickets = new ArrayList<>();

    public TicketManager()
    {
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

    private void loadTicketsFromFile()
    {
        File file = new File("tickets.txt");

        if (!file.exists())
        {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String issue = parts[2];
                String priority = parts[3];
                String status = parts[4];

                Ticket ticket = new Ticket(id, name ,issue, priority, status);

                tickets.add(ticket);
            }

        }catch (IOException | NumberFormatException e)
        {
            System.out.println("Could not load tickets from file");
        }


    }

}
