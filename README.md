# Airline Management System (Swing, MVC, MySQL)

Java desktop app to manage flights, passengers, and bookings using **Swing**, **MVC**, and **MySQL**.

## Features
- CRUD for Flights / Passengers / Bookings
- Search & input validation
- MVC structure (Controller, Model, View)
- JDBC (MySQL) persistence

## Tech stack
Java · Swing · MVC · JDBC · MySQL · NetBeans · Ant

## Getting started
## Getting started

1) **Requirements**
   - **JDK 21+**
   - **MySQL 8.x Server**
   - **NetBeans** (Ant project)
   - **MySQL Connector/J** (add the JAR to Project Properties → Libraries)

2) **Database**
   Create the database (you can change the name if you like):
   ```bash
   mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS airline_management_system DEFAULT CHARACTER SET utf8mb4"

