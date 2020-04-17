import java.awt.*;
import javax.swing.*;

public class PolynomView extends JFrame{
	
	public PolynomView()
	{
		JPanel panel = new JPanel();
		//panel.setLayout(new BorderLayout());	
		this.setSize(300,400);
		this.setContentPane(panel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{	
		PolynomView view = new PolynomView();
		view.setVisible(true);
	}

}
