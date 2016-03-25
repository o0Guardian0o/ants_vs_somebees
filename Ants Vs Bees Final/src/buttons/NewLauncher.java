package buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import core.AntGame.ImageUtils;

public class NewLauncher extends JFrame {
	
	private static int food = 8;
	private static int tunnels = 5;
	private static int galleries = 2;


	
	public NewLauncher() {
	}
	
	private static JFrame launcher = new JFrame();
	private static JFrame options = new JFrame();
	private static JFrame level = new JFrame();
	
	
	public void printLauncher() {
		
		launcher.setTitle("Ants Vs Somes Bees : the game");
		launcher.setSize(500,500);
		launcher.setResizable(false);
		launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		launcher.setLocationRelativeTo(null);
		
		JPanel back = new JPanel() {
			
			protected void paintComponent(Graphics g) {
				super.paintComponents(g);
				Image fond = ImageUtils.loadImage("img/fondlauncher.png");
				Graphics2D g2d = (Graphics2D) g;
				g2d.drawImage(fond,0,0,null);
			}
		};

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
	
		back.add(Box.createRigidArea(new Dimension(0,200)));
		back.add(play);
		back.add(Box.createRigidArea(new Dimension(0,30)));
		back.add(option);
		back.add(Box.createRigidArea(new Dimension(0,30)));
		back.add(leave);
		
		launcher.setContentPane(back);
		launcher.setVisible(true);
		launcher.repaint();
		
		
	}
	
	public int getFood() {
		return this.food;
	}
	
	public int getTunnels() {
		return this.tunnels;
	}
	
	public int getGalleries() {
		return this.galleries;
	}
	
	public void setFood(int food) {
		this.food = food;
	}
	
	public void setTunnels(int tunnels) {
		this.tunnels = tunnels;
	}
	
	public void setGalleries(int galleries) {
		this.galleries = galleries;
	}
	
	public void printFenetreOptions() {
		
		options.setVisible(false);
		options.setVisible(true);
		options.setTitle("Options");
		options.setSize(500,500);
		options.setResizable(false);
		options.setLocationRelativeTo(null);
		options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
	
		JPanel background = new JPanel() {
			
			protected void paintComponent(Graphics g) {
				super.paintComponents(g);
				Image fond = ImageUtils.loadImage("img/fondoptions.gif");
				Graphics2D g2d = (Graphics2D) g;
				g2d.drawImage(fond,0,0,null);
			}
		};
		
		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
		
		JPanel sliderfood = new JPanel();
		sliderfood.setLayout(new BoxLayout(sliderfood, BoxLayout.LINE_AXIS));		
		JSlider cursorfood = new JSlider(6,14,getFood());
		cursorfood.setMajorTickSpacing(1);
		cursorfood.setPaintTicks(true);
		cursorfood.setPaintLabels(true);
		sliderfood.add(cursorfood);
	
		JPanel slidertunnels = new JPanel();
		slidertunnels.setLayout(new BoxLayout(slidertunnels, BoxLayout.LINE_AXIS));		
		JSlider cursortunnels = new JSlider(4,8,getTunnels());
		cursortunnels.setMajorTickSpacing(1);
		cursortunnels.setPaintTicks(true);
		cursortunnels.setPaintLabels(true);
		slidertunnels.add(cursortunnels);
	
		JPanel slidergalleries = new JPanel();
		slidergalleries.setLayout(new BoxLayout(slidergalleries, BoxLayout.LINE_AXIS));		
		JSlider cursorgalleries = new JSlider(1,5,getGalleries());
		cursorgalleries.setMajorTickSpacing(1);
		cursorgalleries.setPaintTicks(true);
		cursorgalleries.setPaintLabels(true);
		slidergalleries.add(cursorgalleries);
	
		cursorfood.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent event) {
			setFood(cursorfood.getValue());
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
		background.add(new JLabel("<html><b>Galleries (infinite)</b></html>"));
		background.add(Box.createRigidArea(new Dimension(0,10)));
		background.add(slidergalleries);
		background.add(Box.createRigidArea(new Dimension(0,30)));
		background.add(new JLabel("<html><b>Tunnels (infinite)</b></html>"));
		background.add(Box.createRigidArea(new Dimension(0,10)));
		background.add(slidertunnels);
		background.add(Box.createRigidArea(new Dimension(0,30)));
		background.add(new JLabel("<html><b>Nourriture (tous niveau)</b></html>"));
		background.add(Box.createRigidArea(new Dimension(0,10)));
		background.add(sliderfood);
		background.add(Box.createRigidArea(new Dimension(0,30)));
		background.add(endbutton);
		background.setOpaque(true);
	
	options.setContentPane(background);
	
	}
	
	public void printLevel() {
		
		level.setVisible(true);
		level.setTitle("Selection du niveau");
		level.setSize(800,300);
		level.setResizable(false);
		level.setLocationRelativeTo(null);
		level.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel background = new JPanel() {
		
		protected void paintComponent(Graphics g) {
			super.paintComponents(g);
			Image fond = ImageUtils.loadImage("img/fondlevel.gif");
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(fond,0,0,null);
		}
		};
		
		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
		
		JPanel buttons = new JPanel();
		buttons.setOpaque(true);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
		buttons.add(new ButtonLvl1("Level 1"));
		buttons.add(new ButtonLvl2("Level 2"));
		buttons.add(new ButtonLvl3("Level 3"));
		buttons.add(new ButtonLvl4("Infinite"));
		
		JPanel retour = new JPanel();
		retour.setLayout(new BoxLayout(retour, BoxLayout.LINE_AXIS));
		retour.add(new ButtonBackLaunch("Retour"));
		
		
		
		background.add(Box.createRigidArea(new Dimension(10,100)));
		background.add(buttons);
		background.add(Box.createRigidArea(new Dimension(10,40)));
		background.add(retour);
		background.setOpaque(true);
		
		level.setContentPane(background);
		level.repaint();
	}
	
	public void defLauncher() {
		launcher.dispose();
	}
	
	public void defOptions() {
		options.dispose();
	}
	
	public void defLevel() {
		level.dispose();
	}
	
}
