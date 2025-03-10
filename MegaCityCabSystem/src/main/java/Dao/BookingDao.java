package Dao;

import Bean.BookingBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookingDao {
    public boolean addBooking(BookingBean booking) {
        boolean isBooked = false;
        String query = "INSERT INTO Booking (customer_id, pickup_address, destination_address, booking_time, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, booking.getCustomerId());
            stmt.setString(2, booking.getPickupAddress());
            stmt.setString(3, booking.getDestinationAddress());

            // Convert LocalDateTime to String
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            stmt.setString(4, booking.getBookingTime().format(formatter));

            stmt.setString(5, "Pending"); // Default status

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                isBooked = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isBooked;
    }
}
