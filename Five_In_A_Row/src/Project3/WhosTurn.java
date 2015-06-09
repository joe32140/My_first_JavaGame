package Project3;

public class WhosTurn {
	int color;
	WhosTurn() {
		color=1;
	}
	public int getCurrentColor(){
		return color;
	}
	public void init(){
		color=1;
	}
	public void changeColor() {
		if(color==1)
			color=2;
		else color=1;
	}
}
