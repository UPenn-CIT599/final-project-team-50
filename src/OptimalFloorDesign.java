import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OptimalFloorDesign extends JFrame {
	
	private JPanel tiles;
	private JButton[] buttons;
	
	public JButton getFloorTileButton(int i) {return buttons[i];}
	public JPanel getTilePanel() {return tiles;}
	
	//Constructor builds the panel
	public OptimalFloorDesign(FloorPlan p) {
	
	
		// Create the panel with the floor tiles on it
		createFloorPlanPanel(p);

		// Layout the rest of the window's components
		setupComonnets();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 600);
        setVisible(true);
    }

	//Build the initial tile to show the floor
	private void createFloorPlanPanel (FloorPlan f) {
	
		buttons = new JButton[f.getSize()*f.getSize()];
		tiles = new JPanel();
		tiles.setLayout(new GridLayout(f.getSize(),f.getSize()));
		
		for (int r=0;r<f.getSize();r++) {
			for (int c=0;c<f.getSize();c++) {
				int i=r*f.getSize()+c;
				buttons[i]=new JButton();
				buttons[i].setBorder(BorderFactory.createLineBorder(Color.lightGray));
				if(f.getfloorPlan()[r][c]==2) {buttons[i].setBackground(Color.green);}
				if(f.getfloorPlan()[r][c]==0) {buttons[i].setBackground(Color.white);}
				if(f.getfloorPlan()[r][c]==1) {buttons[i].setBackground(Color.darkGray);}
				tiles.add(buttons[i]);
			}
		}
		
	}
	
	//Here we add all the components to the window
	private void setupComonnets() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints layoutConstraints = new GridBagConstraints();
        getContentPane().setLayout(layout);
        
        layoutConstraints.gridx = 0; layoutConstraints.gridy = 0;
        layoutConstraints.gridwidth = 1; layoutConstraints.gridheight = 6;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.insets = new Insets(2, 2, 2, 2);
        layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
        layoutConstraints.weightx = 1.0; layoutConstraints.weighty = 1.0;
        layout.setConstraints(tiles, layoutConstraints);
        getContentPane().add(tiles);
	}

	
}
