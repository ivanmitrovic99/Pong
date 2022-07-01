package packagepong;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Ball {
	private Pong pong;
	private int height=30,width=30;
	private int x,y,xa=2,ya=2;
	
	public Ball(Pong pong) {
		this.pong=pong;
		x=pong.getWidth()/2;
		y=pong.getHeight()/2+30;
		}
	
	public void update() {
		
		x+=xa;
		y+=ya;
		
		if(x<8) {
			x=pong.getWidth()/2;
			xa=-xa;
			pong.getField().increaseScore(2);
		}
		
		else if(x>pong.getWidth()-60) {
			x=pong.getWidth()/2;
			xa=-xa;
			pong.getField().increaseScore(1);
		}
		
		else if(y<0 || y>pong.getHeight()-80) {
			ya=-ya;}
	
		if(pong.getField().getScore(1)==5) {
			
			JOptionPane.showMessageDialog(null,"Player 1 wins!","Pong", JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}
		if(pong.getField().getScore(2)==5) {
			JOptionPane.showMessageDialog(null,"Player 2 wins!","Pong", JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}
		
		ballHitCheck();
	}
	
	public void ballHitCheck() {
		if(pong.getField().getPlayer(1).getBounds().intersects(getBounds()) || pong.getField().getPlayer(2).getBounds().intersects(getBounds())) {
			xa=-xa;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
		
	}
	
	
	public void Paint(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(x, y, width, height);
	}
		
	}

