import java.io.Serializable;

/**
 * Represents a passenger in the airline system
 */
public class Passenger implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String passengerId;
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    
    public Passenger(String passengerId, String name, String email, 
                     String phoneNumber, int age) {
        this.passengerId = passengerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Age: %d | Phone: %s | Email: %s",
                           passengerId, name, age, phoneNumber, email);
    }
    
    // Getters
    public String getPassengerId() { return passengerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getAge() { return age; }
}