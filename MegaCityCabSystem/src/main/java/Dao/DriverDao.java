package Dao;

import Bean.DriverBean;
import Bean.BookingBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDao {
    private Connection conn;

    public DriverDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabonlinebookingdb", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch driver details by license number
    public DriverBean getDriverByLicense(String licenseNumber) {
        DriverBean driver = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Driver WHERE license_number = ?");
            ps.setString(1, licenseNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                driver = new DriverBean();
                driver.setDriverId(rs.getInt("driver_id"));
                driver.setName(rs.getString("name"));
                driver.setLicenseNumber(rs.getString("license_number"));
                driver.setPhoneNumber(rs.getString("phone_number"));
                driver.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    // Fetch assigned bookings for a driver
    public List<BookingBean> getDriverBookings(int driverId) {
        List<BookingBean> bookings = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Booking WHERE driver_id=? AND status NOT IN ('Completed', 'Cancelled')");
            ps.setInt(1, driverId);
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
}
