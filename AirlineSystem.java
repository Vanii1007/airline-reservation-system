import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main Airline Reservation System class
 * Manages flights, bookings, and data persistence
 */
public class AirlineSystem {
    private List<Flight> flights;
    private static final String DATA_FILE = "airline_data.ser";
    private Scanner scanner;
    
    public AirlineSystem() {
        this.scanner = new Scanner(System.in);
        loadData();
        if (flights == null || flights.isEmpty()) {
            initializeFlights();
        }
    }
    
    private void initializeFlights() {
        flights = new ArrayList<>();
        flights.add(new Flight("AI101", "New Delhi", "Mumbai", "08:00 AM", 180, 5500.00));
        flights.add(new Flight("AI102", "Mumbai", "Bangalore", "10:30 AM", 150, 4200.00));
        flights.add(new Flight("AI103", "Bangalore", "Kolkata", "02:00 PM", 200, 6800.00));
        flights.add(new Flight("AI104", "Kolkata", "Chennai", "04:30 PM", 160, 5100.00));
        flights.add(new Flight("AI105", "Chennai", "New Delhi", "07:00 PM", 190, 7200.00));
        System.out.println("✓ Sample flights initialized!");
    }
    
    public void start() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("    WELCOME TO SKYWAY AIRLINES RESERVATION SYSTEM");
        System.out.println("=".repeat(60));
        
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1: viewAllFlights(); break;
                case 2: searchFlights(); break;
                case 3: bookFlight(); break;
                case 4: cancelBooking(); break;
                case 5: viewBookings(); break;
                case 6: saveAndExit(); return;
                default: System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
    
    private void displayMenu() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("MAIN MENU");
        System.out.println("-".repeat(60));
        System.out.println("1. View All Flights");
        System.out.println("2. Search Flights");
        System.out.println("3. Book a Flight");
        System.out.println("4. Cancel Booking");
        System.out.println("5. View Flight Bookings");
        System.out.println("6. Save & Exit");
        System.out.println("-".repeat(60));
    }
    
    private void viewAllFlights() {
        System.out.println("\n📋 AVAILABLE FLIGHTS:");
        for (Flight flight : flights) {
            flight.displayFlightInfo();
        }
    }
    
    private void searchFlights() {
        System.out.print("\nEnter source city: ");
        String source = scanner.nextLine().trim();
        System.out.print("Enter destination city: ");
        String destination = scanner.nextLine().trim();
        
        boolean found = false;
        System.out.println("\n🔍 SEARCH RESULTS:");
        for (Flight flight : flights) {
            if (flight.getSource().equalsIgnoreCase(source) && 
                flight.getDestination().equalsIgnoreCase(destination)) {
                flight.displayFlightInfo();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("❌ No flights found for this route.");
        }
    }
    
    private void bookFlight() {
        System.out.print("\nEnter flight number: ");
        String flightNumber = scanner.nextLine().trim().toUpperCase();
        
        Flight flight = findFlight(flightNumber);
        if (flight == null) {
            System.out.println("❌ Flight not found!");
            return;
        }
        
        if (flight.getAvailableSeats() == 0) {
            System.out.println("❌ Sorry, this flight is fully booked!");
            return;
        }
        
        flight.displayFlightInfo();
        
        System.out.print("\nEnter Passenger ID: ");
        String passengerId = scanner.nextLine().trim();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();
        int age = getIntInput("Enter Age: ");
        
        Passenger passenger = new Passenger(passengerId, name, email, phone, age);
        
        if (flight.bookSeat(passenger)) {
            System.out.println("\n✅ BOOKING CONFIRMED!");
            System.out.println("Flight: " + flight.getFlightNumber());
            System.out.println("Passenger: " + passenger.getName());
            System.out.println("Total Amount: $" + flight.getPrice());
            System.out.println("\nThank you for choosing SkyWay Airlines!");
            saveData();
        } else {
            System.out.println("❌ Booking failed!");
        }
    }
    
    private void cancelBooking() {
        System.out.print("\nEnter flight number: ");
        String flightNumber = scanner.nextLine().trim().toUpperCase();
        System.out.print("Enter passenger ID: ");
        String passengerId = scanner.nextLine().trim();
        
        Flight flight = findFlight(flightNumber);
        if (flight == null) {
            System.out.println("❌ Flight not found!");
            return;
        }
        
        if (flight.cancelBooking(passengerId)) {
            System.out.println("✅ Booking cancelled successfully!");
            System.out.println("Refund of $" + flight.getPrice() + " will be processed.");
            saveData();
        } else {
            System.out.println("❌ Booking not found!");
        }
    }
    
    private void viewBookings() {
        System.out.print("\nEnter flight number: ");
        String flightNumber = scanner.nextLine().trim().toUpperCase();
        
        Flight flight = findFlight(flightNumber);
        if (flight == null) {
            System.out.println("❌ Flight not found!");
            return;
        }
        
        flight.displayFlightInfo();
        flight.displayPassengers();
    }
    
    private Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
    
    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            flights = (List<Flight>) ois.readObject();
            System.out.println("✓ Previous data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("✓ Starting fresh - no previous data found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠ Could not load previous data. Starting fresh.");
        }
    }
    
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(flights);
        } catch (IOException e) {
            System.out.println("⚠ Warning: Could not save data!");
        }
    }
    
    private void saveAndExit() {
        saveData();
        System.out.println("\n✅ Data saved successfully!");
        System.out.println("Thank you for using SkyWay Airlines!");
        System.out.println("=".repeat(60));
        scanner.close();
    }
    
    public static void main(String[] args) {
        AirlineSystem system = new AirlineSystem();
        system.start();
    }
}