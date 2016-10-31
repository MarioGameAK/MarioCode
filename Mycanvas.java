import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import sun.audio.*;

public class Mycanvas extends Canvas implements KeyListener , MouseListener {
	boolean playmusic = true;
	int x = 10;
	int y = 10;
	int speed = 11;
	Rectangle rect = new Rectangle(200,100,200,300);
	

	// create and load image to file
	Image Mario = Toolkit.getDefaultToolkit().getImage("Mario.png");
	Image MarioBackground = Toolkit.getDefaultToolkit().getImage("MarioBackground.jpg");
	Image Luigi = Toolkit.getDefaultToolkit().getImage("Luigi.png");
	Image Nothing = Toolkit.getDefaultToolkit().getImage("Nothing.png");
	public Mycanvas() {
		this.setSize(1000,800);
		this.repaint();
		this.addKeyListener(this);
		this.addMouseListener(this);

	}

	public void paint(Graphics g) { 
		g.drawImage(MarioBackground, 0, 0, 1500,800, this);
		g.setColor(Color.BLUE);
		g.fillOval(50,50,50,50);
		g.setColor(Color.GREEN);
		g.fillRect(150,150,45,45);
		g.setColor(Color.RED);
		g.fillRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
		g.drawImage(Mario,x,y,100,200,this);
		if (playmusic == true){
			PlayIt("MarioTheme.wav");
			playmusic = false;
		}
	}

	@Override
	public void keyPressed(KeyEvent pressEvent) {
		System.out.println(pressEvent);
		if (pressEvent.getKeyCode() == 39) {
			x = x + 10;
			PlayIt("OkeyDokey.wav");
		}	
		else if (pressEvent.getKeyCode() == 37) {
			x = x - 10;
			PlayIt("OkeyDokey.wav");
		}
		else if (pressEvent.getKeyCode() == 38) {
			y = y - 10;
			PlayIt("OkeyDokey.wav");
		}
		else if (pressEvent.getKeyCode() == 40) {
			y = y + 10;
			PlayIt("OkeyDokey.wav");
		}
		this.repaint();

		if (rect.contains(x,y)) {
			x = 10;
			y = 10;
			this.repaint();
			return;
		}

		if (x > this.getWidth() - 100) {
			x = x - 10;
		}if (x < 0) {
			x = x + 10;
		}if (y < 0) {
			y = y + 10;
		}if (y > this.getHeight() - 200) {
			y = y - 10;
		}this.repaint();

	}


	public static void PlayIt(String filename){
		try {
			InputStream in = new FileInputStream(filename);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
	}	catch (IOException e) {
			System.out.println("can not find file");
		
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
	}

	
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getPoint());	
		 if (rect.contains(x,y)) {
			x = 10;
			y = 10;
			this.repaint();
			return;
		}

		if (x > this.getWidth() - 100) {
			x = this.getWidth() - 100;
			System.out.println("loop");
		}if (x < 0) {
			x = this.getWidth() - 100;
		}if (y < 0) {
			y = this.getHeight() - 200;
		}if (y > this.getHeight() - 200) {
			y = this.getHeight() - 200;
		}this.repaint();
	}


	
	public void mouseEntered(MouseEvent e) {
		System.out.println(e);
	}

	public void mousePressed(MouseEvent e) {
		System.out.println(e);
		x = e.getX();
		y = e.getY();
		PlayIt("OkeyDokey.wav");
		
	
	}

	

	public void mouseReleased(MouseEvent e) {
		System.out.println(e);
	}

	public void mouseExited(MouseEvent e) {
		System.out.println(e);
	}
}


