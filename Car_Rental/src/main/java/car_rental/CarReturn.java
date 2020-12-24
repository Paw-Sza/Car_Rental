package car_rental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CarReturn {
	public boolean rentInProgress = true;
	public long distance;
	public Date ReturnDate;
	public boolean delayCheck = false;
	public boolean mileageCheck = false;
	public boolean finesCheck = false;
	public boolean summaryCheck = false;
	public String text = "";
	public int capsLost = 0;
	public boolean policyLost = false;
	public boolean registrationLost = false;
	public Booking booking;
	private Payment payment = new Payment();

	public CarReturn(String ReturnDate, Booking booking) {
		try {
			this.ReturnDate = new SimpleDateFormat("yyyyMMdd").parse(ReturnDate);
		} catch (ParseException e) {
			System.out.print("Niew³aœciwy format daty oddania.");
			this.rentInProgress = false;
		}
		this.booking = booking;
		this.rentInProgress = booking.summaryCheck;
	}

	public void SetValue(long val) {
		payment.value = val;
	}

	public void AddValue(long val) {
		payment.value += val;
	}

	public long GetValue() {
		return payment.value;
	}

	public int GetRegistrationFine() {
		return 50000;
	}

	public int GetCapsFine() {
		return 2000;
	}

	public int GetPolicyFine() {
		return 50000;
	}

	public long getdelay() {
		long diffInMillies = Math.abs(ReturnDate.getTime() - booking.returnDate.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return diff;
	}
}