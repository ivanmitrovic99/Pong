package packagepong;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Field extends JPanel implements ActionListener, KeyListener {

	private Pong pong;
	private Ball ball;
	private Player player1;
	private Player player2;
	private int score1,score2;
	public Field(Pong pong) {
		this.pong=pong;
		ball = new Ball(pong);
		player1=new Player(pong,KeyEvent.VK_UP,KeyEvent.VK_DOWN,0);
		player2= new Player(pong,KeyEvent.VK_W,KeyEvent.VK_S,pong.getWidth()-40);
		Timer timer = new Timer(5,this);
		timer.start();
		addKeyListener(this);
		setFocusable(true);
	}
	
	public Player getPlayer(int num) {
		if(num==1) {
			return player1;
		}
		else return player2;
	}
	
	public void increaseScore(int num) {
		if(num==1) {
			score1++;
		}
		else score2++;
	}
	
	public int getScore(int num) {
		if(num==1) {
			return score1;
		}
		else return score2;
	}
	
	public void update() {
		ball.update();
		player1.update();
		player2.update();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		update();
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		player1.pressed(e.getKeyCode());
		player2.pressed(e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		player1.released(e.getKeyCode());
		player2.released(e.getKeyCode());
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(pong.getField().getScore(1) + ":" + pong.getField().getScore(2), pong.getWidth()/2, 10);
		ball.Paint(g);
		player1.Paint(g);
		player2.Paint(g);
	}

}
