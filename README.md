# ✈️ Airline Reservation System

A comprehensive airline reservation system built in Java, featuring flight management, passenger booking, cancellation, and persistent data storage.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Complete-success?style=for-the-badge)

## 🌟 Features

- **Flight Management**: View and search available flights
- **Booking System**: Book tickets with passenger details
- **Cancellation**: Cancel bookings with automatic refunds
- **Data Persistence**: Save and load bookings using serialization
- **Real-time Updates**: Dynamic seat availability tracking
- **Input Validation**: Robust error handling

## 🛠️ Technologies Used

- Java SE
- File I/O (Serialization)
- Collections Framework
- Object-Oriented Programming

## 📋 Prerequisites

- JDK 8 or higher
- Terminal/Command Prompt

## 🚀 Installation & Setup

1. **Clone the repository**
```bash
git clone https://github.com/YOUR_USERNAME/airline-reservation-system.git
cd airline-reservation-system
```

2. **Compile the project**
```bash
cd src
javac *.java
```

3. **Run the application**
```bash
java AirlineSystem
```

## 💻 Usage

### Main Menu Options:

1. **View All Flights** - Display all available flights
2. **Search Flights** - Search by source and destination
3. **Book a Flight** - Reserve a seat with passenger details
4. **Cancel Booking** - Cancel existing reservation
5. **View Flight Bookings** - See passenger list for a flight
6. **Save & Exit** - Persist data and exit

### Sample Usage:
```
Enter flight number: AI101
Enter Passenger ID: P001
Enter Name: John Doe
Enter Email: john@email.com
Enter Phone Number: 9876543210
Enter Age: 28

✅ BOOKING CONFIRMED!
Flight: AI101
Passenger: John Doe
Total Amount: $5500.0
```

## 📊 Project Structure
```
airline-reservation-system/
├── src/
│   ├── Flight.java          # Flight model class
│   ├── Passenger.java       # Passenger model class
│   └── AirlineSystem.java   # Main controller
├── README.md
└── .gitignore
```

## 🎯 Key Concepts Demonstrated

- **OOP Principles**: Encapsulation, Abstraction
- **Data Structures**: ArrayList, Collections
- **File I/O**: Serialization/Deserialization
- **Exception Handling**: Try-catch blocks
- **Input Validation**: User input sanitization

## 🔮 Future Enhancements

- [ ] Database integration (MySQL/PostgreSQL)
- [ ] GUI using JavaFX or Swing
- [ ] Seat selection feature
- [ ] Multiple flight classes (Economy, Business, First)
- [ ] Payment gateway integration
- [ ] Email confirmation system
- [ ] Admin dashboard

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Author

**Vanisha Nair**
- GitHub: https://www.linkedin.com/in/vanisha-nair-417107279/
- LinkedIn: https://github.com/Vanii1007

## ⭐ Show Your Support

Give a ⭐ if this project helped you!

---

**Made with ❤️ for learning Java**
```

---

### **Step 6: Create .gitignore File**

Create `.gitignore` file:
```
# Compiled class files
*.class

# Package files
*.jar
*.war
*.ear

# Virtual machine crash logs
hs_err_pid*

# Serialized data files
*.ser

# IDE specific files
.idea/
*.iml
.vscode/
.DS_Store

# Build directories
out/
target/
build/
