package buttons;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import core.AntColony;
import core.AntGame;
import core.GamePoint;
import core.Hive;

import javax.imageio.ImageIO;

import java.io.File;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ButtonPlay extends JButton implements MouseListener {
	
	private String name;
	private Image img;
	
	public ButtonPlay (String str) {
		super(str);
		this.name = str;
		try {
			this.img = ImageIO.read(new File("img/buttonClean.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g2.setFont(new Font("default",Font.BOLD, 12));
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
		NewLauncher launch = new NewLauncher();
		launch.printLevel();
		launch.defLauncher();
	}
}
