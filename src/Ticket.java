
public class Ticket {

    private String name;
    private String issue;
    private String priority;

    public Ticket(String name, String issue, String priority) {
        this.name = name;
        this.issue = issue;

        // Converts "HIGH", "high", or "hIgH" into "High"
        this.priority = priority.substring(0, 1).toUpperCase() + priority.substring(1).toLowerCase();


    }

    public void display() {
        System.out.println("\n--- TICKET DETAILS ---");
        System.out.println("User: " + name);
        System.out.println("Issue: " + issue);
        System.out.println("Priority: " + priority);
        System.out.println("----------------------");
    }

}
