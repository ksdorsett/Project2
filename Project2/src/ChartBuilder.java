//Kevin Dorsett
//Project 1
//Software Engineering

import java.util.Scanner;

import csci348.drawings.SimpleDrawing;

/**
 *
 * @author kdorsett
 */


public class ChartBuilder{
	static void drawLineOutside(Board board){
		if(board.getSize().getWidth()+20<=SimpleDrawing.MAX_WIDTH){
			board.addShape(new Line((int)board.getSize().getWidth()+10, 0, (int)board.getSize().getWidth()+10, (int)board.getSize().getHeight()));
			System.out.println("Line drawn outside frame from ("+((int)board.getSize().getWidth()+10)+", 0) to "+((int)board.getSize().getWidth()+10)+", "+(int)board.getSize().getHeight()+").");
		}else if(board.getSize().getHeight()+20<=SimpleDrawing.MAX_HEIGHT){
			board.addShape(new Line(0,(int)board.getSize().getHeight()+10, (int)board.getSize().getWidth(), (int)board.getSize().getHeight()+10));
			System.out.println("Line drawn outside frame from (0, "+((int)board.getSize().getHeight()+10)+") to ("+(int)board.getSize().getWidth()+", "+((int)board.getSize().getHeight()+10)+").");
		}else{
			System.out.println("Cannot draw line outside screen, screen is too big.");
		}
	}
    

	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Scanner scan=new Scanner(System.in);
    	while(true){
    	System.out.println("What size window would you like? Type a width and height...");
    	int WIDTH=scan.nextInt();
    	int HEIGHT=scan.nextInt();
    	if (WIDTH>SimpleDrawing.MAX_WIDTH){
    		System.out.println("Width cannot be greater than "+SimpleDrawing.MAX_WIDTH);
    	}
    	if (HEIGHT>SimpleDrawing.MAX_HEIGHT){
    		System.out.println("Height cannot be greater than "+SimpleDrawing.MAX_HEIGHT);
    	}
    	if (!(WIDTH>SimpleDrawing.MAX_WIDTH)&&!(HEIGHT>SimpleDrawing.MAX_HEIGHT)){
    		Board testBoard=new Board(WIDTH,HEIGHT);
    		drawLineOutside(testBoard);
    		System.out.println("Click on the tools to draw shapes. \n"
        			+ "Most shapes are drawn by clicking two locations. \n"
        			+ "Parallelograms are drawn by clicking three.\n"
        			+ "When no tool is selected left click to delete the top shape at a point\n"
        			+ "or right click to delete all shapes at a point.\n"
        			+ "Type a foreground and background color then press enter to change the colors.\n"
        			+ "Type stop to stop changing colors.");
        	while(true){
        	String foreground=scan.next();
        	if (foreground.equals("stop")){break;}
        	String background=scan.next();
        	if (background.equals("stop")){break;}
        	testBoard.changeColors(foreground,background);
        	}
        	System.out.println("No longer changing colors.");
        	scan.close();
        	break;
        	}
    	}
    }
}