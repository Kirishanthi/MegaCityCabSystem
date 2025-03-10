package Servlet;

import Bean.BookingBean;
import Dao.BookingDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/Booking")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer customerId = (Integer) session.getAttribute("customerId");

        if (customerId == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        String pickup = request.getParameter("pickup");
        String destination = request.getParameter("destination");
        String date = request.getParameter("date");
        String time = request.getParameter("time");

        // Validate inputs
        if (pickup == null || destination == null || date == null || time == null ||
            pickup.isEmpty() || destination.isEmpty() || date.isEmpty() || time.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required!");
            request.getRequestDispatcher("Booking.jsp").forward(request, response);
            return;
        }

        try {
            // Parse date and time to LocalDateTime
            String dateTimeString = date + " " + time + ":00";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime bookingTime = LocalDateTime.parse(dateTimeString, formatter);

            BookingBean booking = new BookingBean();
            booking.setCustomerId(customerId);
            booking.setPickupAddress(pickup);
            booking.setDestinationAddress(destination);
            booking.setBookingTime(bookingTime);
            booking.setStatus("Pending");

            BookingDao bookingDao = new BookingDao();
            boolean isBooked = bookingDao.addBooking(booking);

            if (isBooked) {
                request.setAttribute("successMessage", "Booking successful!");
            } else {
                request.setAttribute("errorMessage", "Booking failed. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Invalid date/time format. Please check your input.");
        }

        request.getRequestDispatcher("Booking.jsp").forward(request, response);
    }
}
