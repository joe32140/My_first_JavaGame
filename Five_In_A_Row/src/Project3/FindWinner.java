package Project3;

public class FindWinner {
    int[][] judge;
    FindWinner(int[][] judge) {
    	this.judge=judge;
    }
    public boolean FindWin(int a, int b, int current_color) {
    	int count=0;
    	// Left top - Right bottom
    	for(int i=a-1, j=b-1; i>0 && j>0; i--, j--) {
    		if(judge[i][j]==current_color) {
    			count++;
    		}
    		else
    			break;
    	}
    	for(int i=a+1, j=b+1; i<22 && j<22; i++, j++) {
    		if(judge[i][j]==current_color) {
    			count++;
    		}
    		else
    			break;
    	}
    	if(count>=4)
    		return true;
    	else
    		count=0;
    	// Left bottom - Right top
    	for(int i=a-1, j=b+1; i>0 && j<22; i--, j++) {
    		if(judge[i][j]==current_color) {
    			count++;
    		}
    		else
    			break;
    	}
    	for(int i=a+1, j=b-1; i<22 && j>0; i++, j--) {
    		if(judge[i][j]==current_color) {
    			count++;
    		}
    		else
    			break;
    	}
    	if(count>=4)
    		return true;
    	else
    		count=0;
    	//Horizontal
    	for(int i=a-1, j=b; i>0; i--) {
    		if(judge[i][j]==current_color) {
    			count++;
    		}
    		else
    			break;
    	}
    	for(int i=a+1, j=b; i<22 ; i++) {
    		if(judge[i][j]==current_color) {
    			count++;
    		}
    		else
    			break;
    	}
    	if(count>=4)
    		return true;
    	else
    		count=0;
    	//Vertical
    	for(int i=a, j=b+1; j<22;j++) {
    		if(judge[i][j]==current_color) {
    			count++;
    		}
    		else
    			break;
    	}
    	for(int i=a, j=b-1;  j>0;  j--) {
    		if(judge[i][j]==current_color) {
    			count++;
    		}
    		else
    			break;
    	}
    	if(count>=4)
    		return true;
    	else
    		return false;
    }
}
