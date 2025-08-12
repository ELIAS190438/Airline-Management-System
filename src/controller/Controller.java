package controller;

import java.sql.PreparedStatement; // import for prepared statements ((to prepare to excute the query))
import java.sql.ResultSet; // import for result sets ((to get the result of the equation ))
import java.sql.SQLException; // import for SQL exceptions
import java.sql.Time; // import for SQL Time
import java.util.ArrayList; // import for ArrayList
import java.util.List; // import for List
import java.util.Random; // import for Random ID generation
import java.util.logging.Level; // import for logging levels((Both of these metohd is used to clarifie the error in details EX:Date,time))
import java.util.logging.Logger; // import for logging      ((Both of these metohd is used to clarifie the error in details EX:Date,time))
import java.sql.Types; // import for JDBC SQL types  (for getting the data type of the attribute from mysql))
import java.time.LocalTime; // import for LocalTime
import java.util.Date; // import for java.util.Date

public class Controller {

    Server sv = new Server(); // instantiate database server helper

    // login to the system by name and password and job 
    public boolean login(String inputUsername, String inputPassword, String job) {
        PreparedStatement ps; // declare PreparedStatement
        ResultSet rs; // declare ResultSet
        String query = "SELECT * FROM employee WHERE username = ? AND passwordHash = ? AND jobTitle= ?"; // SQL for credential check

        try {
            ps = sv.createConnection().prepareStatement(query); // prepare the query
            ps.setString(1, inputUsername); // set username parameter
            ps.setString(2, inputPassword); // set password parameter
            ps.setString(3, job); // set jobTitle parameter
            rs = ps.executeQuery(); // execute query

            return rs.next(); // return true if a record is found
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex); // log exception
            return false; // on error, return false
        }
    }

    // add employee to the system
    public void addEmployee(
            int employeeId,
            String fullName, java.util.Date dateOfBirth, String gender,
            String email, String phone, String jobTitle, String department,
            String username, String passwordHash, java.util.Date hireDate, String active
    ) {
        String query = "INSERT INTO employee (employeeId, fullName, Date_Of_BIrth, Gender, email, phone, jobTitle, department, username, passwordHash, hireDate, active) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // SQL for inserting new employee

        try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare insert statement
            ps.setInt(1, employeeId); // set employeeId
            ps.setString(2, fullName); // set fullName
            ps.setDate(3, new java.sql.Date(dateOfBirth.getTime())); // set dateOfBirth ((to transform from the netb date to sql date))
            ps.setString(4, gender); // set gender
            ps.setString(5, email); // set email
            ps.setString(6, phone); // set phone
            ps.setString(7, jobTitle); // set jobTitle
            ps.setString(8, department); // set department
            ps.setString(9, username); // set username
            ps.setString(10, passwordHash); // set passwordHash
            ps.setDate(11, new java.sql.Date(hireDate.getTime())); // set hireDate
            ps.setString(12, active); // set active status

            ps.executeUpdate(); // execute insert
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex); // log exception
        }
    }

    // get employee data except the password for security
    public String[][] getEmployeesWithoutPassword() {
        ArrayList<String[]> employeeList = new ArrayList<>(); // prepare list for results
        PreparedStatement ps; // declare PreparedStatement
        ResultSet rs; // declare ResultSet
        String query = "SELECT `employeeId`, `fullName`, `Date_Of_BIrth`, `Gender`, `email`, `phone`, `jobTitle`, `department`, `username`, `hireDate`, `active` FROM `employee`"; // SQL to select all but password

        try {
            ps = sv.createConnection().prepareStatement(query); // prepare select statement
            rs = ps.executeQuery(); // execute query ((becuase its select its "execute"
            while (rs.next()) { // iterate over results
                String[] employee = new String[11]; // prepare array for a row
                employee[0] = String.valueOf(rs.getInt("employeeId")); // map employeeId
                employee[1] = rs.getString("fullName"); // map fullName
                employee[2] = rs.getString("Date_Of_Birth"); // map dateOfBirth
                employee[3] = rs.getString("Gender"); // map gender
                employee[4] = rs.getString("email"); // map email
                employee[5] = rs.getString("phone"); // map phone
                employee[6] = rs.getString("jobTitle"); // map jobTitle
                employee[7] = rs.getString("department"); // map department
                employee[8] = rs.getString("username"); // map username
                employee[9] = rs.getDate("hireDate").toString(); // map hireDate
                employee[10] = rs.getString("active"); // map active status

                employeeList.add(employee); // add row to list  ((to add all the array cause this is arraylist ))
            }
        } catch (SQLException ex) {
            // swallow exception
        }

        return employeeList.toArray(new String[0][0]); // convert list to 2D array ((because its abnormal case 
    }                                                                              //((we cant store an arrraylist in a table))

    // return the number of employees
    public int countEmployees() {
        int count = 0; // initialize count
        String query = "SELECT COUNT(*) AS total FROM employee "; // SQL to count rows

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare count statement
            ResultSet rs = ps.executeQuery() // execute query
        ) {
            if (rs.next()) { // if result present
                count = rs.getInt("total"); // fetch count
            }
        } catch (SQLException ex) {
            // swallow exception
        }

        return count; // return total
    }

    // generate unique id 
    public int generateUniqueEmployeeId() {
        Random random = new Random(); // create random generator
        int id; // declare id

        while (true) { // loop until unique
            id = 100000 + random.nextInt(900000); // generate 6-digit ID

            String query = "SELECT 1 FROM employee WHERE employeeId = ?"; // SQL to check existence once
            try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare check
                ps.setInt(1, id); // set ID param
                ResultSet rs = ps.executeQuery(); // execute query

                if (!rs.next()) { // if no record
                    break; // ID is unique
                }
            } catch (SQLException ex) {
                return -1; // on error, return -1
            }
        }

        return id; // return unique ID
    }

    // delete employee
    public boolean deleteEmployee(int id) {
        PreparedStatement st; // declare PreparedStatement
        ResultSet rs; // declare ResultSet

        String deletefabric = "DELETE FROM `employee` WHERE `employeeId`=?"; // SQL to delete

        try {
            st = sv.createConnection().prepareStatement(deletefabric); // prepare delete
            st.setInt(1, id); // set ID param (( 1 becuase we have one parameter in the query))
            return st.executeUpdate() > 0; // execute delete and return success flag
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex); // log exception
            return false; // return false on error
        }
    }

    // add aircraft
    public void addAircraftFromGUI(
            int aircraftID,
            String registration,
            String manufacture,
            String model,
            int seatCapacity,
            String status,
            String ownershipType,
            java.util.Date leaseExpiry, // can be null
            double purchasePrice,
            Double monthlyLease, // allow null
            int firstClass,
            int business,
            int economy,
            String engineType,
            int engineCount,
            int fuelCapacity
    ) {
        String query = "INSERT INTO aircrafts ("
                + "AircraftID, Registration, Manufacture, Model, SeatCapacity, CurrentStatus, "
                + "OwnershipType, LeaseExpiry, PurchasePrice, MonthlyLease, "
                + "FirstClassSeats, BusinessSeats, EconomySeats, EngineType, EngineCount, FuelCapacity"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // SQL to insert aircraft

        try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare insert
            ps.setInt(1, aircraftID); // set aircraftID
            ps.setString(2, registration); // set registration
            ps.setString(3, manufacture); // set manufacture
            ps.setString(4, model); // set model
            ps.setInt(5, seatCapacity); // set seatCapacity
            ps.setString(6, status); // set currentStatus
            ps.setString(7, ownershipType); // set ownershipType

            // Conditional lease expiry and monthly lease
            if ("Leased".equalsIgnoreCase(ownershipType)) { // if leased=mousta2jar
                if (leaseExpiry != null) {
                    ps.setDate(8, new java.sql.Date(leaseExpiry.getTime())); // set leaseExpiry
                } 
                ps.setDouble(9, purchasePrice); // set purchasePrice
                if (monthlyLease != null) {
                    ps.setDouble(10, monthlyLease); // set monthlyLease
                } 
            } else {
                ps.setNull(8, Types.DATE);       // null LeaseExpiry
                ps.setDouble(9, purchasePrice);  // set PurchasePrice
                ps.setNull(10, Types.DECIMAL);   // null MonthlyLease
            }

            ps.setInt(11, firstClass); // set firstClassSeats
            ps.setInt(12, business); // set businessSeats
            ps.setInt(13, economy); // set economySeats
            ps.setString(14, engineType); // set engineType
            ps.setInt(15, engineCount); // set engineCount
            ps.setInt(16, fuelCapacity); // set fuelCapacity

            ps.executeUpdate(); // execute insert because update
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex); // log exception
        }
    }

    // get aircraft data as 2D array to put them in a table
    public String[][] getAircraft() {
        ArrayList<String[]> AircraftList = new ArrayList<>(); // prepare list for rows
        PreparedStatement ps; // declare PreparedStatement
        ResultSet rs; // declare ResultSet
        String query = "SELECT * FROM aircrafts"; // SQL to select all aircrafts

        try {
            ps = sv.createConnection().prepareStatement(query); // prepare select
            rs = ps.executeQuery(); // execute query

            while (rs.next()) { // iterate rows
                String[] aircraft = new String[16]; // array for row
                aircraft[0] = String.valueOf(rs.getInt("AircraftID")); // ((transfrom integer to string))
                aircraft[1] = rs.getString("Registration"); // map registration
                aircraft[2] = rs.getString("Manufacture"); // map manufacture
                aircraft[3] = rs.getString("Model"); // map model
                aircraft[4] = String.valueOf(rs.getInt("SeatCapacity")); // map seatCapacity
                aircraft[5] = rs.getString("CurrentStatus"); // map currentStatus
                aircraft[6] = rs.getString("OwnershipType"); // map ownershipType

                Date leaseExpiry = rs.getDate("LeaseExpiry"); // fetch to a value leaseExpiry
                String leaseExpiryStr = (leaseExpiry != null) ? leaseExpiry.toString() : "N/A"; 
                aircraft[7] = leaseExpiryStr; // map leaseExpiry

                aircraft[8] = String.valueOf(rs.getDouble("PurchasePrice")); // map purchasePrice
                aircraft[9] = rs.getObject("MonthlyLease") != null ? String.valueOf(rs.getDouble("MonthlyLease")) : "N/A"; // map or N/A monthlyLease  (:)==else for profesionalism
                aircraft[10] = String.valueOf(rs.getInt("FirstClassSeats")); // map firstClassSeats
                aircraft[11] = String.valueOf(rs.getInt("BusinessSeats")); // map businessSeats
                aircraft[12] = String.valueOf(rs.getInt("EconomySeats")); // map economySeats
                aircraft[13] = rs.getString("EngineType"); // map engineType
                aircraft[14] = String.valueOf(rs.getInt("EngineCount")); // map engineCount
                aircraft[15] = String.valueOf(rs.getInt("FuelCapacity")); // map fuelCapacity

                AircraftList.add(aircraft); // add row
            }
        } catch (SQLException ex) {
            // swallow exception
        }

        return AircraftList.toArray(new String[0][0]); // convert list to 2D array
    }

    // count number of aircrafts in the system
    public int countAircrafts() {
        int count = 0; // initialize count
        String query = "SELECT COUNT(*) AS total FROM aircrafts "; // count every row in the table 

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare count
            ResultSet rs = ps.executeQuery() // execute
        ) {
            if (rs.next()) { // if present
                count = rs.getInt("total"); // fetch total
            }
        } catch (SQLException ex) {
            // swallow exception
        }

        return count; // return result
    }

    // delete aircraft
    public boolean deleteAircraft(int id) {
        PreparedStatement st; // declare statement
        ResultSet rs; // declare result set

        String deleteAircraft = "DELETE FROM `aircrafts` WHERE `AircraftID`=?"; // SQL delete

        try {
            st = sv.createConnection().prepareStatement(deleteAircraft); // prepare delete
            st.setInt(1, id); // set ID
            return st.executeUpdate() > 0; // execute delete and return success
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex); // log error
            return false; // return false on error
        }
    }

    // add airport
    public void addAirport(
            String code, String name, String city, String country
    ) {
        String query = " INSERT INTO `airports`(`Code`, `Name`, `Country`, `City`) VALUES (?,?,?,?)"; // SQL insert

        try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare insert
            ps.setString(1, code); // set code
            ps.setString(2, name); // set name
            ps.setString(3, city); // set country (note ordering)
            ps.setString(4, country); // set city (swapped?)

            ps.executeUpdate(); // execute insert
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex); // log error
        }
    }

    // get number of airports in the system
    public int countAirports() {
        int count = 0; // init count
        String query = "SELECT COUNT(*) AS total FROM airports "; // SQL to count

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ResultSet rs = ps.executeQuery() // execute
        ) {
            if (rs.next()) { // if result
                count = rs.getInt("total"); // fetch
            }
        } catch (SQLException ex) {
            // swallow
        }

        return count; // return
    }

    // get airport data to add them as a table
    public String[][] getAirport() {//2enta bta3rif kam row 3endak
        ArrayList<String[]> airportList = new ArrayList<>(); // init list
        PreparedStatement ps; // declare statement
        ResultSet rs; // declare result set
        String query = "SELECT * FROM `airports`"; // SQL select all airports

        try {
            ps = sv.createConnection().prepareStatement(query); // prepare select
            rs = ps.executeQuery(); // execute
            while (rs.next()) { // iterate
                String[] employee = new String[11]; // array size 11

                employee[0] = rs.getString("Code"); // map code
                employee[1] = rs.getString("Name"); // map name
                employee[2] = rs.getString("Country"); // map country
                employee[3] = rs.getString("City"); // map city

                airportList.add(employee); // add row
            }
        } catch (SQLException ex) {
            // swallow
        }

        return airportList.toArray(new String[0][0]); // convert to array
    }

    // delete airport
    public boolean deleteAirport(String code) {
        PreparedStatement st; // declare
        ResultSet rs; // declare

        String deleteAircraft = "DELETE FROM `airports` WHERE `code`=?"; // SQL delete

        try {
            st = sv.createConnection().prepareStatement(deleteAircraft); // prepare
            st.setString(1, code); // set code
            return st.executeUpdate() > 0; // execute and return
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex); // log
            return false; // return false on error
        }
    }

    // get employee name by their jobTitle and username
    public String getEmployeeName(String username, String jobTitle) {
        String fullName = null; // init result
        PreparedStatement ps; // declare
        ResultSet rs; // declare

        try {
            String query = "SELECT `fullName` FROM `employee` WHERE `username` = ? AND `jobTitle` = ?"; // SQL select name
            ps = sv.createConnection().prepareStatement(query); // prepare
            ps.setString(1, username); // set username
            ps.setString(2, jobTitle); // set jobTitle

            rs = ps.executeQuery(); // execute
            if (rs.next()) { // if found
                fullName = rs.getString("fullName"); // fetch name
            }
        } catch (SQLException ex) {
            // swallow
        }

        return fullName; // return name or null
    }

    // get airport codes
    public ArrayList<String> getCode() {
        ArrayList<String> codes = new ArrayList<>(); // init list
        String query = "SELECT `Code` FROM `airports`"; // Bta3rif kam code 3enda Code = String

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ResultSet rs = ps.executeQuery() // execute
        ) {
            while (rs.next()) { // iterate
                String c = rs.getString("Code"); // fetch code
                if (c != null && !c.isEmpty()) { // check not empty
                    codes.add(c); // add to list
                }
            }
        } catch (SQLException e) {
            // swallow
        }
        return codes; // return list
    }

    // add flights
    public boolean addFlight(
            String flightNumber,
            String origin,
            String destination,
            Date flightDate,
            LocalTime departureTime,
            LocalTime arrivalTime,
            String aircraftModel,
            int availableSeats
    ) {
        String sql = "INSERT INTO flight ("
                + "flightNumber, origin, destination, "
                + "flightDate, departureOnlyTime, arrivalOnlyTime, "
                + "aircraftModel, availableSeats) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // SQL insert flight

        try (PreparedStatement ps = sv.createConnection().prepareStatement(sql)) { // prepare
            ps.setString(1, flightNumber); // set flightNumber
            ps.setString(2, origin); // set origin
            ps.setString(3, destination); // set destination

            ps.setDate(4, new java.sql.Date(flightDate.getTime())); // set flightDate
            ps.setTime(5, java.sql.Time.valueOf(departureTime)); // set departureTime
            ps.setTime(6, java.sql.Time.valueOf(arrivalTime)); // set arrivalTime

            ps.setString(7, aircraftModel); // set model
            ps.setInt(8, availableSeats); // set seats

            return ps.executeUpdate() > 0; // execute and return success
        } catch (SQLException e) {
            return false; // return false on error
        }
    }

    // get seat capacity by model and manufacture
    public int getSeatCapacity(String manufacture, String model) {
        int seatCapacity = 0; // default if not found
        String query = "SELECT `SeatCapacity` FROM `aircrafts` WHERE `Manufacture` = ? AND `Model` = ? LIMIT 1"; // SQL select capacity

        try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare
            ps.setString(1, manufacture); // set manufacture
            ps.setString(2, model); // set model

            try (ResultSet rs = ps.executeQuery()) { // execute
                if (rs.next()) { // if found
                    seatCapacity = rs.getInt("SeatCapacity"); // fetch capacity
                }
            }
        } catch (SQLException e) {
            // swallow
        }

        return seatCapacity; // return capacity or -1
    }

    // get all aircraft display names
    public ArrayList<String> getAllAircraftDisplayNames() {
        ArrayList<String> displayNames = new ArrayList<>(); // init list
        String query = "SELECT `Manufacture`, `Model` FROM `aircrafts`"; // SQL select fields

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ResultSet rs = ps.executeQuery() // execute
        ) {
            while (rs.next()) { // iterate
                String manufacture = rs.getString("Manufacture"); // fetch manufacture
                String model = rs.getString("Model"); // fetch model

                if (manufacture != null && model != null) { // check not null
                    String display = manufacture + " - " + model; // format display
                    displayNames.add(display); // add to list
                }
            }
        } catch (SQLException e) {
            // swallow
        }

        return displayNames; // return list
    }

    // get all flights as table data
    public String[][] getFlight() {
        ArrayList<String[]> flighttList = new ArrayList<>(); // init list
        PreparedStatement ps; // declare
        ResultSet rs; // declare
        String query = "SELECT * FROM flight"; // SQL select all flights

        try {
            ps = sv.createConnection().prepareStatement(query); // prepare
            rs = ps.executeQuery(); // execute

            while (rs.next()) { // iterate
                String[] aircraft = new String[11]; // array for row
                aircraft[0] = String.valueOf(rs.getInt("flightId")); // map flightId
                aircraft[1] = rs.getString("flightNumber"); // map flightNumber
                aircraft[2] = rs.getString("origin"); // map origin
                aircraft[3] = rs.getString("destination"); // map destination

                java.sql.Date flightDate = rs.getDate("flightDate"); // fetch flightDate
                aircraft[4] = flightDate != null ? flightDate.toString() : ""; // map or blank

                java.sql.Timestamp depTimestamp = rs.getTimestamp("departureOnlyTime"); // fetch departure
                java.sql.Timestamp arrTimestamp = rs.getTimestamp("arrivalOnlyTime"); // fetch arrival

                aircraft[5] = depTimestamp != null ? depTimestamp.toLocalDateTime().toLocalTime().toString() : ""; // map departure
                aircraft[6] = arrTimestamp != null ? arrTimestamp.toLocalDateTime().toLocalTime().toString() : ""; // map arrival

                aircraft[7] = rs.getString("flightStatus"); // map status
                aircraft[8] = rs.getString("aircraftModel"); // map model

                aircraft[9] = String.valueOf(rs.getInt("availableSeats")); // map seats
                aircraft[10] = String.valueOf(rs.getInt("Reservations")); // map reservations

                flighttList.add(aircraft); // add row
            }
        } catch (SQLException ex) {
            // swallow
        }

        return flighttList.toArray(new String[0][0]); // convert to 2D array
    }

    // count flights 
    public int countflights() {
        int count = 0; // init
        String query = "SELECT COUNT(*) AS total FROM flight "; // SQL count

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ResultSet rs = ps.executeQuery() // execute
        ) {
            if (rs.next()) { // if present
                count = rs.getInt("total"); // fetch
            }
        } catch (SQLException ex) {
            // swallow
        }

        return count; // return
    }

    // delete flight
    public boolean deleteflightt(int id) {
        PreparedStatement st; // declare
        ResultSet rs; // declare

        String deleteAircraft = "DELETE FROM `flight` WHERE `flightId`=?"; // SQL delete

        try {
            st = sv.createConnection().prepareStatement(deleteAircraft); // prepare
            st.setInt(1, id); // set id
            return st.executeUpdate() > 0; // execute and return
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex); // log
            return false; // return false on error
        }
    }

    // get flight by destination and origin
    public String[][] getFlightByDestination(String origin, String destination) {
        ArrayList<String[]> flightList = new ArrayList<>(); // init
        PreparedStatement ps; // declare
        ResultSet rs; // declare
        String query = "SELECT * FROM `flight` WHERE `origin` = ? AND `destination` = ?"; // SQL filter

        try {
            ps = sv.createConnection().prepareStatement(query); // prepare
            ps.setString(1, origin); // set origin
            ps.setString(2, destination); // set destination

            rs = ps.executeQuery(); // execute
            while (rs.next()) { // iterate
                String[] aircraft = new String[11]; // array
                aircraft[0] = String.valueOf(rs.getInt("flightId")); // map id
                aircraft[1] = rs.getString("flightNumber"); // map number
                aircraft[2] = rs.getString("origin"); // map origin
                aircraft[3] = rs.getString("destination"); // map destination

                java.sql.Date flightDate = rs.getDate("flightDate"); // fetch date
                aircraft[4] = flightDate != null ? flightDate.toString() : ""; // map or blank

                java.sql.Time depTime = rs.getTime("departureOnlyTime"); // fetch departure
                java.sql.Time arrTime = rs.getTime("arrivalOnlyTime"); // fetch arrival

                aircraft[5] = depTime != null ? depTime.toLocalTime().toString() : ""; // map departure
                aircraft[6] = arrTime != null ? arrTime.toLocalTime().toString() : ""; // map arrival

                aircraft[7] = rs.getString("flightStatus"); // map status
                aircraft[8] = rs.getString("aircraftModel"); // map model
                aircraft[9] = String.valueOf(rs.getInt("availableSeats")); // map seats
                aircraft[10] = String.valueOf(rs.getInt("Reservations")); // map reservations

                flightList.add(aircraft); // add row
            }
        } catch (SQLException ex) {
            // swallow
        }

        return flightList.toArray(new String[0][0]); // convert to array
    }

    // add prices
    public void insertPriceForFlight(
            String flightNumber,
            String classType,
            double basePrice,
            double taxesFees,
            double baggageFee,
            double mealFee,
            double seatSelectionFee,
            double total,
            String currency
    ) {
        String query = "INSERT INTO `price_list`("
                + "`flightNumber`, `class_type`, `base_price`, `taxes_fees`, `baggage_fee`, "
                + "`meal_fee`, `seat_selection_fee`, `total`, `currency`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; // SQL insert price

        try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare
            ps.setString(1, flightNumber); // set flightNumber
            ps.setString(2, classType); // set classType
            ps.setDouble(3, basePrice); // set basePrice
            ps.setDouble(4, taxesFees); // set taxesFees
            ps.setDouble(5, baggageFee); // set baggageFee
            ps.setDouble(6, mealFee); // set mealFee
            ps.setDouble(7, seatSelectionFee); // set seatSelectionFee
            ps.setDouble(8, total); // set total
            ps.setString(9, currency); // set currency

            ps.executeUpdate(); // execute insert
        } catch (SQLException e) {
            // swallow
        }
    }

    // return flight numbers in an ArrayList
    public ArrayList<String> getFlightNumbers() {
        ArrayList<String> flightn = new ArrayList<>(); // init list
        String query = "SELECT  `flightNumber` From `flight`"; // SQL select numbers

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ResultSet rs = ps.executeQuery() // execute
        ) {
            while (rs.next()) { // iterate
                String flightnu = rs.getString("flightNumber"); // fetch number
                if (flightnu != null) { // check not null
                    flightn.add(flightnu); // add to list
                }
            }
        } catch (SQLException e) {
            // swallow
        }

        return flightn; // return list
    }

    // get flight price data
    public String[][] getFlightprice(String flightNumber) {
        ArrayList<String[]> flightptList = new ArrayList<>(); // init list
        PreparedStatement ps; // declare
        ResultSet rs; // declare
        String query = "SELECT * FROM `price_list` WHERE `flightNumber`=?"; // SQL select prices

        try {
            ps = sv.createConnection().prepareStatement(query); // prepare
            ps.setString(1, flightNumber); // set param
            rs = ps.executeQuery(); // execute

            while (rs.next()) { // iterate
                String[] price = new String[9]; // row array
                price[0] = String.valueOf(rs.getInt("price_id")); // map price_id
                price[1] = rs.getString("flightNumber"); // map flightNumber
                price[2] = rs.getString("class_type"); // map class_type
                price[3] = String.valueOf(rs.getDouble("base_price")); // map base_price
                price[4] = String.valueOf(rs.getDouble("taxes_fees")); // map taxes_fees
                price[5] = String.valueOf(rs.getDouble("baggage_fee")); // map baggage_fee
                price[6] = String.valueOf(rs.getDouble("seat_selection_fee")); // map seat_selection_fee
                price[7] = rs.getString("Total"); // map Total
                price[8] = rs.getString("currency"); // map currency
                flightptList.add(price); // add row
            }
        } catch (SQLException ex) {
            // swallow
        }

        return flightptList.toArray(new String[0][0]); // convert to array
    }

    // add passengers
    public boolean addPassenger(
            int passid,
            String fullName,
            String phone,
            String email,
            String passn,
            String gender,
            String nationality,
            Date dob
    ) {
        String sql = "INSERT INTO `passenger`(`passengerId`, `fullName`, `email`, `phone`, `passportNumber`, `nationality`, `dateOfBirth`, `gender`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // SQL insert passenger

        try (PreparedStatement ps = sv.createConnection().prepareStatement(sql)) { // prepare
            ps.setInt(1, passid); // set passengerId
            ps.setString(2, fullName); // set fullName
            ps.setString(3, email); // set email
            ps.setString(4, phone); // set phone
            ps.setString(5, passn); // set passportNumber
            ps.setString(6, nationality); // set nationality
            ps.setDate(7, new java.sql.Date(dob.getTime())); // set dateOfBirth
            ps.setString(8, gender);  // set gender

            return ps.executeUpdate() > 0; // execute and return
        } catch (SQLException e) {
            return false; // return false on error
        }
    }

    // get arrival time by its corresponding departure time
    public String getArrivalTimeByDeparture(java.sql.Time departureTime) {
        String arrivalTime = ""; // init
        String query = "SELECT `arrivalOnlyTime` FROM `flight` WHERE `departureOnlyTime` = ?"; // SQL select arrival

        try {
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ps.setTime(1, departureTime); // set departureTime (( 2iza ken fi error mneckmcho))
            ResultSet rs = ps.executeQuery(); // execute
            if (rs.next()) { // if found
                java.sql.Time arrTime = rs.getTime("arrivalOnlyTime"); // fetch arrivalOnlyTime
                arrivalTime = arrTime != null ? arrTime.toLocalTime().toString() : ""; // map or blank
            }
        } catch (SQLException ex) {
            // swallow
        }
        return arrivalTime; // return arrivalTime
    }

    // get the departure time by the date of the flight
    public ArrayList<String> getDepartureTimesByDate(Date date) {
        ArrayList<String> departureTimes = new ArrayList<>(); // init list
        String query = "SELECT departureOnlyTime FROM flight WHERE flightDate = ?"; // SQL select departure

        try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare
            java.sql.Date sqlDate = new java.sql.Date(date.getTime()); // convert date
            ps.setDate(1, sqlDate); // set date
            ResultSet rs = ps.executeQuery(); // execute
            while (rs.next()) { // iterate
                Time depTime = rs.getTime("departureOnlyTime"); // fetch time
                if (depTime != null) { // if not null
                    departureTimes.add(depTime.toLocalTime().toString()); // add to list
                }
            }
        } catch (SQLException e) {
            // swallow
        }
        return departureTimes; // return list
    }

    // get arrival times by date
    public ArrayList<String> getArrivalTimesByDate(Date date) {
        ArrayList<String> departureTimes = new ArrayList<>(); // init list
        String query = "SELECT ArrivalOnlyTime FROM flight WHERE flightDate = ?"; // SQL select arrival

        try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare
            java.sql.Date sqlDate = new java.sql.Date(date.getTime()); // convert date
            ps.setDate(1, sqlDate); // set
            ResultSet rs = ps.executeQuery(); // execute
            while (rs.next()) { // iterate
                Time depTime = rs.getTime("arrivalOnlyTime"); // fetch time
                if (depTime != null) { // if not null
                    departureTimes.add(depTime.toLocalTime().toString()); // add
                }
            }
        } catch (SQLException e) {
            // swallow
        }
        return departureTimes; // return list
    }

    // add reservation
    public boolean addReservation(
            int reservationId,
            String passengerName,
            String classType,
            String from,
            String to,
            String flightNumber, // <-- New parameter
            Time departureTime,
            Time arrivalTime,
            double baggageWeight,
            java.util.Date flightDate) {

        String query = "INSERT INTO reservations (`ReservationId`, `passenger Name`, `class_type`, `from`, `To`, `flightNumber`, `flightDate`, `Departure Time`, `Arrival Time`, `Bagagge Weight`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // SQL insert reservation

        try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare
            ps.setInt(1, reservationId); // set reservationId
            ps.setString(2, passengerName); // set passengerName
            ps.setString(3, classType); // set classType
            ps.setString(4, from); // set from
            ps.setString(5, to); // set to
            ps.setString(6, flightNumber); // set flightNumber
            ps.setDate(7, new java.sql.Date(flightDate.getTime())); // set flightDate
            ps.setTime(8, departureTime); // set departureTime
            ps.setTime(9, arrivalTime); // set arrivalTime
            ps.setDouble(10, baggageWeight); // set baggageWeight

            int rowsInserted = ps.executeUpdate(); // execute
            return rowsInserted > 0; // return success
        } catch (SQLException e) {
            return false; // return false on error
        }
    }

    // get passenger names
    public ArrayList<String> getPassengerNames() {
        ArrayList<String> names = new ArrayList<>(); // init list
        String query = "SELECT fullName FROM passenger"; // SQL select names

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ResultSet rs = ps.executeQuery() // execute
        ) {
            while (rs.next()) { // iterate
                String name = rs.getString("fullName"); // fetch
                if (name != null && !name.trim().isEmpty()) { // check
                    names.add(name); // add
                }
            }
        } catch (SQLException e) {
            // swallow
        }

        return names; // return
    }

    // add payments
    public boolean addPayment(
            int paymentId,
            int reservationId,
            String reservationType,
            java.sql.Date paymentDate,
            double amount,
            String paymentMethod,
            int cardNumber,
            int cvv,
            java.sql.Date expiryDate,
            String billingAddress,
            boolean isRefunded) {

        String query = "INSERT INTO payment (`paymentId`, `reservationID`, `ReservationType`, `paymentDate`, `amount`, `paymentMethod`, `Card Number`, `cvv`, `ExpiryDate`, `Billing Address`, `isRefunded`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // SQL insert payment

        try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare
            ps.setInt(1, paymentId); // set paymentId
            ps.setInt(2, reservationId); // set reservationId
            ps.setString(3, reservationType); // set reservationType
            ps.setDate(4, paymentDate); // set paymentDate
            ps.setDouble(5, amount); // set amount
            ps.setString(6, paymentMethod); // set paymentMethod
            ps.setInt(7, cardNumber); // set cardNumber
            ps.setInt(8, cvv); // set cvv

            // handle nullable expiryDate
            if (expiryDate != null) {
                ps.setDate(9, expiryDate); // set expiryDate
            } else {
                ps.setNull(9, java.sql.Types.DATE); // null expiryDate
            }

            if (billingAddress != null) {
                ps.setString(10, billingAddress); // set billingAddress
            } else {
                ps.setNull(10, java.sql.Types.VARCHAR); // null billingAddress
            }

            ps.setBoolean(11, isRefunded); // set isRefunded

            int rowsInserted = ps.executeUpdate(); // execute
            return rowsInserted > 0; // return success
        } catch (SQLException e) {
            return false; // return false on error
        }
    }

    // get flight numbers by destination and origin
    public ArrayList<String> getFlightNumbersByDestination(String destination, String origin) {
        ArrayList<String> flightNumbers = new ArrayList<>(); // init list
        String query = "SELECT flightNumber FROM flight WHERE destination = ? AND origin=?"; // SQL filter

        try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare
            ps.setString(1, destination); // set destination
            ps.setString(2, origin); // set origin

            ResultSet rs = ps.executeQuery(); // execute
            while (rs.next()) { // iterate
                String flightNumber = rs.getString("flightNumber"); // fetch
                flightNumbers.add(flightNumber); // add
            }
        } catch (SQLException e) {
            // swallow
        }

        return flightNumbers; // return
    }

    // get total price 
    public int getFlighttotal(String flightNumber) {
        PreparedStatement ps; // declare
        ResultSet rs; // declare
        String query = "SELECT `Total` FROM price_list WHERE `flightNumber` =?"; // SQL select total
        int total = 0; // init

        try {
            ps = sv.createConnection().prepareStatement(query); // prepare
            ps.setString(1, flightNumber); // set flightNumber
            rs = ps.executeQuery(); // execute

            while (rs.next()) { // iterate
                total = rs.getInt("Total"); // fetch
                return total; // return immediately
            }
        } catch (SQLException ex) {
            // swallow
        }

        return total; // return default or fetched
    }

    // get payment data as an array with the reservation data to display in pdf 
    public String[] getPaymentAsArray(int paymentId) {
        String[] result = null; // init

        String paymentQuery = "SELECT * FROM payment WHERE paymentId = ?"; // SQL select payment
        String reservationQuery = "SELECT * FROM reservations WHERE ReservationId = ?"; // SQL select reservation

        try (PreparedStatement paymentStmt = sv.createConnection().prepareStatement(paymentQuery)) { // prepare
            paymentStmt.setInt(1, paymentId); // set paymentId
            ResultSet paymentRs = paymentStmt.executeQuery(); // execute

            if (paymentRs.next()) { // if payment found
                int reservationId = paymentRs.getInt("reservationID"); // fetch reservationID
                try (PreparedStatement reservationStmt = sv.createConnection().prepareStatement(reservationQuery)) { // prepare
                    reservationStmt.setInt(1, reservationId); // set reservationId
                    ResultSet reservationRs = reservationStmt.executeQuery(); // execute

                    if (reservationRs.next()) { // if reservation found
                        // Combine both result sets into a single array
                        result = new String[]{
                            String.valueOf(paymentRs.getInt("paymentId")), // paymentId
                            String.valueOf(reservationId), // reservationID
                            paymentRs.getString("ReservationType"), // reservationType
                            paymentRs.getString("paymentDate"), // paymentDate
                            String.valueOf(paymentRs.getDouble("amount")), // amount
                            paymentRs.getString("paymentMethod"), // method
                            paymentRs.getString("Card Number"), // cardNumber
                            String.valueOf(paymentRs.getInt("cvv")), // cvv
                            String.valueOf(paymentRs.getDate("ExpiryDate")), // expiryDate
                            paymentRs.getString("Billing Address"), // billingAddress
                            String.valueOf(paymentRs.getBoolean("isRefunded")), // isRefunded
                            reservationRs.getString("passenger Name"), // passenger Name
                            reservationRs.getString("class_type"), // class_type
                            reservationRs.getString("from"), // from
                            reservationRs.getString("To"), // To
                            reservationRs.getString("flightNumber"), // flightNumber
                            String.valueOf(reservationRs.getDate("flightDate")), // flightDate
                            String.valueOf(reservationRs.getTime("Departure Time")), // Departure Time
                            String.valueOf(reservationRs.getTime("Arrival Time")), // Arrival Time
                            String.valueOf(reservationRs.getDouble("Bagagge Weight")) // Bagagge Weight
                        }; // end array
                    }
                }
            }
        } catch (Exception e) {
            // swallow
        }

        return result; // return combined array or null
    }

    // update the reservations count in the flights table 
    public void updateFlightReservationsCount(String flightNumber) {
        PreparedStatement psCount; // declare count stmt
        PreparedStatement psUpdate; // declare update stmt
        ResultSet rs; // declare rs

        try {
            String sqlCount = "SELECT COUNT(*) AS reservationCount FROM reservations WHERE flightNumber = ?"; // SQL count reservations
            psCount = sv.createConnection().prepareStatement(sqlCount); // prepare
            psCount.setString(1, flightNumber); // set flightNumber
            rs = psCount.executeQuery(); // execute

            int reservationCount = 0; // init
            if (rs.next()) { // if result
                reservationCount = rs.getInt("reservationCount"); // fetch count
            }

            String sqlUpdate = "UPDATE flight SET reservations = ? WHERE flightNumber = ?"; // SQL update flight
            psUpdate = sv.createConnection().prepareStatement(sqlUpdate); // prepare
            psUpdate.setInt(1, reservationCount); // set new count
            psUpdate.setString(2, flightNumber); // set flightNumber

           psUpdate.executeUpdate(); // execute update
        } catch (SQLException e) {
            // swallow
        }
    }

    // get price_list data
    public String[][] getPriceListData() {
        List<String[]> dataList = new ArrayList<>(); // init list
        String query = "SELECT * FROM price_list"; // SQL select all prices

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ResultSet rs = ps.executeQuery() // execute
        ) {
            while (rs.next()) { // iterate
                String[] row = new String[10]; // array
                row[0] = String.valueOf(rs.getInt("price_id")); // price_id
                row[1] = rs.getString("flightNumber"); // flightNumber
                row[2] = rs.getString("class_type"); // class_type
                row[3] = String.format("%.2f", rs.getDouble("base_price")); // format base_price
                row[4] = String.format("%.2f", rs.getDouble("taxes_fees")); // format taxes_fees
                row[5] = String.format("%.2f", rs.getDouble("baggage_fee")); // format baggage_fee
                row[6] = String.format("%.2f", rs.getDouble("meal_fee")); // format meal_fee
                row[7] = String.format("%.2f", rs.getDouble("seat_selection_fee")); // format seat_selection_fee
                row[8] = String.format("%.2f", rs.getDouble("Total")); // format Total
                row[9] = rs.getString("currency"); // currency

                dataList.add(row); // add row
            }
        } catch (SQLException e) {
            // swallow
        }

        return dataList.toArray(new String[0][0]); // convert to array
    }

    // count passengers
    public int countPassengers() {
        int count = 0; // init count
        String query = "SELECT COUNT(*) AS total FROM passenger"; // SQL count passengers

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ResultSet rs = ps.executeQuery() // execute
        ) {
            if (rs.next()) { // if present
                count = rs.getInt("total"); // fetch
            }
        } catch (SQLException e) {
            // swallow
        }

        return count; // return
    }

    // get all reservation data
    public String[][] getReservationData() {
        List<String[]> dataList = new ArrayList<>(); // init list
        String query = "SELECT * FROM reservations"; // SQL select all reservations

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ResultSet rs = ps.executeQuery() // execute
        ) {
            while (rs.next()) { // iterate
                String[] row = new String[10]; // array
                row[0] = String.valueOf(rs.getInt("ReservationId")); // ReservationId
                row[1] = rs.getString("passenger Name"); // passenger Name
                row[2] = rs.getString("Class_type"); // Class_type
                row[3] = rs.getString("From"); // From
                row[4] = rs.getString("To"); // To
                row[5] = rs.getString("flightNumber"); // flightNumber
                row[6] = rs.getDate("flightDate").toString(); // flightDate
                row[7] = rs.getTime("Departure Time").toString(); // Departure Time
                row[8] = rs.getTime("Arrival Time").toString(); // Arrival Time
                row[9] = String.valueOf(rs.getInt("Bagagge Weight")); // Bagagge Weight

                dataList.add(row); // add row
            }
        } catch (SQLException e) {
            // swallow
        }

        return dataList.toArray(new String[0][0]); // convert
    }

    // count reservations
    public int countReservations() {
        int count = 0; // init count
        String query = "SELECT COUNT(*) AS total FROM reservations"; // SQL count reservations

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ResultSet rs = ps.executeQuery() // execute
        ) {
            if (rs.next()) { // if present
                count = rs.getInt("total"); // fetch
            }
        } catch (SQLException e) {
            // swallow
        }

        return count; // return
    }

    // delete a price by its id
    public boolean deletePrice(int priceId) {
        String query = "DELETE FROM price_list WHERE price_id = ?"; // SQL delete price

        try (PreparedStatement ps = sv.createConnection().prepareStatement(query)) { // prepare
            ps.setInt(1, priceId); // set id
            int rows = ps.executeUpdate(); // execute
            return rows > 0; // return success
        } catch (SQLException e) {
            e.printStackTrace(); // print stack trace
            return false; // return false on error
        }
    }

    // get passenger data
    public String[][] getpassengerData() {
        List<String[]> dataList = new ArrayList<>(); // init list
        String query = "SELECT * FROM `passenger`"; // SQL select passengers

        try (
            PreparedStatement ps = sv.createConnection().prepareStatement(query); // prepare
            ResultSet rs = ps.executeQuery() // execute
        ) {
            while (rs.next()) { // iterate
                String[] row = new String[10]; // array
                row[0] = String.valueOf(rs.getInt("passengerId")); // passengerId
                row[1] = rs.getString("fullName"); // fullName
                row[2] = rs.getString("email"); // email
                row[3] = rs.getString("phone"); // phone
                row[4] = rs.getString("passportNumber"); // passportNumber
                row[5] = rs.getString("Nationality"); // Nationality
                row[6] = rs.getDate("dateOfBirth").toString(); // dateOfBirth
                row[7] = rs.getString("gender"); // gender

                dataList.add(row); // add row
            }
        } catch (SQLException e) {
            // swallow
        }

        return dataList.toArray(new String[0][0]); // convert
    }
}
