package PT2019.assignment2.Assignment2.model;

import java.text.*;
import java.util.*;

public class Client implements Comparable<Client> {
	private long cID;
	private Date arrivingTime;
	private Date serviceTime;
	private Date finishTime;

	public Client(long cID, int simulationTime) {
		this.cID = cID;
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", Locale.US);
		try {
			this.arrivingTime = formatter.parse(randomGenerateArrivingTime(simulationTime));
			this.serviceTime = formatter.parse(randomGenerateServiceTime());
			int hours = this.arrivingTime.getHours();
			int minutes = this.arrivingTime.getMinutes() + this.serviceTime.getMinutes();
			int seconds = this.arrivingTime.getSeconds() + this.serviceTime.getSeconds();
			String s = hours + ":" + minutes + ":" + seconds;
			this.finishTime = formatter.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	private Date intToDate(int simulationTime) {
		Date simulation = new Date();
		Date today = new Date();
		if (simulationTime < 59) {
			simulation.setMinutes(0);
			simulation.setHours(0);
			simulation.setSeconds(simulationTime);
		} else {
			simulation.setHours(0);
			simulation.setMinutes(simulationTime / 60);
			simulation.setSeconds(simulationTime % 60);
		}
		simulation.setSeconds(simulation.getSeconds() + today.getSeconds());
		simulation.setMinutes(simulation.getMinutes() + today.getMinutes());
		simulation.setHours(today.getHours());
		return simulation;
	}

	private String randomGenerateArrivingTime(int simulationTime) {
		Date simulation = intToDate(simulationTime);
		Date today = new Date();
		int hour, minute, seconds;
		hour = (int) (Math.random() * (simulation.getHours() - today.getHours() + 1) + today.getHours());
		minute = (int) (Math.random() * ((simulation.getMinutes() - today.getMinutes()) + 1)) + today.getMinutes();
		seconds = (int) (Math.random() * 60);
		return hour + ":" + minute + ":" + seconds;
	}

	private String randomGenerateServiceTime() {
		return "00:" + (int) (Math.random() * 20 + 1) + ":" + (int) (Math.random() * 20 + 1);
	}

	public long getcID() {
		return cID;
	}

	public void setcID(long cID) {
		this.cID = cID;
	}

	public Date getArrivingTime() {
		return arrivingTime;
	}

	public void setArrivingTime(Date arrivingTime) {
		this.arrivingTime = arrivingTime;
	}

	public Date getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}

	@Override
	public int compareTo(Client arg0) {
		// TODO Auto-generated method stub
		if (this.arrivingTime.before(arg0.arrivingTime)) {
			return -1;
		}
		return 1;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", Locale.US);
		return cID + ", arrived at " + formatter.format(arrivingTime) + ", service time "
				+ formatter.format(serviceTime) + ", finish time " + formatter.format(finishTime);
	}
}
