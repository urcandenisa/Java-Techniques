package PT2019.assignment2.Assignment2.model;

import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import PT2019.assignment2.Assignment2.view.View;

public class Queue implements Runnable {
	private long qID;
	public String simulation;
	private AtomicInteger totalWaitingTime;
	private AtomicInteger clientsPerQueue;
	private PriorityBlockingQueue<Client> queue;
	View view;

	public Queue(long qID, View view) {
		this.view = view;
		this.qID = qID;
		this.simulation = "";
		this.clientsPerQueue = new AtomicInteger();
		this.totalWaitingTime = new AtomicInteger();
		view.getSim().get((int) this.qID).setText("");
		queue = new PriorityBlockingQueue<Client>(10, new Comparing());
	}

	public synchronized void addClient(Client client) {
		notifyAll();
		this.clientsPerQueue.set(clientsPerQueue.get() + 1);
		
		if (this.queue.isEmpty() == true) {
			this.totalWaitingTime.set((int) this.longValue(client.getServiceTime()));
		} else
			this.totalWaitingTime.set((int) (this.totalWaitingTime.get() + this.longValue(client.getServiceTime())));
		try {
			Thread.sleep(300);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		queue.put(client);
	}

	public AtomicInteger getClientsPerQueue() {
		return clientsPerQueue;
	}

	public void setClientsPerQueue(AtomicInteger clientsPerQueue) {
		this.clientsPerQueue = clientsPerQueue;
	}

	public long getLength() {
		if (this.queue.isEmpty())
			return 0;
		return queue.size();
	}

	public long getqID() {
		return qID;
	}

	public void setqID(long qID) {
		this.qID = qID;
	}

	public BlockingQueue<Client> getQueue() {

		return queue;
	}

	public void setQueue(BlockingQueue<Client> queue) {
		this.queue = (PriorityBlockingQueue<Client>) queue;
	}

	public AtomicInteger getTotalWaitingTime() {
		return totalWaitingTime;
	}

	public void setTotalWaitingTime(AtomicInteger totalWaitingTime) {
		this.totalWaitingTime = totalWaitingTime;
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

	public void run() {
		boolean waited = false;
		Client firstClient = null;
		Client beforeClient = null;
		long waitingTime = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", Locale.US);
		while (true) {
			if (this.queue.isEmpty() == false) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				firstClient = queue.poll();
				if (waited == false) {
					waitingTime = this.longValue(firstClient.getServiceTime());
					beforeClient = firstClient;
					waited = true;
				} else {
					if (beforeClient.getFinishTime().after(firstClient.getArrivingTime())) {
						waitingTime = - this.longValue(firstClient.getArrivingTime()) + this.longValue(beforeClient.getFinishTime()) + this.longValue(firstClient.getServiceTime());
						firstClient.setFinishTime(this.dateValue(this.longValue(firstClient.getFinishTime()) + waitingTime));
						beforeClient = firstClient;
					}
					else {
						waitingTime = this.longValue(firstClient.getServiceTime());
						beforeClient = firstClient;
					}
				}
				view.getTextArea().append("Client " + firstClient + "\n");
				view.getSim().get((int) this.qID).setText(view.getSim().get((int) this.qID).getText() + " * ");
				view.getSim().get((int)this.qID).revalidate();
			
				try {
					Date date = formatter.parse((waitingTime) / 3600 + ":" + (waitingTime) % 3600 / 60 + ":" + (waitingTime) % 60);
					try {
						Thread.sleep(5*longValue(firstClient.getServiceTime()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					view.getTextArea().append("Client " + firstClient + " goes out after " + formatter.format(date) + "\n"); /// fa o functie care sa mearga pana la \n sa gasesti lungimea 
					view.getSim().get((int) this.qID).setText(view.getSim().get((int)this.qID).getText().toString().substring(0, view.getSim().get((int)this.qID).getText().toString().length()/3 -1));
					view.getSim().get((int)this.qID).revalidate();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public String toString() {
		String qe = "";
		for (Client client : queue) {
			qe += client.toString() + "\n";
		}
		return qe;
	}
	
	public static void main(String[] args) {
		Queue q = new Queue(1, new View());
		q.addClient(new Client(0,200));
		q.addClient(new Client(0,200));
		System.out.println(q.getTotalWaitingTime());
		
	}
}
