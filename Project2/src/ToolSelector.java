import java.awt.event.MouseEvent;
import java.util.ArrayList;

import csci348.drawings.SimpleDrawing;

public class ToolSelector extends SimpleDrawing{
	int currentTool;
	int clicksLeft;
	ArrayList<MouseEvent> mouseClicks;
	
	ToolSelector(){
		super(100,700);
		initialize();
	}
	private void initialize(){
		currentTool=0;
		clicksLeft=0;
		mouseClicks=new ArrayList<MouseEvent>();
		drawTools();
		
	}
	private void drawTools(){
		hideAllPoints();
		new Line(0, 100, 100, 100).draw(this);
		new Line(0, 200, 100, 200).draw(this);
		new Line(0, 300, 100, 300).draw(this);
		new Line(0, 400, 100, 400).draw(this);
		new Line(0, 500, 100, 500).draw(this);
		new Line(0, 600, 100, 600).draw(this);
		
		new Line(20,80,80,20).draw(this);
		new Arrow(20,180,80,120).draw(this);
		new Box(20,220,80,280).draw(this);
		new Circle(30,20,320).draw(this);
		new Diamond(20,450,50,420).draw(this);
		new Parallelogram(20,570,40,530,80,530).draw(this);
		new Triangle(20,680,50,620).draw(this);
	}
	private void drawSelectCircle(int i){
		new Circle(40,10,(100*i)-90,10).draw(this);
	}
	void changeCurrent(int y){
		if(y==0){
			currentTool=0;
			clicksLeft=0;
		}else if(y<=100){
			currentTool=1;
			clicksLeft=2;
			System.out.println("Line Tool Selected");
		}else if(y<=200){
			currentTool=2;
			clicksLeft=2;
			System.out.println("Arrow Tool Selected");
		}else if(y<=300){
			currentTool=3;
			clicksLeft=2;
			System.out.println("Box Tool Selected");
		}else if(y<=400){
			currentTool=4;
			clicksLeft=2;
			System.out.println("Circle Tool Selected");
		}else if(y<=500){
			currentTool=5;
			clicksLeft=2;
			System.out.println("Diamond Tool Selected");
		}else if(y<=600){
			currentTool=6;
			clicksLeft=3;
			System.out.println("Parallelogram Tool Selected");
		}else{
			currentTool=7;
			clicksLeft=2;
			System.out.println("Triangle Tool Selected");
		}
		drawTools();
		mouseClicks=new ArrayList<MouseEvent>();
		drawSelectCircle(currentTool);
	}
	
	@Override
	public void mouseReleased(MouseEvent e){
		changeCurrent(e.getY());
	}
	public Shape nextShape() {
		int x1=mouseClicks.get(0).getX();
		int y1=mouseClicks.get(0).getY();
		int x2=mouseClicks.get(1).getX();
		int y2=mouseClicks.get(1).getY();
		if(currentTool==1){
			return new Line(x1,y1,x2,y2);
		}
		if(currentTool==2){
			return new Arrow(x1,y1,x2,y2);
		}
		if(currentTool==3){
			return new Box(x1,y1,x2,y2);
		}
		if(currentTool==4){
			int radius=(int) (Math.sqrt((Math.pow(x1-x2, 2))+(Math.pow(y1-y2, 2)))/2);
			int topX=x1;
			int topY=y1;
			if(x2<x1){topX=x2;}
			if(y2<y1){topY=y2;}
			return new Circle(radius,topX,topY);
		}
		if(currentTool==5){
			return new Diamond(x1,y1,x2,y2);
		}
		if(currentTool==6){
			int x3=mouseClicks.get(2).getX();
			int y3=mouseClicks.get(2).getY();
			return new Parallelogram(x1,y1,x2,y2,x3,y3);
		}
		if(currentTool==7){
			return new Triangle(x1,y1,x2,y2);
		}
		return null;
	}
	

}
