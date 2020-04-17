package PT2019.assignment3.Assignment3.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewAllController{
	ViewAll view;
	public ViewAllController(ViewAll view) {
		this.view = view;
		view.addActionListener(new ButtonListener());
	}
	
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == view.getGoBack()) {
				view.setVisible(false);
				view.reset();
			}
		}
		
	}
}
