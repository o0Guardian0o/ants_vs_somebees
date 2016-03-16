package core;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FenetreOptions extends Launcher {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FenetreOptions() {

	
	this.setVisible(true);
	this.setTitle("Options");
	this.setSize(500,500);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	JPanel background = new JPanel();
	background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));

	
	JPanel sliderfood = new JPanel();
	sliderfood.setLayout(new BoxLayout(sliderfood, BoxLayout.LINE_AXIS));		
	JSlider cursorfood = new JSlider(6,15,getFood());
	cursorfood.setMajorTickSpacing(1);
	cursorfood.setPaintTicks(true);
	cursorfood.setPaintLabels(true);
	sliderfood.add(cursorfood);
	
	JPanel slidertunnels = new JPanel();
	slidertunnels.setLayout(new BoxLayout(slidertunnels, BoxLayout.LINE_AXIS));		
	JSlider cursortunnels = new JSlider(3,8,getTunnels());
	cursortunnels.setMajorTickSpacing(1);
	cursortunnels.setPaintTicks(true);
	cursortunnels.setPaintLabels(true);
	slidertunnels.add(cursortunnels);
	
	JPanel slidergalleries = new JPanel();
	slidergalleries.setLayout(new BoxLayout(slidergalleries, BoxLayout.LINE_AXIS));		
	JSlider cursorgalleries = new JSlider(1,6,getGalleries());
	cursorgalleries.setMajorTickSpacing(1);
	cursorgalleries.setPaintTicks(true);
	cursorgalleries.setPaintLabels(true);
	slidergalleries.add(cursorgalleries);
	
	cursorfood.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent event) {
			setFood(cursorfood.getValue());
			System.out.println(+getFood());
		}
	});
	
	cursortunnels.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent event) {
			setTunnels(cursortunnels.getValue());
		}
	});
	
	cursorgalleries.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent event) {
			setGalleries(cursorgalleries.getValue());
		}
	});
	
	JPanel endbutton = new JPanel();
	endbutton.setLayout(new BoxLayout(endbutton, BoxLayout.LINE_AXIS));		
	JButton setoption = new ButtonSetOptions("Valider");
	endbutton.add(setoption);
	
	background.add(Box.createRigidArea(new Dimension(0,40)));
	background.add(new JLabel("Galleries"));
	background.add(Box.createRigidArea(new Dimension(0,10)));
	background.add(slidergalleries);
	background.add(Box.createRigidArea(new Dimension(0,30)));
	background.add(new JLabel("Tunnels"));
	background.add(Box.createRigidArea(new Dimension(0,10)));
	background.add(slidertunnels);
	background.add(Box.createRigidArea(new Dimension(0,30)));
	background.add(new JLabel("Nourriture"));
	background.add(Box.createRigidArea(new Dimension(0,10)));
	background.add(sliderfood);
	background.add(Box.createRigidArea(new Dimension(0,30)));
	background.add(endbutton);
	
	

	
	this.setContentPane(background);
	
	}
}
