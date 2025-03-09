package Dao;

import Bean.CustomerBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    
    // Method to authenticate the customer with email and password
    public CustomerBean authenticateCustomer(String email, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CustomerBean customer = null;

        try {
            // Get connection to the database
            conn = DBConnection.getConnection();
            
            // SQL query to check if there is a user with the given email and password
            String sql = "SELECT * FROM Customer WHERE email = ? AND password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            
            // Execute query and check if a matching record exists
            rs = ps.executeQuery();
            
            if (rs.next()) {
                // If a matching record is found, create a CustomerBean object with the user's details
                customer = new CustomerBean();
                customer.setCustomerId(rs.getInt("customerId"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setAddress(rs.getString("address"));
                customer.setNic(rs.getString("nic"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn); // Close the connection
        }

        return customer; // Returns null if the login is unsuccessful
    }
}
