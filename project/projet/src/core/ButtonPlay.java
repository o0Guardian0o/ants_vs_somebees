package core;
import javax.imageio.ImageIO;
import javax.swing.JButton;

import java.io.File;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Graphics;

public class ButtonPlay extends JButton implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Image img;
	
	public ButtonPlay (String str) {
		super(str);
		this.name = str;
		try {
			this.img = ImageIO.read(new File("buttonClean.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g2.setColor(Color.black);
		g2.drawString(this.name, this.getWidth() / 2 - (this.getWidth() / 2 / 2), (this.getHeight() / 2) + 5);
	}
	
	public void mouseEntered(MouseEvent event) {
	}
	
	public void mouseExited(MouseEvent event) {
	}
	
	public void mousePressed(MouseEvent event) {
	}
	
	public void mouseReleased(MouseEvent event) {
	}
	
	public void mouseClicked(MouseEvent event) {
		FenetreOptions start = new FenetreOptions();
		GamePoint gamepoint = new GamePoint();
		AntColony colony = new AntColony(start.getGalleries(), start.getTunnels(), 3, start.getFood()); // specify the colony ]tunnels, length, moats, food]
		Hive hive = Hive.makeTestHive(); // specify the attackers (the hive)
		new AntGame(colony, hive, gamepoint); // launch the game
	}
}
