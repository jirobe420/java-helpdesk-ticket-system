import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketTest {

    @Test
    void newTicketShouldStartOpen() {
        Ticket ticket = new Ticket(
                "Pavlos",
                "Cannot connect to Wi-Fi",
                "High"
        );

        assertEquals("Open", ticket.getStatus());
    }

    @Test

    void closingTicketShouldChangeStatusToClosed()
    {
        Ticket ticket = new Ticket (
                "Pavlos",
                "Printer is not working",
                "Medium"

        );

        ticket.close();

        assertEquals("Closed", ticket.getStatus());
    }

    @Test

    void closingAlreadyClosedTicketShouldReturnFalse()
    {
        Ticket ticket = new Ticket(

                "Pavlos",
                "Keyboard is not working",
                "Low"


        );

        ticket.close();
        boolean result = ticket.close();

        assertEquals(false, result);
    }

    @Test

    void priorityShouldUseCorrectCapitalization()
    {
        Ticket ticket = new Ticket(

                "Pavlos",
                "Screen problem",
                "hIgH"

        );

        assertEquals("High", ticket.getPriority());
    }

    @Test

    void newTicketsShouldReceiveSequentialIds()
    {
        Ticket firstTicket = new Ticket(

                "Pavlos",
                "First issue",
                "Low"

        );

        Ticket secondTicket = new Ticket(
                "Maria",
                "Second issue",
                "High"


        );

        assertEquals(firstTicket.getId() + 1, secondTicket.getId());

    }
}

