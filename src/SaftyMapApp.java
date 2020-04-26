import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaftyMapApp extends JFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField floorSize;
	private JTextField numberOfPeople;
	private JComboBox numberOfExit;
	private ActionListener listener;
	private JPanel panel;
	
	private Simulation s;
//	private UserInput input;


	/**
	 * Create the application.
	 */
	public SaftyMapApp() {
		listener = new ExtractInfoListener();
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(650, 600);
		setVisible(true);

		panel = new JPanel();
		panel.setSize(650, 600);
		getContentPane().add(panel);
		
		lblNewLabel = new JLabel("Please enter your floor size:");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		lblNewLabel.setBounds(201, 105, 257, 21);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("How many people on your floor?");
		lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		lblNewLabel_1.setBounds(201, 180, 257, 21);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("How many exits on the floor?");
		lblNewLabel_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		lblNewLabel_2.setBounds(201, 256, 257, 21);
		panel.add(lblNewLabel_2);
	

		createButton();
		createTexFieldForSize();
		createTexFieldForPeople();
		createTexFieldForSize();
		createJComboBox();

	}

	class ExtractInfoListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			extractInput();
		}
	}

	public void extractInput() {
		int exitAmount = Integer.parseInt(numberOfExit.getSelectedItem().toString()); // take the value user input and store in exitAmount.	
		int size = Integer.parseInt(floorSize.getText());
		int peopleAmount = Integer.parseInt(numberOfPeople.getText());
		
		Planner p = new Planner (size, exitAmount, peopleAmount);
		FloorPlan res = s.getOptimalFloor(s.optimalExitLocation(s.runSimulation(p)));
		
		new OptimalFloorDesign(res).setVisible(true);
		
	}

	

	private void createTexFieldForSize() {
		floorSize = new JTextField();
		floorSize.setBounds(201, 126, 257, 35);
		panel.add(floorSize);
		floorSize.setColumns(10);
//		floorSize.addActionListener(listener);
		
	}

	private void createTexFieldForPeople() {
		numberOfPeople = new JTextField();
		numberOfPeople.setBounds(201, 199, 257, 35);
		numberOfPeople.setColumns(10);
		panel.add(numberOfPeople);
		numberOfPeople.addActionListener(listener);
	}
		
	private void createJComboBox() {
		numberOfExit = new JComboBox();
		numberOfExit.setBounds(201, 277, 257, 35);
		panel.add(numberOfExit);
		numberOfExit.addItem(1);
		numberOfExit.addItem(2);
		numberOfExit.addItem(3);
		numberOfExit.addItem(4);
		numberOfExit.addItem(5);
		numberOfExit.addItem(6);
		numberOfExit.addItem(7);
		numberOfExit.addItem(8);
		numberOfExit.setSelectedItem(null);
		numberOfExit.addActionListener(listener);
	}
	
	private void createButton() {
		JButton RunButton = new JButton("Run");
		RunButton.setForeground(new Color(255, 255, 255));
		RunButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		RunButton.setBackground(new Color(51, 153, 0));
		RunButton.setBounds(251, 411, 155, 43);
		panel.add(RunButton);
		RunButton.addActionListener(listener);	
	}
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SaftyMapApp frame = new SaftyMapApp();
	}
}
