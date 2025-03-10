<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cab Booking</title>
    
</head>
<body>
    <div class="container">
        <h2>Book a Cab</h2>

        <form action="Booking" method="post">
            <label for="pickup">Pickup Location:</label>
            <input type="text" id="pickup" name="pickup" required><br><br>

            <label for="destination">Destination:</label>
            <input type="text" id="destination" name="destination" required><br><br>

            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required><br><br>

            <label for="time">Time:</label>
            <input type="time" id="time" name="time" required><br><br>

            <button type="submit">Book Now</button>
        </form>

        <!-- Show error message as a JavaScript alert if set -->
        <c:if test="${not empty errorMessage}">
            <script type="text/javascript">
                alert("${errorMessage}");
            </script>
        </c:if>

        <!-- Show success message as a JavaScript alert if set -->
        <c:if test="${not empty successMessage}">
            <script type="text/javascript">
                alert("${successMessage}");
            </script>
        </c:if>
    </div>
</body>
</html>
