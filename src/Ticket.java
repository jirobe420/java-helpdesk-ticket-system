
public class Ticket {

    private String status;

    private static int nextId = 1;
    private int id;

    private String name;
    private String issue;
    private String priority;

    public Ticket(String name, String issue, String priority) {

        this.status = "Open";
        this.id = nextId;
        nextId++;


        this.name = name;
        this.issue = issue;

        // Converts "HIGH", "high", or "hIgH" into "High"
        this.priority = priority.substring(0, 1).toUpperCase() + priority.substring(1).toLowerCase();


    }

    public int getId()
    {
        return id;
    }

    public String toFileString()
    {
        return id + "|" + name + "|" + issue + "|" + priority + "|" + status;
    }

    public boolean close()
    {
       if (status.equals("Closed"))
       {
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

    public Ticket(int id, String name, String issue, String priority, String status)
    {
        this.id = id;
        this.name = name;
        this.issue = issue;
        this.priority = priority;
        this.status = status;

        if (id >= nextId)
        {
            nextId = id + 1;
        }
    }

    public String getStatus()
    {
        return status;
    }

    public String getPriority()
    {
        return priority;
    }

}
