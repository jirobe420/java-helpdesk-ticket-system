
public class Ticket {

    // counter used to give each new ticket a unique ID,
    //Ex: First ticket uses ID 1, nextId becomes 2 , Second ticket uses ID 2 and etc...
    private static int nextId = 1;

    private int id;
    private String name;
    private String issue;
    private String priority;
    private String status;

    public Ticket(String name, String issue, String priority) {

        if (priority == null
                || (!priority.equalsIgnoreCase("Low")
                && !priority.equalsIgnoreCase("Medium")
                && !priority.equalsIgnoreCase("High")))
        {
            throw new IllegalArgumentException(
                    "Priority must be Low, Medium, or High."
            );
        }


        this.status = "Open";
        this.id = nextId;
        nextId++;


        this.name = name;
        this.issue = issue;

        // Converts "HIGH", "high", or "hIgH" into "High"
        this.priority = priority.substring(0, 1).toUpperCase()
                + priority.substring(1).toLowerCase();


    }

    public int getId() {
        return id;
    }


    // Converts the ticket into the format stored in tickets.txt
    public String toFileString() {
        return id + "|" + name + "|" + issue + "|" + priority + "|" + status;
    }

    public boolean close() {
        if (status.equals("Closed")) {
            return false;
        }
        status = "Closed";
        return true;
    }

    public void display() {
        System.out.println("\n--- TICKET DETAILS ---");
        System.out.println("Ticket ID: " + id);
        System.out.println("User: " + name);
        System.out.println("Issue: " + issue);
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + status);
        System.out.println("----------------------");
    }

    // Recreates an existing ticket loaded from tickets.txt
    public Ticket(int id, String name, String issue, String priority, String status) {
        this.id = id;
        this.name = name;
        this.issue = issue;
        this.priority = priority;
        this.status = status;

        // This part prevents duplicate IDs.
        if (id >= nextId) {
            nextId = id + 1;
        }
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

}
