<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>Admin Dashboard</h2>

        <!-- Display Success & Error Messages -->
        <c:if test="${not empty successMessage}">
            <script type="text/javascript">
                alert("${successMessage}");
            </script>
        </c:if>

        <c:if test="${not empty errorMessage}">
            <script type="text/javascript">
                alert("${errorMessage}");
            </script>
        </c:if>

        <h3>Manage Bookings</h3>
        <table border="1">
            <tr>
                <th>Booking ID</th>
                <th>Customer ID</th>
                <th>Pickup Location</th>
                <th>Destination</th>
                <th>Booking Time</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="booking" items="${bookingList}">
                <tr>
                    <td>${booking.bookingId}</td>
                    <td>${booking.customerId}</td>
                    <td>${booking.pickupAddress}</td>
                    <td>${booking.destinationAddress}</td>
                    <td>${booking.bookingTime}</td>
                    <td>${booking.status}</td>
                    <td>
                        <form action="UpdateBooking" method="post">
                            <input type="hidden" name="bookingId" value="${booking.bookingId}">
                            <select name="status">
                                <option value="Pending" ${booking.status == 'Pending' ? 'selected' : ''}>Pending</option>
                                <option value="Confirmed" ${booking.status == 'Confirmed' ? 'selected' : ''}>Confirmed</option>
                                <option value="Completed" ${booking.status == 'Completed' ? 'selected' : ''}>Completed</option>
                                <option value="Cancelled" ${booking.status == 'Cancelled' ? 'selected' : ''}>Cancelled</option>
                            </select>
                            <button type="submit">Update</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <h3>Manage Customers</h3>
        <table border="1">
            <tr>
                <th>Customer ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td>${customer.customerId}</td>
                    <td>${customer.name}</td>
                    <td>${customer.email}</td>
                    <td>${customer.phoneNumber}</td>
                    <td>
                        <form action="DeleteCustomer" method="post">
                            <input type="hidden" name="customerId" value="${customer.customerId}">
                            <button type="submit" onclick="return confirm('Are you sure you want to delete this customer?');">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <h3>Manage Drivers</h3>
        <table border="1">
            <tr>
                <th>Driver ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="driver" items="${driverList}">
                <tr>
                    <td>${driver.driverId}</td>
                    <td>${driver.name}</td>
                    <td>${driver.email}</td>
                    <td>${driver.phoneNumber}</td>
                    <td>
                        <form action="DeleteDriver" method="post">
                            <input type="hidden" name="driverId" value="${driver.driverId}">
                            <button type="submit" onclick="return confirm('Are you sure you want to delete this driver?');">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br>
        <a href="Logout">Logout</a>
    </div>
</body>
</html>
