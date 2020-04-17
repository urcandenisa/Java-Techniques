package PT2019.assignment2.Assignment2.model;

import java.util.*;

import PT2019.assignment2.Assignment2.view.View;

public class Queues {
	private int numberOfQueues;
	private HashMap<Integer, Queue> queues;
	private View view;
	public Queues(int numberOfQueues, View view) {
		this.numberOfQueues = numberOfQueues;
		this.view = view;
		queues = new HashMap<Integer, Queue>();
		int i = 0;
		while (i < numberOfQueues) {
			Queue queue = new Queue(i, view);
			queues.put(i, queue);
			++i;
		}
	}

	public void addQueue(Integer integer, Queue queue) {
		queues.put(integer, queue);
	}

	public int getNumberOfQueues() {
		return numberOfQueues;
	}

	public void setNumberOfQueues(int numberOfQueues) {
		this.numberOfQueues = numberOfQueues;
	}

	public synchronized long getMinimalQueue() { // pentru ca la coada asta se pune clientul
		long minimalLengthQueue = queues.get(0).getLength();
		long minimalQueue = 0;
		for (Map.Entry<Integer, Queue> entry : queues.entrySet()) {
			if (entry.getValue().getLength() < minimalLengthQueue) {
				minimalLengthQueue = entry.getValue().getLength();
				minimalQueue = entry.getKey();
			}
		}
		return minimalQueue;
	}
	 
	@Override
	public synchronized String toString() {
		String s = "";
		for (Map.Entry<Integer, Queue> entry : queues.entrySet()) {
			s += "Coada " + entry.getKey() + " contine: \n" + entry.getValue().toString();
		}
		return s;
	}

	public HashMap<Integer, Queue> getQueues() {
		return queues;
	}

	public void setQueues(HashMap<Integer, Queue> queues) {
		this.queues = queues;
	}
}
