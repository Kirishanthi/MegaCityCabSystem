package Dao;

import Bean.BookingBean;
import Bean.CustomerBean;
import Bean.DriverBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    private Connection conn;

    public AdminDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabonlinebookingdb", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch all Bookings
    public List<BookingBean> getAllBookings() {
        List<BookingBean> bookings = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Booking");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookingBean booking = new BookingBean();
                booking.setBookingId(rs.getInt("booking_id"));
                booking.setCustomerId(rs.getInt("customer_id"));
                booking.setPickupAddress(rs.getString("pickup_address"));
                booking.setDestinationAddress(rs.getString("destination_address"));
                booking.setBookingTime(rs.getTimestamp("booking_time").toLocalDateTime());
                booking.setStatus(rs.getString("status"));
                bookings.add(booking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // Fetch all Customers
    public List<CustomerBean> getAllCustomers() {
        List<CustomerBean> customers = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerBean customer = new CustomerBean();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhoneNumber(rs.getString("phone"));
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Fetch all Drivers
    public List<DriverBean> getAllDrivers() {
        List<DriverBean> drivers = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Driver");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DriverBean driver = new DriverBean();
                driver.setDriverId(rs.getInt("driver_id"));
                driver.setName(rs.getString("name"));
                driver.setEmail(rs.getString("email"));
                driver.setPhoneNumber(rs.getString("phone"));
                drivers.add(driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drivers;
    }

    // Update Booking Status
    public boolean updateBookingStatus(int bookingId, String status) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Booking SET status=? WHERE booking_id=?");
            ps.setString(1, status);
            ps.setInt(2, bookingId);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete Customer
    public boolean deleteCustomer(int customerId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Customer WHERE customer_id=?");
            ps.setInt(1, customerId);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete Driver
    public boolean deleteDriver(int driverId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Driver WHERE driver_id=?");
            ps.setInt(1, driverId);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
