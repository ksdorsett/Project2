import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import csci348.drawings.*;

public class Board extends SimpleDrawing{
	private ArrayList<Shape> shapes;
	ToolSelector selector;
	Board(){
		this.shapes=new ArrayList<Shape>();
		this.selector=new ToolSelector();
	}
	Board(int x, int y){
		super(x, y);
		this.shapes=new ArrayList<Shape>();
		this.selector=new ToolSelector();
	}
	
	//Draws all shapes on Drawing
	void drawAllShapes(){ 
		for(int i=0;i<shapes.size();i++){
			shapes.get(i).draw(this);
			}
		}
	
	void printArrayList(){
		for(int i=0;i<shapes.size();i++){
			System.out.println(shapes.get(i));
		}
	}
	
	//Adds to ArrayList and draws
		public void addShape(Shape shape){
			addToArray(shape);
			shape.draw(this);
		}
		
		private void addToArray(Shape shape){
			shapes.add(shape);
		}
		
		//Removes Shape and redraws
		public void removeFromBoard(Shape shape){
			shapes.remove(shape);
			clearBoard();
			drawAllShapes();
		}
		//Removes Shape and redraws
		public void redraw(){
			clearBoard();
			drawAllShapes();
		}
		
		//Clears ArrayList and clears Drawing
		public void clearArray(){
			shapes.removeAll(shapes);
			clearBoard();
		}
		
		private void clearBoard(){
			this.hideAllPoints();
		}
		
		//Delete top most shape at (x,y)
		private void deleteTopAtPoint(int x,int y){
			for(int i=shapes.size()-1;i>=0;i--){
				if(shapes.get(i).pointInside(x, y)){
					removeFromBoard(shapes.get(i));
					break;
				}
			}
		}
		//Delete all shape at (x,y)
		private void deleteAllAtPoint(int x,int y){
			for(int i=shapes.size()-1;i>=0;i--){
				if(shapes.get(i).pointInside(x, y)){
					removeFromBoard(shapes.get(i));
					}
				}
			}
	
		//LeftClick=delete top RightClick=delete all
	@Override
	public void mouseReleased(MouseEvent e){
		if(selector.currentTool==0){
			if (e.getButton()==MouseEvent.BUTTON1){
				deleteTopAtPoint(e.getX(),e.getY());
				}
			if (e.getButton()==MouseEvent.BUTTON3){
				deleteAllAtPoint(e.getX(),e.getY());
				}
		}else{
			selector.mouseClicks.add(e);
			selector.clicksLeft--;
			if(selector.clicksLeft==0){
				addShape(selector.nextShape());
				selector.changeCurrent(0);
			}
		}
	}
	
	@Override
	public void componentResized(ComponentEvent e){
		if(shapes!=null){
			redraw();
		}
	}
	
	//Changes colors--defaults to black on white
	public void changeColors(String foreground, String background) {
		Color fore= Color.BLACK;
		Color back= Color.WHITE;
		if(determineColor(foreground)!=null){fore=determineColor(foreground);}
		if(determineColor(background)!=null){back=determineColor(background);}
		setForegroundColor(fore);
		setBackgroundColor(back);
		
	}
	private Color determineColor(String input) {
		Color returnColor;
		switch(input.toLowerCase()){
		case "black": returnColor=Color.BLACK;
		break;
		case "blue": returnColor=Color.BLUE;
		break;
		case "cyan": returnColor=Color.CYAN;
		break;
		case "dark_gray": returnColor=Color.DARK_GRAY;
		break;
		case "gray": returnColor=Color.GRAY;
		break;
		case "green": returnColor=Color.GREEN;
		break;
		case "light_gray": returnColor=Color.LIGHT_GRAY;
		break;
		case "magenta": returnColor=Color.MAGENTA;
		break;
		case "orange": returnColor=Color.ORANGE;
		break;
		case "pink": returnColor=Color.PINK;
		break;
		case "red": returnColor=Color.RED;
		break;
		case "white": returnColor=Color.WHITE;
		break;
		case "yellow": returnColor=Color.YELLOW;
		break;
		default: returnColor=null;
		break;
		}
		return returnColor;
	}

}
