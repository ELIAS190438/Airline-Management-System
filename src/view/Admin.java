package view;

import controller.Controller;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin extends javax.swing.JFrame {

    Controller cn;

    public Admin() {
        initComponents();
        cn = new Controller();
        int count = cn.countEmployees(); // your method
        Ecount.setText(String.valueOf(count));

        int acount = cn.countAircrafts();
        Aicount.setText(String.valueOf(acount));

        int Arcount = cn.countAirports();
        Acount.setText(String.valueOf(Arcount));

        setLocationRelativeTo(null);

        int counts = cn.countflights();
        Ecount1.setText(String.valueOf(counts));

        int passengercount = cn.countPassengers();
        Pacount.setText(String.valueOf(passengercount));

        int ReservationCount = cn.countReservations();
        Rcount.setText(String.valueOf(ReservationCount));
    }

    public void setEmployeeName(String fullName) {
        welcome.setText("Welcome, Mr." + fullName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        ShowEmp = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Pacount = new javax.swing.JLabel();
        Rcount = new javax.swing.JLabel();
        Aicount = new javax.swing.JLabel();
        Ecount = new javax.swing.JLabel();
        Acount = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddNeew = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        ShowEmp1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        Ecount1 = new javax.swing.JLabel();
        AddNeew1 = new javax.swing.JButton();
        Delete1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/admin background (1).png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(0, 0, 0));
        welcome.setText("Welcome ");
        getContentPane().add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 410, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/passenger (2).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 91, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/airplane (2).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/time-management (2).png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/businessman (1).png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        jButton1.setText("Show passengers");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jButton2.setText("Show Reservations");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 150, -1));

        jButton4.setText("Show AirCrafts");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 110, -1));

        ShowEmp.setText("Show Employee");
        ShowEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowEmpActionPerformed(evt);
            }
        });
        getContentPane().add(ShowEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 130, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("passengers");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Reservations");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Aircrafts");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Employees");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/airport (1).png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, -1, 90));

        jButton6.setText("Show Airports");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 190, 110, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Airport");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, -1, -1));

        Pacount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Pacount.setForeground(new java.awt.Color(0, 0, 0));
        Pacount.setText("0");
        getContentPane().add(Pacount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 10, 20));

        Rcount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Rcount.setForeground(new java.awt.Color(0, 0, 0));
        Rcount.setText("0");
        getContentPane().add(Rcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 20, 20));

        Aicount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Aicount.setForeground(new java.awt.Color(0, 0, 0));
        Aicount.setText("0");
        getContentPane().add(Aicount, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        Ecount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Ecount.setForeground(new java.awt.Color(0, 0, 0));
        Ecount.setText("0");
        getContentPane().add(Ecount, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, -1, -1));

        Acount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Acount.setForeground(new java.awt.Color(0, 0, 0));
        Acount.setText("0");
        getContentPane().add(Acount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 160, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1330, 510));

        AddNeew.setText("Add new ");
        AddNeew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNeewActionPerformed(evt);
            }
        });
        getContentPane().add(AddNeew, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 130, -1));

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 130, -1));

        jButton5.setText("Add Airport");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, 110, -1));

        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 250, 110, -1));

        jButton8.setText("Add Aircraft");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 110, -1));

        jButton9.setText("Delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 110, -1));

        jButton10.setText("Add Reservation");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 150, -1));

        jButton12.setText("Add Passenger");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 120, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/direct-flight (1).png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, -1, -1));

        ShowEmp1.setText("Show Flights");
        ShowEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowEmp1ActionPerformed(evt);
            }
        });
        getContentPane().add(ShowEmp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, 130, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Flights");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, -1, -1));

        Ecount1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Ecount1.setForeground(new java.awt.Color(0, 0, 0));
        Ecount1.setText("0");
        getContentPane().add(Ecount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 160, -1, -1));

        AddNeew1.setText("Add new ");
        AddNeew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNeew1ActionPerformed(evt);
            }
        });
        getContentPane().add(AddNeew1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 130, -1));

        Delete1.setText("Delete");
        Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete1ActionPerformed(evt);
            }
        });
        getContentPane().add(Delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, 130, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/price-tag.png"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 60, -1, 90));

        jButton14.setText("Show prices");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 190, 100, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("prices");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 160, -1, -1));

        jButton15.setText("Add price");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 220, 100, -1));

        jButton16.setText("Delete");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 250, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ShowEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowEmpActionPerformed
        String[] columnNames = {
            "ID",
            "Full Name",
            "Date Of Birth",
            "Gender",
            "Email",
            "phone",
            "Role",
            "Department",
            "username",
            "HireDate",
            "Status"};
        String[][] data = cn.getEmployeesWithoutPassword();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);

    }//GEN-LAST:event_ShowEmpActionPerformed

    private void AddNeewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNeewActionPerformed
        Register_Employee emp = new Register_Employee();
        emp.setTitle("add new Employee");// (( to put title for the frame ))
        emp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddNeewActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int selectedRow = jTable1.getSelectedRow();// when i selected a row from the table i delet the selected row 

        if (selectedRow != -1) {

            Object value = jTable1.getValueAt(selectedRow, 0); // 0 = first column
            int id = Integer.parseInt(value.toString());
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete the employee with id : " + id + " \n Name :  '" + jTable1.getValueAt(selectedRow, 1) + "'?",
                    "Confirm Update",
                    JOptionPane.YES_NO_OPTION);
            //((refresh the table
            if (confirm == JOptionPane.YES_OPTION) {

                cn.deleteEmployee(id);
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
                String[] columnNames = {
                    "ID",
                    "Full Name",
                    "Date Of Birth",
                    "Gender",
                    "Email",
                    "phone",
                    "Role",
                    "Department",
                    "username",
                    "HireDate",
                    "Status"};
                String[][] data = cn.getEmployeesWithoutPassword();
                DefaultTableModel model = new DefaultTableModel(data, columnNames);
                jTable1.setModel(model);
                int count = cn.countEmployees();
                Ecount.setText(String.valueOf(count));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Employee");
        }


    }//GEN-LAST:event_DeleteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String[] columnNames = {
            "AircraftID", "Registration", "Manufacture", "Model", "SeatCapacity",
            "CurrentStatus", "OwnershipType", "LeaseExpiry", "PurchasePrice", "MonthlyLease",
            "FirstClassSeats", "BusinessSeats", "EconomySeats", "EngineType", "EngineCount", "FuelCapacity"};
        String[][] data = cn.getAircraft();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Register_Aircraft ra = new Register_Aircraft();
        ra.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {

            Object value = jTable1.getValueAt(selectedRow, 0); // 0 = first column
            int id = Integer.parseInt(value.toString());
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete the Aircraft with id : " + id + " \n Model :" + jTable1.getValueAt(selectedRow, 3) + "'?",
                    "Confirm Update",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {

                cn.deleteAircraft(id);
                JOptionPane.showMessageDialog(null, "Aircraft Deleted Successfully");
                String[] columnNames = {
                    "AircraftID", "Registration", "Manufacture", "Model", "SeatCapacity",
                    "CurrentStatus", "OwnershipType", "LeaseExpiry", "PurchasePrice", "MonthlyLease",
                    "FirstClassSeats", "BusinessSeats", "EconomySeats", "EngineType", "EngineCount", "FuelCapacity"};
                String[][] data = cn.getAircraft();
                DefaultTableModel model = new DefaultTableModel(data, columnNames);
                jTable1.setModel(model);
                int acount = cn.countAircrafts();
                Aicount.setText(String.valueOf(acount));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Aircraft");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String[] columnNames = {
            "Code", "Name", "Country", "City"
        };
        String[][] data = cn.getAirport();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Register_Airport Ra = new Register_Airport();
        Ra.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {

            Object value = jTable1.getValueAt(selectedRow, 0); // 0 = first column
            String code = value.toString();
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete the Airport with Code : " + code + " \n Name :  '" + jTable1.getValueAt(selectedRow, 1) + "'?",
                    "Confirm Update",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {

                cn.deleteAirport(code);
                String[] columnNames = {
                    "Code", "Name", "Country", "City"
                };
                String[][] data = cn.getAirport();
                DefaultTableModel model = new DefaultTableModel(data, columnNames);
                jTable1.setModel(model);
                int Arcount = cn.countAirports();
                Acount.setText(String.valueOf(Arcount));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Airport");
        }


    }//GEN-LAST:event_jButton7ActionPerformed

    private void ShowEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowEmp1ActionPerformed
        String[] columnNames = {
            "Flight ID",
            "Flight Number",
            "Origin",
            "Destination",
            "Flight Date",
            "Departure Time",
            "Arrival Time",
            "Flight Status",
            "Aircraft Model",
            "Available Seats",
            "Reservations"
        };
        String[][] data = cn.getFlight();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);
    }//GEN-LAST:event_ShowEmp1ActionPerformed

    private void AddNeew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNeew1ActionPerformed
        Register__Flights rf = new Register__Flights();
        rf.setVisible(true);
        rf.setTitle("Register New Flight");
        this.dispose();
    }//GEN-LAST:event_AddNeew1ActionPerformed

    private void Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete1ActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {

            Object value = jTable1.getValueAt(selectedRow, 0); // 0 = first column
            int id = Integer.parseInt(value.toString());
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete the flight with id : " + id + "?",
                    "Confirm Update",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {

                cn.deleteflightt(id);
                String[] c = {
                    "Flight ID",
                    "Flight Number",
                    "Origin",
                    "Destination",
                    "Flight Date",
                    "Departure Time",
                    "Arrival Time",
                    "Flight Status",
                    "Aircraft Model",
                    "Available Seats",
                    "Reservations"
                };

                String[][] data = cn.getFlight();
                DefaultTableModel model = new DefaultTableModel(data, c);
                jTable1.setModel(model);
                int counts = cn.countflights();
                Ecount1.setText(String.valueOf(counts));
            } else {
                JOptionPane.showMessageDialog(null, "Please select an Airport");
            }
        }
    }//GEN-LAST:event_Delete1ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String[] columnNames = {
            "Price ID", "Flight Number", "Class Type", "Base Price", "Taxes & Fees",
            "Baggage Fee", "Meal Fee", "Seat Selection Fee", "Total", "Currency"
        };
        String[][] data = cn.getPriceListData();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        Prices p = new Prices();
        p.setVisible(true);
        p.setTitle("ADD PRICES");
        this.dispose();

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            // Get price_id from column 0
            Object value = jTable1.getValueAt(selectedRow, 0);
            int priceId = Integer.parseInt(value.toString());

            // Get flightNumber (optional, for display in confirmation)
            String flightNumber = jTable1.getValueAt(selectedRow, 1).toString();

            // Confirm deletion
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete the price entry with ID: " + priceId + "\nFlight Number: '" + flightNumber + "'?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = cn.deletePrice(priceId); // ✅ Ensure this method is defined

                if (success) {
                    JOptionPane.showMessageDialog(null, "Price entry deleted successfully.");

                    // Refresh the table
                    String[] columnNames = {
                        "Price ID",
                        "Flight Number",
                        "Class Type",
                        "Base Price",
                        "Taxes & Fees",
                        "Baggage Fee",
                        "Meal Fee",
                        "Seat Selection Fee",
                        "Total",
                        "Currency"
                    };

                    String[][] data = cn.getPriceListData(); // ✅ Ensure this method returns all price rows
                    DefaultTableModel model = new DefaultTableModel(data, columnNames);
                    jTable1.setModel(model);

                } else {
                    JOptionPane.showMessageDialog(null, "Price deletion failed.");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a price entry to delete.");
        }

    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Register_passenger_Form rp = new Register_passenger_Form();
        rp.setVisible(true);
        rp.setTitle("ADD NEW PASSENGER");

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Book_Flight bf = new Book_Flight();
        bf.setVisible(true);
        bf.setTitle("BOOK A FLIGHT");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String[] columnNames = {
            "Reservation ID",
            "Passenger Name",
            "Class Type",
            "From",
            "To",
            "Flight Number",
            "Flight Date",
            "Departure Time",
            "Arrival Time",
            "Baggage Weight"
        };

        String[][] data = cn.getReservationData();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] columnNames = {
            "Passenger ID",
            "Full Name",
            "Email",
            "Phone",
            "Passport Number",
            "Nationality",
            "Date of Birth",
            "Gender"
        };
        String[][] data = cn.getpassengerData();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Set the Nimbus look and feel */

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Acount;
    private javax.swing.JButton AddNeew;
    private javax.swing.JButton AddNeew1;
    private javax.swing.JLabel Aicount;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Delete1;
    private javax.swing.JLabel Ecount;
    private javax.swing.JLabel Ecount1;
    private javax.swing.JLabel Pacount;
    private javax.swing.JLabel Rcount;
    private javax.swing.JButton ShowEmp;
    private javax.swing.JButton ShowEmp1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
