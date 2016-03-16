package core;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Dimension;

public class Launcher extends JFrame {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private static int food = 9;
		private static int tunnels = 6;
		private static int galleries = 3;
		
		public Launcher() {
		

			this.setTitle("Ants Vs Somes Bees : the game");
			this.setSize(500,500);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
		
			JPanel back = new JPanel();
			back.setLayout(new BoxLayout(back, BoxLayout.PAGE_AXIS));

		
			JPanel play = new JPanel();
			play.setLayout(new BoxLayout(play, BoxLayout.LINE_AXIS));		
			JButton boutonplay = new ButtonPlay("Jouer");
			play.add(boutonplay);
		
			JPanel option = new JPanel();
			option.setLayout(new BoxLayout(option, BoxLayout.LINE_AXIS));
			JButton boutonoption = new ButtonOptions("Options");
			option.add(boutonoption);
		
			JPanel leave = new JPanel();
			leave.setLayout(new BoxLayout(leave, BoxLayout.LINE_AXIS));
			JButton boutonleave = new ButtonLeave("Quitter");
			leave.add(boutonleave);
		
			back.add(Box.createRigidArea(new Dimension(0,20)));
			back.add(play);
			back.add(Box.createRigidArea(new Dimension(0,30)));
			back.add(option);
			back.add(Box.createRigidArea(new Dimension(0,30)));
			back.add(leave);
			
			this.setVisible(true);
			this.repaint();
			

		
		
			this.setContentPane(back);	
		}
		
		public int getFood() {
			return food;
		}
		
		public int getTunnels() {
			return tunnels;
		}
		
		public int getGalleries() {
			return galleries;
		}
		
		public void setFood(int foods) {
			food = foods;
		}
		
		public void setTunnels(int tunnel) {
			tunnels = tunnel;
		}
		
		public void setGalleries(int gallerie) {
			galleries = gallerie;
		}
		
		
		
}
	

