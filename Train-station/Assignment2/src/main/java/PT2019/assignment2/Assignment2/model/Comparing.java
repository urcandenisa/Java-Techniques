package PT2019.assignment2.Assignment2.model;
import java.util.Comparator;

public class Comparing implements Comparator<Client>{

	@Override
	public int compare(Client o1, Client o2) {
		// TODO Auto-generated method stub
		int firstHour = o1.getArrivingTime().getHours() * 3600 + o1.getArrivingTime().getMinutes()*60 + o1.getArrivingTime().getSeconds();
		int secondHour = o2.getArrivingTime().getHours() * 3600 + o2.getArrivingTime().getMinutes()*60 + o1.getArrivingTime().getSeconds();
		return (int) firstHour - secondHour;
	}
}
