package car_rental;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class main_ {
	public static final void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			Client client1 = new Client();
			client1.name = "Klient1";
			client1.loyalty_program = true;
			Booking booking1 = new Booking("20161111", "20161112", "ANY", client1);
			booking1.freeExtra = "babySeat";
			booking1.rackChosen = true;
			booking1.babySeatChosen = true;
			kSession.insert(booking1);
			kSession.fireAllRules();
			CarReturn return1 = new CarReturn("20161112", booking1);
			return1.distance = 66;
			if (return1.rentInProgress == true) {
				kSession.insert(return1);
				kSession.fireAllRules();
			}

			Client client2 = new Client();
			client2.name = "Klient2";
			client2.loyalty_program = false;
			Booking booking2 = new Booking("2016117", "20161110", "B", client2);
			booking2.rackChosen = true;
			kSession.insert(booking2);
			kSession.fireAllRules();
			CarReturn return2 = new CarReturn("20161110", booking2);
			return2.distance = 100;
			if (return2.rentInProgress == true) {
				kSession.insert(return2);
				kSession.fireAllRules();
			}
			Client client3 = new Client();
			client3.name = "Klient3";
			client3.loyalty_program = false;
			Booking booking3 = new Booking("20161111", "20161116", "B", client3);
			kSession.insert(booking3);
			kSession.fireAllRules();
			CarReturn return3 = new CarReturn("20161118", booking3);
			return3.distance = 1000;
			return3.capsLost = 2;
			return3.registrationLost = true;
			if (return3.rentInProgress == true) {
				kSession.insert(return3);
				kSession.fireAllRules();
			}

			Client client4 = new Client();
			client4.name = "Klient4";
			client4.loyalty_program = true;
			Booking booking4 = new Booking("20161109", "20161117", "ANY", client4);
			booking4.rackChosen = true;
			kSession.insert(booking4);
			kSession.fireAllRules();
			CarReturn return4 = new CarReturn("20161117", booking4);
			return4.distance = 1000;
			return4.capsLost = 2;
			return4.registrationLost = true;
			return4.policyLost = true;
			if (return4.rentInProgress == true) {
				kSession.insert(return4);
				kSession.fireAllRules();
			}

			Client client5 = new Client();
			client5.name = "Klient5";
			client5.loyalty_program = true;
			Booking booking5 = new Booking("20161108", "20161119", "D", client5);
			booking5.rackChosen = true;
			kSession.insert(booking5);
			kSession.fireAllRules();
			CarReturn return5 = new CarReturn("20161119", booking5);
			return5.distance = 1000;
			if (return5.rentInProgress == true) {
				kSession.insert(return5);
				kSession.fireAllRules();
			}
			Client client6 = new Client();
			client6.name = "Klient5";
			client6.loyalty_program = true;
			Booking booking6 = new Booking("20161108", "20161119", "B", client6);
			booking6.rackChosen = true;
			kSession.insert(booking6);
			kSession.fireAllRules();
			CarReturn return6 = new CarReturn("20161119", booking6);
			return6.distance = 1000;
			if (return6.rentInProgress == true) {
				kSession.insert(return6);
				kSession.fireAllRules();
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}