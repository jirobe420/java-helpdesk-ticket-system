import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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

        assertFalse(result);
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

    @Test

        void invalidPriorityShouldThrowException()
    {
        assertThrows(

                IllegalArgumentException.class,() -> new Ticket(

                        "Pavlos",
                        "Internet problem",
                        "Urgent"
                )
        );
    }

    @Test
    void nullPriorityShouldThrowException()
    {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Ticket(
                        "Pavlos",
                        "Internet problem",
                        null
                )
        );
    }

    @Test
    void reopeningClosedTicketShouldChangeStatusToOpen(){

        Ticket ticket = new Ticket(
                "Pavlos",
                "Internet problem returned",
                "High"
        );

        ticket.close();
        boolean result = ticket.reopen();

        assertTrue(result);
        assertEquals("Open", ticket.getStatus());

    }

}

