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
1) **Requirements:** JDK 17+ (or your JDK), MySQL Server, NetBeans (Ant project).
2) **Database**
   ```bash
   mysql -u root -p < db/schema.sql
   # optional demo data:
   mysql -u root -p < db/sample_data.sql
