package car_rental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Booking {
	// Date variables
	public Date rentalDate;
	public Date returnDate;

	// Drools steps checks
	public boolean rentInProgress = true;
	public boolean carAvaible = true;
	public boolean rentCheck = false;
	public boolean carCheck = false;
	public boolean carChosen = false;
	public boolean priceCheck = false;
	public boolean privlegeCheck = false;
	public boolean extrasPriceCheck = false;
	public boolean summaryCheck = false;

	// Booking data
	public Client client;
	public String carType;
	public String carTypeAny;
	public String carID = "";
	public boolean babySeatChosen = false;
	public boolean rackChosen = false;
	public String freeExtra = "none";
	public String text = "";
	private Payment payment = new Payment();
	public CarReturn r;

	public Booking(String Start, String End, String cartype, Client client) {
		try {
			this.rentalDate = new SimpleDateFormat("yyyyMMdd").parse(Start);
		} catch (ParseException e) {
			System.out.print("Niew³aœciwy format daty pocz¹tkowej.");
			this.rentInProgress = false;
		}
		try {
			this.returnDate = new SimpleDateFormat("yyyyMMdd").parse(End);
		} catch (ParseException e) {
			System.out.print("Niew³aœciwy format daty koñcowej.");
			this.rentInProgress = false;
		}
		this.carType = cartype;
		this.client = client;
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

	public int GetSeatCost() {
		return 1000;
	}

	public int GetRackCost() {
		return 1000;
	}

	public long getlength() {
		long diffInMillies = Math.abs(returnDate.getTime() - rentalDate.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return diff + 1;
	}
}