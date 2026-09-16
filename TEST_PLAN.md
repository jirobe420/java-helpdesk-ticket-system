# Help Desk Ticket System — Manual Test Plan

## Test Environment

- Application: Help Desk Ticket System
- Type: Java console application
- IDE: IntelliJ IDEA
- Storage: tickets.txt

## Test Results

| ID | Feature | Test Steps | Expected Result | Actual Result | Status |
|---|---|---|---|---|---|
| TC-01 | Start application | Run Main.java | Welcome message and menu are displayed | Welcome message and menu displayed correctly | Pass |
| TC-02 | Invalid menu input | Enter `hello` in the main menu | Error message appears and application continues | Error displayed and application continued | Pass |
| TC-03 | Invalid menu option | Enter `99` in the main menu | `Invalid option.` is displayed | Invalid-option message displayed correctly | Pass |
| TC-04 | Create ticket | Enter valid name, issue, and High priority | Ticket is created with a unique ID and Open status | Ticket created with unique ID and Open status | Pass |
| TC-05 | Empty name | Leave the name empty and press Enter | Application displays `This field cannot be empty.` and asks again | Empty name rejected and application asked again | Pass |
| TC-06 | Empty issue | Leave the issue empty and press Enter | Application displays `This field cannot be empty.` and asks again | Empty issue rejected and application asked again | Pass |
| TC-07 | Invalid priority | Enter `Urgent` as the priority | Application rejects it and asks for Low, Medium, or High | Invalid priority rejected | Pass |
| TC-08 | Priority capitalization | Enter `hIgH` as the priority | Ticket is created and priority is stored as `High` | Priority displayed as `High` | Pass |
| TC-09 | View all tickets | Choose option `2` when tickets exist | Every saved ticket is displayed | All saved tickets displayed | Pass |
| TC-10 | Search existing ticket | Choose option `4` and enter an existing ID | Correct ticket details are displayed | Correct ticket displayed | Pass |
| TC-11 | Search nonexistent ticket | Choose option `4` and enter `999999` | `Ticket ID not found.` is displayed | Ticket-not-found message displayed | Pass |
| TC-12 | Invalid search ID | Choose option `4` and enter `hello` | Invalid-ID message appears and application continues | Invalid-ID message displayed and application continued | Pass |
| TC-13 | Close open ticket | Choose option `3` and enter an open ticket ID | Ticket status changes to `Closed` | Ticket status changed to `Closed` | Pass |
| TC-14 | Close already closed ticket | Try to close the same ticket again | Application says the ticket is already closed | Already-closed message displayed | Pass |
| TC-15 | Close nonexistent ticket | Enter `999999` as the ticket ID | `Ticket ID not found.` is displayed | Ticket-not-found message displayed | Pass |
| TC-16 | Invalid closing ID | Enter `hello` instead of an ID | Invalid-ID message appears and application continues | Invalid-ID message displayed and application continued | Pass |
| TC-17 | Filter open tickets | Choose `5`, then `1` | Only tickets with Open status are displayed | Only Open tickets displayed | Pass |
| TC-18 | Filter closed tickets | Choose `5`, then `2` | Only tickets with Closed status are displayed | Only Closed tickets displayed | Pass |
| TC-19 | Filter by priority | Choose `5`, then `3`, and enter `High` | Only High-priority tickets are displayed | Only High-priority tickets displayed | Pass |
| TC-20 | Invalid filter priority | Choose `5`, then `3`, and enter `Urgent` | `Invalid priority.` is displayed | Invalid-priority message displayed | Pass |
| TC-21 | Invalid filter option | Choose `5`, then enter `99` | `Invalid filter option.` is displayed | Invalid-filter message displayed | Pass |
| TC-22 | Cancel deletion | Choose `6`, enter an existing ID, then enter `no` | Deletion is cancelled and the ticket remains | Deletion cancelled and ticket remained | Pass |
| TC-23 | Delete existing ticket | Choose `6`, enter an existing ID, then enter `yes` | Ticket is deleted successfully | Ticket deleted and no longer displayed | Pass |
| TC-24 | Delete nonexistent ticket | Choose `6`, enter `999999`, then enter `yes` | `Ticket ID not found.` is displayed | Ticket-not-found message displayed | Pass |
| TC-25 | Invalid deletion ID | Choose `6` and enter `hello` | Invalid-ID message appears and application continues | Invalid-ID message displayed and application continued | Pass |
| TC-26 | Save tickets | Create a ticket and exit using option `7` | Ticket is stored in tickets.txt | Ticket saved in tickets.txt | Pass |
| TC-27 | Load tickets | Restart the application and choose option `2` | Previously saved ticket is displayed | Saved ticket loaded correctly | Pass |
| TC-28 | Continue ticket IDs | Restart, create another ticket, and compare its ID | New ticket receives an ID higher than existing tickets | New ticket received the next available ID | Pass |
| TC-29 | Persist closed status | Close a ticket, restart, and search for it | Ticket remains Closed after restarting | Closed status remained after restart | Pass |
| TC-30 | Persist deletion | Delete a ticket and restart the application | Deleted ticket does not return | Deleted ticket did not return | Pass |

## Test Summary

- Total test cases: 30
- Passed: 30
- Failed: 0
- Not tested: 0

## Conclusion

All tested features behaved as expected. The application correctly handles ticket creation, viewing, searching, filtering, closing, deletion, input validation, and file persistence.