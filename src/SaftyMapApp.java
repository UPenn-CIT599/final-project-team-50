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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

	public class SaftyMapApp extends JFrame {
		private JLabel lblNewLabel;
		private JLabel lblNewLabel_1;
		private JLabel lblNewLabel_2;
		private JTextField floorSize;
		private JTextField numberOfPeople;
		private JComboBox numberOfExit;
		private ActionListener listener;
		private JPanel panel;
		
		private Simulation simulation;
//		private UserInput input;


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
			Planner planner = new Planner (size, exitAmount, peopleAmount);
			Simulation s = new Simulation();
			s.simulate(planner);
		}

		
		

		private void createTexFieldForSize() {
//			floorSize.addActionListener(listener);
			
		}

		private void createTexFieldForPeople() {
		}
			
		private void createJComboBox() {
			
			lblNewLabel = new JLabel("Please enter your floor size:");
			panel.add(lblNewLabel);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
			lblNewLabel.setBounds(201, 126, 257, 21);
			
			floorSize = new JTextField();
			floorSize.setBounds(201, 126, 257, 35);
			panel.add(floorSize);
			floorSize.setColumns(10);
			
			lblNewLabel_1 = new JLabel("How many people on your floor?");
			lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
			lblNewLabel_1.setBounds(201, 180, 257, 21);
			panel.add(lblNewLabel_1);
			numberOfPeople = new JTextField();
			numberOfPeople.setBounds(201, 199, 257, 35);
			numberOfPeople.setColumns(10);
			panel.add(numberOfPeople);
			numberOfPeople.addActionListener(listener);
			
			lblNewLabel_2 = new JLabel("How many exits on the floor?");
			lblNewLabel_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 11));
			lblNewLabel_2.setBounds(201, 256, 257, 21);
			panel.add(lblNewLabel_2);
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
			JButton RunButton = new JButton("RUN");
			panel.add(RunButton);
			RunButton.setBackground(Color.GREEN);
			RunButton.setBounds(251, 411, 155, 43);
			RunButton.addActionListener(listener);	

			//numberOfExit.addActionListener(listener);
		}
		
		private void createButton() {
		}
				
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			SaftyMapApp frame = new SaftyMapApp();
		}
	

}
