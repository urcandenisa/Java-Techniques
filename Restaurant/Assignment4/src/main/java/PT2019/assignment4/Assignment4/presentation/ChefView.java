package PT2019.assignment4.Assignment4.presentation;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

@SuppressWarnings("deprecation")
public class ChefView implements Observer {
	MainView mainView;

	public ChefView(MainView mainView) {
		this.mainView = mainView;
		
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		mainView.getCloudForChef().setVisible(true);
	}

}
