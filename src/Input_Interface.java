import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Input_Interface {

	private JFrame frame;
	private JTextField floorSize;
	private JTextField numberOfPeople;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Input_Interface window = new Input_Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Input_Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Run");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Floor_Interface floorInterface = new Floor_Interface();
				floorInterface.NewScreen();
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(51, 153, 0));
		btnNewButton.setBounds(251, 411, 155, 43);
		frame.getContentPane().add(btnNewButton);
		
		floorSize = new JTextField();
		floorSize.setBounds(201, 126, 257, 35);
		frame.getContentPane().add(floorSize);
		floorSize.setColumns(10);
		
		numberOfPeople = new JTextField();
		numberOfPeople.setBounds(201, 199, 257, 35);
		frame.getContentPane().add(numberOfPeople);
		numberOfPeople.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Please enter your floor size:");
		lblNewLabel.setBounds(201, 105, 257, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("How many people on your floor?");
		lblNewLabel_1.setBounds(201, 180, 257, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox numberOfExit = new JComboBox();
		numberOfExit.addItem(1);
		numberOfExit.addItem(2);
		numberOfExit.addItem(3);
		numberOfExit.addItem(4);
		numberOfExit.addItem(5);
		numberOfExit.addItem(6);
		numberOfExit.addItem(7);
		numberOfExit.addItem(8);
		numberOfExit.setSelectedItem(null);
		
		numberOfExit.setBounds(201, 277, 257, 35);
		frame.getContentPane().add(numberOfExit);

		
		JLabel lblNewLabel_2 = new JLabel("How many exits you need on the floor?");
		lblNewLabel_2.setBounds(201, 256, 257, 21);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
