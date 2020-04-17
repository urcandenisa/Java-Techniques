package PT2019.assignment2.Assignment2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import PT2019.assignment2.Assignment2.view.View;

public class Controller {
	protected Manager model;
	protected View view;
	int numberOfQueues;

	public Controller(View view) {

		this.view = view;
		numberOfQueues = (int)(Math.random()*5+2);
		view.setTextFields(numberOfQueues);
		view.addSliderListener(new SliderListener());
		view.addListener(new ButtonListener());
	}

	public class SliderListener implements ChangeListener {
		int simulationTime;

		@Override
		public void stateChanged(ChangeEvent e) {
			this.simulationTime = ((JSlider) e.getSource()).getValue();
		}
	}

	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String numberOfClients = null;
			int number = 0;
			
			SliderListener s = new SliderListener();
			if (e.getSource() == view.getStart()) {
				try {
					numberOfClients = view.getNumberOfClients();
					number = Integer.parseInt(numberOfClients);
				} catch (NumberFormatException nfex) {
					view.showError(view.getErrLabel().getText());
				}
				model = new Manager(number, numberOfQueues, s.simulationTime * 10, view);
				
				Thread t = new Thread(model);
				t.start();
			} else if (e.getSource() == view.getStatistics()) {
				Manager.setBeggining(true);
				view.paint(model);
			} else if (e.getSource() == view.getBack()) {
				view.setVisible(false);
				view.reset();
			}
		}
	}
}
