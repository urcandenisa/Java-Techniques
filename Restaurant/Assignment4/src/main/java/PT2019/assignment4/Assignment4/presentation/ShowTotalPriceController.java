package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public class ShowTotalPriceController{
	private ShowTotalPrice successView;
	private Restaurant restaurant;

	public ShowTotalPriceController(ShowTotalPrice successView,Restaurant restaurant) {
		this.successView = successView;
		this.restaurant = restaurant;
		
		successView.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == successView.getGoBack()) {
				successView.setVisible(false);
				
				
				
			}
			if(e.getSource() == successView.getViewAll()) {
				successView.setVisible(false);
				ComputePriceView computePriceView = new ComputePriceView(restaurant);
				ComputePriceViewController cont = new ComputePriceViewController(computePriceView, restaurant);
				computePriceView.setVisible(true);
			}
		}

	}

}
