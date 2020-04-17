package PT2019.assignment2.Assignment2.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import PT2019.assignment2.Assignment2.controller.Controller;
import PT2019.assignment2.Assignment2.controller.Manager;

public class View extends JFrame {
	private JLabel noOfClients = new JLabel("Number of clients:");
	private JLabel errLabel;
	private JSlider slider;
	private JTextField numberOfClients;
	private JTextArea textArea;
	private JScrollPane scrollArea;
	private JButton start;
	private JButton statistics;
	private JTextArea stat = new JTextArea(20,40);
	private JButton back;
	private ArrayList <JTextField> sim;
	private JPanel thirdPanel;
	Manager model;
	
	public View() {
		stat.setOpaque(false);
		back = new JButton("Back");
		back.setOpaque(false);

		back.setVisible(false);
		
		
		JPanel mainPanel = new JPanel();
		JPanel firstPanel = new JPanel();
		JPanel secondPanel = new JPanel();
		Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
		back.setFont(font);
		JLabel picLabel = new JLabel(new ImageIcon("img.jpg"));
		picLabel.setLayout(new FlowLayout());
		
		noOfClients.setFont(font);
		slider  = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
		slider.setValue(10);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setFont(font);
		slider.setOpaque(false);
		
		numberOfClients = new JTextField(20);
		
		textArea = new JTextArea(20,40);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setFont(font);
		scrollArea = new JScrollPane(textArea);
		scrollArea.getViewport().setOpaque(false);
		scrollArea.setOpaque(false);
		scrollArea.setFont(font);
		
		start = new JButton("Start");
		start.setFont(font);
		start.setBackground(new Color(0,0,1));
		start.setOpaque(false);
		
		errLabel = new JLabel("Bad input. Please try again");
		errLabel.setFont(font);
		
		statistics = new JButton("Statistics");
		statistics.setFont(font);
		statistics.setBackground(new Color(0,0,1));
		statistics.setOpaque(false);
		
		JLabel time = new JLabel("Time of simulation: ");
		time.setFont(font);
		time.setOpaque(false);
		
		firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.Y_AXIS));
		firstPanel.add(time);
		firstPanel.add(Box.createRigidArea(new Dimension(0,4)));
		firstPanel.add(slider);
		firstPanel.add(Box.createRigidArea(new Dimension(0,24)));
		firstPanel.add(noOfClients);
		firstPanel.add(Box.createRigidArea(new Dimension(0,4)));
		firstPanel.add(numberOfClients);
		firstPanel.add(Box.createRigidArea(new Dimension(0,4)));
		firstPanel.add(start);
		firstPanel.add(Box.createRigidArea(new Dimension(0,4)));
		firstPanel.add(Box.createRigidArea(new Dimension(0,24)));
		firstPanel.setSize(new Dimension(500, 300));
		firstPanel.setFont(font);
		firstPanel.setOpaque(false);
		
		secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));
		secondPanel.add(scrollArea);
		secondPanel.add(Box.createRigidArea(new Dimension(0,4)));
		secondPanel.add(statistics);
		secondPanel.setOpaque(false);
		
		thirdPanel = new JPanel();
		thirdPanel.setLayout(new BoxLayout(thirdPanel, BoxLayout.Y_AXIS));
		thirdPanel.setVisible(true);
		thirdPanel.setOpaque(false);
		
		firstPanel.add(thirdPanel);
		picLabel.add(firstPanel);
		picLabel.add(secondPanel);
		//picLabel.add(thirdPanel);
		mainPanel.add(picLabel);
		
		this.setContentPane(mainPanel);
		this.setSize(700, 500);
		this.setLocation(350, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont(font);
		this.setVisible(true);
		this.setTitle("Train station");
		
	}
	
	public static void main(String[] args) {
		View view = new View();
		view.setTextFields(4);	
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JTextArea getStat() {
		return stat;
	}

	public void setStat(JTextArea stat) {
		this.stat = stat;
	}

	public void paint(Manager model) {
		
		this.model = model;
		
		JPanel panel = new JPanel(new FlowLayout());
		Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
		JLabel picLabel = new JLabel(new ImageIcon("img.jpg"));
		
		picLabel.setLayout(new FlowLayout());
		//stat.setOpaque(false);
		stat.setBackground(new Color(0,0,1));
		stat.setEditable(false);
		stat.setFont(font);
		scrollArea = new JScrollPane(stat);
		scrollArea.getViewport().setOpaque(false);
		scrollArea.setOpaque(false);
		scrollArea.setFont(font);
		
		back.setBackground(new Color(0,0,1));
		back.setOpaque(false);
		back.setVisible(true);
		
		picLabel.add(scrollArea);
		picLabel.add(back);
		
		panel.add(picLabel);
		
		this.setContentPane(panel);	
		this.setSize(700, 500);
		this.setLocation(350, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont(font);
		this.setVisible(true);
		this.setTitle("Train station");
	}
	
	public JSlider getSlider() {
		return slider;
	}

	public void setSlider(JSlider slider) {
		this.slider = slider;
	}

	public String getNumberOfClients() {
		return numberOfClients.getText();
	}


	public void showError(String errMesage) {
		errLabel.setText(errMesage);
		JOptionPane.showMessageDialog(this, errLabel);
	}

	public void setNumberOfClients(JTextField numberOfClients) {
		this.numberOfClients = numberOfClients;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(String textArea) {
		this.textArea.append(textArea);
	}

	public JScrollPane getScrollArea() {
		return scrollArea;
	}

	public void setScrollArea(JScrollPane scrollArea) {
		this.scrollArea = scrollArea;
	}

	public JButton getStart() {
		return start;
	}

	public void addListener(ActionListener buttonListener) {
		start.addActionListener(buttonListener);
		statistics.addActionListener(buttonListener);
		back.addActionListener(buttonListener);
	}
	
	public JButton getBack() {
		return back;
	}

	public ArrayList<JTextField> getSim() {
		return sim;
	}

	public void setSim(ArrayList<JTextField> sim) {
		this.sim = sim;
	}

	public void addSliderListener(ChangeListener changeListener) {
		slider.addChangeListener(changeListener);
	}

	public JLabel getErrLabel() {
		return errLabel;
	}
	
	public JButton getStatistics() {
		return statistics;
	}
	
	public void setTextFields(int numberOfQueues) {
		 sim  = new ArrayList<JTextField>();
		 for( int i = 0; i < numberOfQueues; i++) {
			 JTextField t = new JTextField(10);
			 t.setOpaque(false);
			 t.setEditable(false);
			 sim.add(t);
			 thirdPanel.add(sim.get(i));
		 }
	}
	
	public void addTextField(String text, int qId) {
		sim.get(qId).setText(text);
	}
	
	public void reset() {
		View anotherView = new View();
		Controller controller = new Controller(anotherView);
		anotherView.setVisible(true);
	}

}
