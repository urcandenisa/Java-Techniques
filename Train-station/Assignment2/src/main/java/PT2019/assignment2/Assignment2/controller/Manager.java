package PT2019.assignment2.Assignment2.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import PT2019.assignment2.Assignment2.model.*;
import PT2019.assignment2.Assignment2.view.View;

public class Manager implements Runnable {
	private int numberOfClients;
	private int numberOfQueues;
	private int simulationTime;
	private Queues queues;
	private static boolean beggining = true;
	private View view;
	ArrayList<Client> list;

	public Manager(int numberOfClients, int numberOfQueues, int simulationTime, View view) {
		this.numberOfClients = numberOfClients;
		this.numberOfQueues = numberOfQueues;
		this.simulationTime = simulationTime;
		this.view = view;

		list = this.createList();
		queues = new Queues(numberOfQueues, view);
		int i = 0, j = 0;
		
		//this.view.getNumberOfQueues(this.numberOfQueues);
		
		
	}
	
	public static void main(String[] args) {
		View v = new View();
		Manager m = new Manager(7, 2, 200, v);
		Thread t = new Thread(m);
		t.run();
	}
	
	public long longValue(Date date) {
		return date.getHours() * 3600 + date.getMinutes() * 60 + date.getSeconds();
	}

	public Date dateValue(long value) {
		Date date = new Date();
		date.setHours((int) (value / 3600));
		date.setMinutes((int) (value % 3600 / 60));
		date.setSeconds((int) (value % 60));
		return date;
	}
	
	public ArrayList<Client> createList(){
		ArrayList<Client> list = new ArrayList<Client>();
		int i = 0, j = 0, max = 0;
		while (i < numberOfClients) {
			Client client = new Client(++i, simulationTime);
			list.add(client);
		}
		Collections.sort(list);
		return list;
	}
	

	public static boolean isBeggining() {
		return beggining;
	}

	public static void setBeggining(boolean beggining) {
		Manager.beggining = beggining;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0, max = 0, j = 0;while (j < numberOfClients) {
			int position = (int) queues.getMinimalQueue();
			queues.getQueues().get(position).addClient(list.get(j));
			j++;
		}
		try {
			if (beggining == true) {
				view.getStat().append(queues.toString());
				for(i = 0 ; i < numberOfQueues; i++) {
					view.getStat().append("Average waiting time per queue " + String.valueOf(i) + " is: " + queues.getQueues().get(i).getTotalWaitingTime().get()/ 3600 + ":" + queues.getQueues().get(i).getTotalWaitingTime().get() % 3600 / 60 + ":" +queues.getQueues().get(i).getTotalWaitingTime().get() % 60 + "\n");
				}
			}
		} catch (NullPointerException e) {
			view.showError("No clients");
		}
		System.out.println(queues.toString());
		beggining = false;
		Date peekHour = new Date();
		for (i = 0; i < numberOfQueues; i++) {
			(new Thread(queues.getQueues().get(i))).start();
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", Locale.US);
		Date currentTime = new Date(); //this.getQueues().getQueues().get(0).getQueue().peek().getArrivingTime();
		Date finishTime = this.dateValue((this.longValue(currentTime)) + simulationTime);
		while (this.longValue(currentTime) < this.longValue(finishTime)) {
			int nr = 0;
			for(i = 0; i < numberOfQueues; i++) {
				nr += this.getQueues().getQueues().get(i).getClientsPerQueue().get();
			}
			if(nr > max) {
				peekHour = currentTime;
				max = nr;
			}
			currentTime.setSeconds(currentTime.getSeconds() + 1);
		}
		view.getStat().append("Peek hour: " + formatter.format(peekHour));

	}

	public int getNumberOfClients() {
		return numberOfClients;
	}

	public void setNumberOfClients(int numberOfClients) {
		this.numberOfClients = numberOfClients;
	}

	public void setNumberOfQueues(int numberOfQueues) {
		this.numberOfQueues = numberOfQueues;
	}
	
	public int getNumberOfQueues() {
		return numberOfQueues;
	}

	public int getSimulationTime() {
		return simulationTime;
	}

	public void setSimulationTime(int simulationTime) {
		this.simulationTime = simulationTime;
	}

	public Queues getQueues() {
		return queues;
	}

	public void setQueues(Queues queues) {
		this.queues = queues;
	}
}
