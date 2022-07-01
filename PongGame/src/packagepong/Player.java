package packagepong;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {

	private Pong pong;
	private int up,down;
	private int x,y,ya;
	private int height=100,width=10;
	
	public Player(Pong pong, int up, int down, int x) {
		this.x=x;
		this.up=up;
		y=pong.getHeight()/2-50;
		this.down=down;
		this.pong=pong;
	}
	
	public void update() {
		if(y>0 && y< pong.getHeight()-height) {
			y+=ya;
		}
		else if(y==0) {
			y++;
		}
		else if(y==pong.getHeight()-height) {
			y--;
		}}
	
	public void pressed(int command) {
		if(command==up) {
			ya=-1;
		}
		else if(command==down) {
			ya=1;
		}
		else {
			ya=0;
		}	
	}
	public void released(int command) {
		if(command == up || command ==down) {
		ya=0;
	}}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
		
	}
	
	public void Paint(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	
}
