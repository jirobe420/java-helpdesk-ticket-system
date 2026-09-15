# Help Desk Ticket System

A Java console application for creating and managing help desk tickets.

## Features

- Create tickets with a user, issue, and priority
- Automatically generate unique ticket IDs
- View all tickets
- Search for a ticket by ID
- Close open tickets
- Delete tickets with confirmation
- Filter tickets by status or priority
- Validate user input
- Save tickets to a text file
- Load saved tickets when the application starts

## Technologies

- Java
- IntelliJ IDEA
- Git and GitHub
- Java Collections (`ArrayList`)
- Java File I/O

## Project Structure

- `Main.java` — Handles the menu and user input
- `Ticket.java` — Represents an individual help desk ticket
- `TicketManager.java` — Manages, searches, saves, and loads tickets

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure a Java JDK is configured.
4. Run `Main.java`.

## Ticket Format

Tickets are stored locally in `tickets.txt` using this format:

```text
id|name|issue|priority|status