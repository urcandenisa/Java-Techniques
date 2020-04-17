import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class first {
	public void paintComponent(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame();
		f.setLayout(new GridLayout());
		f.add(new Second());
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);
	}

}
