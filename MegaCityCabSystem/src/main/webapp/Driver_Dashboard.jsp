<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Driver Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>Driver Dashboard</h2>

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

        <h3>Assigned Bookings</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Booking ID</th>
                    <th>Customer Name</th>
                    <th>Pickup Location</th>
                    <th>Destination</th>
                    <th>Booking Time</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="booking" items="${bookingList}">
                    <tr>
                        <td>${booking.bookingId}</td>
                        <td>${booking.customerName}</td>
                        <td>${booking.pickupAddress}</td>
                        <td>${booking.destinationAddress}</td>
                        <td>${booking.bookingTime}</td>
                        <td>${booking.status}</td>
                        <td>
                            <form action="UpdateBookingStatus" method="post">
                                <input type="hidden" name="bookingId" value="${booking.bookingId}">
                                <select name="status">
                                    <option value="Confirmed" ${booking.status == 'Confirmed' ? 'selected' : ''}>Confirmed</option>
                                    <option value="Ongoing" ${booking.status == 'Ongoing' ? 'selected' : ''}>Ongoing</option>
                                    <option value="Completed" ${booking.status == 'Completed' ? 'selected' : ''}>Completed</option>
                                </select>
                                <button type="submit">Update</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Logout Button -->
        <br>
        <a href="Logout">Logout</a>
    </div>
</body>
</html>
