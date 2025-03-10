package Servlet;

import Bean.BookingBean;
import Dao.DriverDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Driver")
public class DriverServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer driverId = (Integer) session.getAttribute("driverId");

        if (driverId == null) {
            response.sendRedirect("DriverLogin.jsp");
            return;
        }

        DriverDao driverDao = new DriverDao();
        List<BookingBean> bookingList = driverDao.getDriverBookings(driverId);

        request.setAttribute("bookingList", bookingList);
        request.getRequestDispatcher("Driver.jsp").forward(request, response);
    }
}
