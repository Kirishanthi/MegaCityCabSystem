package Servlet;

import Dao.CustomerDao;
import Bean.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Signup")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve data from the form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String nic = request.getParameter("nic");
        String phoneNumber = request.getParameter("phoneNumber");

        // Create a CustomerBean object and set its properties
        CustomerBean customer = new CustomerBean();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setNic(nic);
        customer.setPhoneNumber(phoneNumber);

        // Create a CustomerDao object and try to add the customer to the database
        CustomerDao customerDao = new CustomerDao();
        boolean isAdded = customerDao.addCustomer(customer);

        if (isAdded) {
            response.sendRedirect("Login.jsp"); // Redirect to success page if customer is added successfully
        } else {
            // Set an error message and forward to signup.jsp to show the message as a popup
            request.setAttribute("errorMessage", "Sign Up failed! Please try again.");
            request.getRequestDispatcher("Signup.jsp").forward(request, response); // Forward to the signup page
        }
    }
}
