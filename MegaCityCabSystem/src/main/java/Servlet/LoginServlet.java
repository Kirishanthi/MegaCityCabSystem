package Servlet;

import Dao.LoginDao;
import Bean.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")  // Maps to the /Login URL
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles POST request for login
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create an instance of LoginDao to authenticate the customer
        LoginDao loginDao = new LoginDao();
        CustomerBean customer = loginDao.authenticateCustomer(email, password);  // Call the authenticate method

        if (customer != null) {
            // If authentication is successful, redirect to the homepage/dashboard
            response.sendRedirect("index.jsp");  // Redirect to the homepage (or wherever you want)
        } else {
            // If authentication fails, set the error message and forward to Login.jsp
            request.setAttribute("errorMessage", "Invalid email or password! Please try again.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
}
