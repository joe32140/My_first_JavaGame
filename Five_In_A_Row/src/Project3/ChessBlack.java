package Project3;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ChessBlack extends Canvas implements MouseListener{
    pad chesspad = null;
    WhosTurn whosturn;
    static int count=0;
    int num;
    public static int back=0;
    int x, y;
    public ChessBlack(pad chesspad, WhosTurn whosturn, int x, int y) {
    	this.chesspad=chesspad;
    	this.whosturn = whosturn;
    	this.x =x;
    	this.y=y;
    	setVisible(true);
    	setSize(24,24);
    	addMouseListener(this);
    	num = count;
    	count++;
    }
	public void paint(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillOval(0, 0, 24, 24);
    }
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()>=2 && back<1 &&num==count-1) {
			chesspad.remove(this);
			whosturn.init();
			back++;
			chesspad.judge[x][y]=0;
			chesspad.text.setText("One more time");
		}
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
