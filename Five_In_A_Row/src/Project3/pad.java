package Project3;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class pad extends Panel implements MouseListener, ActionListener{

	Button button1 = new Button("Enter");
	TextField text = new TextField("Enter player1's name");
	WhosTurn current_color; // 1=>black  2=>white
	int[][] judge;
	FindWinner findW;
	int butt_count =0;
	String player1, player2;
	String temp;
	
	pad() {
		current_color = new WhosTurn();
		judge =new int[22][22];
		for(int i=0; i<22; i++)   //initialize judge
			for(int j=0; j<22; j++)
				judge[i][j]=0;
		findW = new FindWinner(judge);
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		text.setFont(font1);
		setLayout(null);
		add(button1);
		add(text);
		button1.setBounds(200, 650, 80, 30);
        text.setBounds(300, 650, 250, 35);
        setSize(660, 690);
	    setBackground(Color.pink);
		
		addMouseListener(this);
		button1.addActionListener(this);
		text.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseClicked(java.awt.event.MouseEvent e) {
			 text.setText("");}
			   });
		
	}
	public void paint(Graphics g) {
		for(int i = 30; i<=630; i+=30) {
			g.drawLine(30, i, 630, i);
		}
		for(int i = 30; i<=630; i+=30) {
			g.drawLine(i, 30, i, 630);
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getModifiers()==InputEvent.BUTTON1_MASK) {
			int x=e.getX();
			int y=e.getY();
		    int a = (x+15)/30;
		    int b = (y+15)/30;
		    
		    if(a<1||a>21||b<1||b>21||butt_count<2){} //out of the board and do nothing
		    else {
		    	if(current_color.getCurrentColor()==1 && judge[a][b]==0) {
		    		judge[a][b]=1;
		    		ChessBlack blackpoint = new ChessBlack(this, current_color, a, b);
		    		add(blackpoint);
		    		blackpoint.setBounds(a*30-12, b*30-12, 24, 24);
		  
		    		if(findW.FindWin(a, b, current_color.getCurrentColor())==true) {
		    			for(int i=0; i<22; i++)   //initialize judge
		    				for(int j=0; j<22; j++)
		    					judge[i][j]=0;
		    			JOptionPane.showMessageDialog(null, player1 + " WIN!!!");
		    			this.removeAll();
		    			
		    			add(button1);
		    			add(text);
		    			button1.setBounds(200, 650, 80, 30);
		    	        text.setBounds(300, 650, 250, 35);
		    	        if(Math.random()>0.5) {
		    				temp=player1;
		    				player1=player2;
		    				player2=temp;
		    			}
		    	        current_color.init();
		    	        text.setText(player1+" first");
		    	        ChessBlack.back=0;
		    		}
		    		else {
		    			current_color.changeColor();
		    			text.setText(player2+"'s turn.");
		    		}
		    		
		    	}
		    	else if(current_color.getCurrentColor()==2 && judge[a][b]==0) {
		    		judge[a][b]=2;
		    		ChessWhite whitepoint = new ChessWhite(this);
		    		add(whitepoint);
		    		whitepoint.setBounds(a*30-12, b*30-12, 24, 24);
                    if(findW.FindWin(a, b, current_color.getCurrentColor())==true) {
                    	for(int i=0; i<22; i++)   //initialize judge
		    				for(int j=0; j<22; j++)
		    					judge[i][j]=0;
                    	JOptionPane.showMessageDialog(null, player2 + " WIN!!!");
		    			this.removeAll();
		    			
		    			add(button1);
		    			add(text);
		    			button1.setBounds(200, 650, 80, 30);
		    	        text.setBounds(300, 650, 250, 35);
		    	        if(Math.random()>0.5) {
		    				temp=player1;
		    				player1=player2;
		    				player2=temp;
		    			}
		    	        current_color.init();
		    	        text.setText(player1+" first");
		    	        ChessBlack.back=0;
		    		}
		    		else {
		    			current_color.changeColor();
		    			text.setText(player1+"'s turn.");
		    		}
		    	}
		    }
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(butt_count==0) {
			player1 = text.getText().toString();
			text.setText("Enter player2's name");
			butt_count++;
		}	
		else if (butt_count==1) {
			player2 = text.getText().toString();
			if(Math.random()>0.5) {
				temp=player1;
				player1=player2;
				player2=temp;
			}
	        current_color.init();
	        text.setText(player1+" first");
			butt_count++;
			text.setEnabled(false);
			button1.setLabel("New Game");
		}
		else {
			this.removeAll();
			add(button1);
			add(text);
			button1.setBounds(200, 650, 80, 30);
	        text.setBounds(300, 650, 250, 35);
	        if(Math.random()>0.5) {
				temp=player1;
				player1=player2;
				player2=temp;
			}
	        current_color.init();
	        text.setText(player1+" first");
	    	for(int i=0; i<22; i++)   //initialize judge
				for(int j=0; j<22; j++)
					judge[i][j]=0;
	    	ChessBlack.back=0;
		}
	}
	
	
}
