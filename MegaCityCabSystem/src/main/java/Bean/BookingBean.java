
	package Bean;

	import java.time.LocalDateTime;

	public class BookingBean {
	    private int bookingId;
	    private int customerId;
	    private int driverId;
	    private int carId;
	    private String pickupAddress;
	    private String destinationAddress;
	    private LocalDateTime bookingTime;
	    private String status;

	    // Getters and Setters
	    public int getBookingId() {
	        return bookingId;
	    }

	    public void setBookingId(int bookingId) {
	        this.bookingId = bookingId;
	    }

	    public int getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(int customerId) {
	        this.customerId = customerId;
	    }

	    public int getDriverId() {
	        return driverId;
	    }

	    public void setDriverId(int driverId) {
	        this.driverId = driverId;
	    }

	    public int getCarId() {
	        return carId;
	    }

	    public void setCarId(int carId) {
	        this.carId = carId;
	    }

	    public String getPickupAddress() {
	        return pickupAddress;
	    }

	    public void setPickupAddress(String pickupAddress) {
	        this.pickupAddress = pickupAddress;
	    }

	    public String getDestinationAddress() {
	        return destinationAddress;
	    }

	    public void setDestinationAddress(String destinationAddress) {
	        this.destinationAddress = destinationAddress;
	    }

	    public LocalDateTime getBookingTime() {
	        return bookingTime;
	    }

	    public void setBookingTime(LocalDateTime bookingTime) {
	        this.bookingTime = bookingTime;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
	}

}
