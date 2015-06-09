package Project3;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ChessWhite extends Canvas implements MouseListener{
    pad chesspad = null;
    public ChessWhite(pad chesspad) {
    	this.chesspad=chesspad;
    	setVisible(true);
    	setSize(24,24);
    }
	public void paint(Graphics g) {
    	g.setColor(Color.WHITE);
    	g.fillOval(0, 0, 24, 24);
    }
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}

}
