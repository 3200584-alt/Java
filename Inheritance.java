import java.util.Scanner;

class BookingSystem {
    String[][] seats;
    int rows;
    int cols;
    String typeName;

    BookingSystem(int rows, int cols, String typeName) {
        this.rows = rows;
        this.cols = cols;
        this.typeName = typeName;
        this.seats = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = "Available";
            }
        }
    }

    void viewSeats() {
        System.out.println("\n--- " + typeName + " Seat Layout ---");
        System.out.print("      ");
        for (int c = 1; c <= cols; c++) {
            System.out.print("Seat " + c + "    ");
        }
        System.out.println("\n");

        for (int i = 0; i < rows; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                System.out.print("[" + seats[i][j] + "]  ");
            }
            System.out.println("\n");
        }
    }

    boolean bookTicket(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("Error: Invalid seat location.");
            return false;
        }
        if ("Available".equals(seats[row][col])) {
            seats[row][col] = "Booked";
            System.out.println("Success: Your " + typeName + " ticket has been booked!");
            return true;
        } else {
            System.out.println("Sorry: This seat is already booked.");
            return false;
        }
    }
}

class TheatreBooking extends BookingSystem {
    TheatreBooking() {
        super(9, 6, "Theatre");
    }
}

class TrainBooking extends BookingSystem {
    TrainBooking() {
        super(10, 4, "Train");
    }
}

class BusBooking extends BookingSystem {
    BusBooking() {
        super(8, 4, "Bus");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TheatreBooking theatre = new TheatreBooking();
        TrainBooking train = new TrainBooking();
        BusBooking bus = new BusBooking();

        while (true) {
            System.out.println("\n===== TICKET BOOKING SYSTEM =====");
            System.out.println("1. Theatre Ticket Booking");
            System.out.println("2. Train Ticket Booking");
            System.out.println("3. Bus Ticket Booking");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 4) {
                System.out.println("Thank you for using the Ticket Booking System.");
                break;
            }

            BookingSystem selectedSystem = null;
            switch (choice) {
                case 1:
                    selectedSystem = theatre;
                    break;
                case 2:
                    selectedSystem = train;
                    break;
                case 3:
                    selectedSystem = bus;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    continue;
            }

            boolean back = false;
            while (!back) {
                selectedSystem.viewSeats();
                System.out.println("Options for " + selectedSystem.typeName + " booking:");
                System.out.println("1. Book a Ticket");
                System.out.println("2. Back to Main Menu");
                System.out.print("Choose: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }
                int subChoice = scanner.nextInt();
                scanner.nextLine();

                if (subChoice == 1) {
                    System.out.print("Enter Row number: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input.");
                        scanner.next();
                        continue;
                    }
                    int row = scanner.nextInt() - 1;

                    System.out.print("Enter Seat number: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input.");
                        scanner.next();
                        continue;
                    }
                    int col = scanner.nextInt() - 1;
                    scanner.nextLine();

                    selectedSystem.bookTicket(row, col);
                } else if (subChoice == 2) {
                    back = true;
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        }
        scanner.close();
    }
}
