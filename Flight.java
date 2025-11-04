import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a flight in the airline system
 */
public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String flightNumber;
    private String source;
    private String destination;
    private String departureTime;
    private int totalSeats;
    private int availableSeats;
    private double price;
    private List<Passenger> passengers;
    
    public Flight(String flightNumber, String source, String destination, 
                  String departureTime, int totalSeats, double price) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.price = price;
        this.passengers = new ArrayList<>();
    }
    
    public boolean bookSeat(Passenger passenger) {
        if (availableSeats > 0) {
            passengers.add(passenger);
            availableSeats--;
            return true;
        }
        return false;
    }
    
    public boolean cancelBooking(String passengerId) {
        for (Passenger p : passengers) {
            if (p.getPassengerId().equals(passengerId)) {
                passengers.remove(p);
                availableSeats++;
                return true;
            }
        }
        return false;
    }
    
    public void displayFlightInfo() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Route: " + source + " → " + destination);
        System.out.println("Departure: " + departureTime);
        System.out.println("Price: $" + price);
        System.out.println("Available Seats: " + availableSeats + "/" + totalSeats);
        System.out.println("=".repeat(60));
    }
    
    public void displayPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers booked on this flight.");
            return;
        }
        System.out.println("\nPassengers on Flight " + flightNumber + ":");
        System.out.println("-".repeat(60));
        for (Passenger p : passengers) {
            System.out.println(p);
        }
    }
    
    // Getters
    public String getFlightNumber() { return flightNumber; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public int getAvailableSeats() { return availableSeats; }
    public double getPrice() { return price; }
    public List<Passenger> getPassengers() { return passengers; }
}