package Servlet;

import Bean.BookingBean;
import Bean.CustomerBean;
import Bean.DriverBean;
import Dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDao adminDao = new AdminDao();

        List<BookingBean> bookingList = adminDao.getAllBookings();
        List<CustomerBean> customerList = adminDao.getAllCustomers();
        List<DriverBean> driverList = adminDao.getAllDrivers();

        request.setAttribute("bookingList", bookingList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("driverList", driverList);

        request.getRequestDispatcher("Admin.jsp").forward(request, response);
    }
}
