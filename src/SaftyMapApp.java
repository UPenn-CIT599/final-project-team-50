import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaftyMapApp extends JFrame {

	private JFrame frame;
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
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 600);
		
		JLabel lblNewLabel = new JLabel("Please enter your floor size:");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		lblNewLabel.setBounds(201, 105, 257, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("How many people on your floor?");
		lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		lblNewLabel_1.setBounds(201, 180, 257, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("How many exits on the floor?");
		lblNewLabel_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
		lblNewLabel_2.setBounds(201, 256, 257, 21);
		frame.getContentPane().add(lblNewLabel_2);
	

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
		
//		Planner p = new Planner (size, exitAmount, peopleAmount);
//		FloorPlan res = s.provideOptimalFloorPlan(p);
//		
//		new OptimalFloorDesign(res).setVisible(true);
		
	}

	

	private void createTexFieldForSize() {
		floorSize = new JTextField();
		floorSize.setBounds(201, 126, 257, 35);
		frame.getContentPane().add(floorSize);
		floorSize.setColumns(10);
//		floorSize.addActionListener(listener);
		
	}

	private void createTexFieldForPeople() {
		numberOfPeople = new JTextField();
		numberOfPeople.setBounds(201, 199, 257, 35);
		numberOfPeople.setColumns(10);
		frame.getContentPane().add(numberOfPeople);
		numberOfPeople.addActionListener(listener);
	}
		
	private void createJComboBox() {
		numberOfExit = new JComboBox();
		numberOfExit.setBounds(201, 277, 257, 35);
		frame.getContentPane().add(numberOfExit);		
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
		frame.getContentPane().add(RunButton);
		RunButton.addActionListener(listener);	
	}
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SaftyMapApp frame = new SaftyMapApp();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
