import jdk.swing.interop.SwingInterOpUtils;

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

    public void reopenTicket(int id){
        Ticket ticket = findTicketById(id);

        if (ticket == null){
            System.out.println("Ticket ID not found.");
        }else if (ticket.reopen()){
            saveTicketsToFile();
            System.out.println("Ticket " + id + " reopened successfully.");
        }else{
            System.out.println("Ticket " + id + " is already open.");
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
                String[] parts = line.split("\\|", -1);

                if (parts.length < 5) {
                    continue;
                }

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];

                StringBuilder issueBuilder = new StringBuilder(parts[2]);
                for ( int i = 3; i < parts.length - 2; i++)
                {
                    issueBuilder.append("|").append(parts[i]);
                }

                String issue = issueBuilder.toString();
                String priority = parts[parts.length - 2];
                String status = parts[parts.length - 1];



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

    public void displayStatistics()
    {
        int openCount = 0;
        int closedCount = 0;
        int lowCount = 0;
        int mediumCount = 0;
        int highCount = 0;

        for (Ticket ticket : tickets)
        {
            if (ticket.getStatus().equalsIgnoreCase("Open")){
                openCount++;
            }else if (ticket.getStatus().equalsIgnoreCase("Closed")){
                closedCount++;
            }

            if(ticket.getPriority().equalsIgnoreCase("Low"))
            {
                lowCount++;
            }else if (ticket.getPriority().equalsIgnoreCase("Medium")){
                mediumCount++;
            }else if (ticket.getPriority().equalsIgnoreCase("High")){
                highCount++;
            }
        }

        System.out.println("\n--- TICKET STATISTICS ---");
        System.out.println("Total tickets: " + tickets.size());
        System.out.println("Open tickets: " + openCount);
        System.out.println("Closed tickets: " + closedCount);
        System.out.println("Low priority: " + lowCount);
        System.out.println("Medium priority: " + mediumCount);
        System.out.println("High priority " + highCount);
        System.out.println("-------------------------");
    }


}
