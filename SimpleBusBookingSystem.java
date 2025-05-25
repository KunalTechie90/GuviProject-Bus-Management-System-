// import java.util.*;
// import java.time.*;
// import java.time.format.DateTimeFormatter;

// class Ticket {
//     static int counter = 1;
//     int ticketId;
//     String pickup;
//     String drop;
//     LocalDateTime journeyTime;
//     String seatType;
//     double fare;
//     boolean isCancelled;

//     Ticket(String pickup, String drop, LocalDateTime journeyTime, String seatType, double fare) {
//         this.ticketId = counter++;
//         this.pickup = pickup;
//         this.drop = drop;
//         this.journeyTime = journeyTime;
//         this.seatType = seatType;
//         this.fare = fare;
//         this.isCancelled = false;
//     }

//     public String toString() {
//         return "\nTicket ID: " + ticketId + "\nFrom: " + pickup + "\nTo: " + drop +
//                "\nJourney: " + journeyTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) +
//                "\nSeat Type: " + seatType + "\nFare: ₹" + fare + (isCancelled ? "\nStatus: Cancelled" : "");
//     }
// }

// public class SimpleBusBookingSystem {
//     static Scanner sc = new Scanner(System.in);
//     static List<Ticket> ticketList = new ArrayList<>();

//     public static void main(String[] args) {
//         while (true) {
//             System.out.println("\n--- BUS BOOKING SYSTEM ---");
//             System.out.println("1. Book Ticket");
//             System.out.println("2. Cancel Ticket");
//             System.out.println("3. View All Tickets");
//             System.out.println("4. Exit");
//             System.out.print("Choose option: ");
//             int choice = sc.nextInt(); sc.nextLine();

//             switch (choice) {
//                 case 1: bookTicket(); break;
//                 case 2: cancelTicket(); break;
//                 case 3: viewTickets(); break;
//                 case 4: System.out.println("Exiting..."); return;
//                 default: System.out.println("Invalid option!");
//             }
//         }
//     }

//     static void bookTicket() {
//         System.out.print("Enter Pickup Station: ");
//         String pickup = sc.nextLine();

//         System.out.print("Enter Drop Station: ");
//         String drop = sc.nextLine();

//         System.out.print("Enter Journey Date & Time (dd-MM-yyyy HH:mm): ");
//         String timeInput = sc.nextLine();
//         LocalDateTime journeyTime;
//         try {
//             journeyTime = LocalDateTime.parse(timeInput, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
//         } catch (Exception e) {
//             System.out.println("Invalid date format.");
//             return;
//         }

//         System.out.print("Choose Seat Type (Normal/VIP): ");
//         String seatType = sc.nextLine().trim().toLowerCase();
//         double fare;
//         if (seatType.equals("vip")) {
//             fare = 600;
//         } else if (seatType.equals("normal")) {
//             fare = 400;
//         } else {
//             System.out.println("Invalid seat type.");
//             return;
//         }

//         Ticket ticket = new Ticket(pickup, drop, journeyTime, seatType.toUpperCase(), fare);
//         ticketList.add(ticket);
//         System.out.println("\nTicket Booked Successfully!");
//         System.out.println(ticket);
//     }

//     static void cancelTicket() {
//         System.out.print("Enter Ticket ID to cancel: ");
//         int id = sc.nextInt(); sc.nextLine();
//         Ticket found = null;
//         for (Ticket t : ticketList) {
//             if (t.ticketId == id) {
//                 found = t;
//                 break;
//             }
//         }

//         if (found == null) {
//             System.out.println("Ticket not found.");
//             return;
//         }

//         if (found.isCancelled) {
//             System.out.println("Ticket is already cancelled.");
//             return;
//         }

//         LocalDateTime now = LocalDateTime.now();
//         Duration duration = Duration.between(now, found.journeyTime);
//         double refund;

//         if (duration.toHours() >= 24) {
//             refund = found.fare;
//             System.out.println("Ticket cancelled successfully. Full refund: ₹" + refund);
//         } else {
//             refund = found.fare - 150;
//             System.out.println("Ticket cancelled within 24 hours. Refund after penalty: ₹" + refund);
//             System.out.println("Penalty applied: ₹150");
//         }

//         found.isCancelled = true;
//     }

//     static void viewTickets() {
//         if (ticketList.isEmpty()) {
//             System.out.println("No tickets found.");
//             return;
//         }

//         for (Ticket t : ticketList) {
//             System.out.println(t);
//         }
//     }
// }
import java.util.*; // Importing utility classes (e.g., Scanner, List, ArrayList)
import java.time.*; // Importing time-related classes (e.g., LocalDateTime, Duration)
import java.time.format.DateTimeFormatter; // For formatting and parsing date-time

// Class representing a bus ticket
class Ticket {
    static int counter = 1; // Static counter to auto-increment Ticket IDs
    int ticketId;           // Unique ID for each ticket
    String pickup;          // Pickup station
    String drop;            // Drop station
    LocalDateTime journeyTime; // Journey date and time
    String seatType;        // Type of seat (Normal/VIP)
    double fare;            // Fare for the ticket
    boolean isCancelled;    // Ticket cancellation status

    // Constructor to initialize a Ticket object
    Ticket(String pickup, String drop, LocalDateTime journeyTime, String seatType, double fare) {
        this.ticketId = counter++; // Assign and increment unique ID
        this.pickup = pickup;
        this.drop = drop;
        this.journeyTime = journeyTime;
        this.seatType = seatType;
        this.fare = fare;
        this.isCancelled = false; // Ticket is active by default
    }

    // Overriding toString() method to display ticket details
    public String toString() {
        return "\nTicket ID: " + ticketId +
               "\nFrom: " + pickup +
               "\nTo: " + drop +
               "\nJourney: " + journeyTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) +
               "\nSeat Type: " + seatType +
               "\nFare: ₹" + fare +
               (isCancelled ? "\nStatus: Cancelled" : ""); // Show cancellation status if applicable
    }
}

// Main class for the simple bus booking system
public class SimpleBusBookingSystem {
    static Scanner sc = new Scanner(System.in); // For user input
    static List<Ticket> ticketList = new ArrayList<>(); // List to store booked tickets

    public static void main(String[] args) {
        while (true) {
            // Display menu
            System.out.println("\n--- BUS BOOKING SYSTEM ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View All Tickets");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt(); sc.nextLine(); // Read user choice
            switch (choice) {
                case 1: bookTicket(); break;     // Booking a new ticket
                case 2: cancelTicket(); break;   // Cancel an existing ticket
                case 3: viewTickets(); break;    // View all booked tickets
                case 4:                         // Exit program
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option!"); // Invalid input handling
            }
        }
    }

    // Function to book a ticket
    static void bookTicket() {
        System.out.print("Enter Pickup Station: ");
        String pickup = sc.nextLine();

        System.out.print("Enter Drop Station: ");
        String drop = sc.nextLine();

        System.out.print("Enter Journey Date & Time (dd-MM-yyyy HH:mm): ");
        String timeInput = sc.nextLine();

        LocalDateTime journeyTime;
        try {
            // Parse input string to LocalDateTime
            journeyTime = LocalDateTime.parse(timeInput, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return;
        }

        System.out.print("Choose Seat Type (Normal/VIP): ");
        String seatType = sc.nextLine().trim().toLowerCase();

        double fare;
        // Determine fare based on seat type
        if (seatType.equals("vip")) {
            fare = 600;
        } else if (seatType.equals("normal")) {
            fare = 400;
        } else {
            System.out.println("Invalid seat type.");
            return;
        }

        // Create and add the new ticket to the list
        Ticket ticket = new Ticket(pickup, drop, journeyTime, seatType.toUpperCase(), fare);
        ticketList.add(ticket);

        // Display booking confirmation
        System.out.println("\nTicket Booked Successfully!");
        System.out.println(ticket);
    }

    // Function to cancel a ticket
    static void cancelTicket() {
        System.out.print("Enter Ticket ID to cancel: ");
        int id = sc.nextInt(); sc.nextLine();

        Ticket found = null;

        // Search for the ticket by ID
        for (Ticket t : ticketList) {
            if (t.ticketId == id) {
                found = t;
                break;
            }
        }

        if (found == null) {
            System.out.println("Ticket not found.");
            return;
        }

        if (found.isCancelled) {
            System.out.println("Ticket is already cancelled.");
            return;
        }

        // Calculate time difference from current time to journey time
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, found.journeyTime);

        double refund;
        // Determine refund policy based on cancellation time
        if (duration.toHours() >= 24) {
            refund = found.fare; // Full refund
            System.out.println("Ticket cancelled successfully. Full refund: ₹" + refund);
        } else {
            refund = found.fare - 150; // Deduct penalty for late cancellation
            System.out.println("Ticket cancelled within 24 hours. Refund after penalty: ₹" + refund);
            System.out.println("Penalty applied: ₹150");
        }

        // Mark ticket as cancelled
        found.isCancelled = true;
    }

    // Function to view all tickets
    static void viewTickets() {
        if (ticketList.isEmpty()) {
            System.out.println("No tickets found.");
            return;
        }

        // Print each ticket
        for (Ticket t : ticketList) {
            System.out.println(t);
        }
    }
}
