import csci348.drawings.Drawing;

public class Triangle extends Shape{
	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public Triangle(int startX, int startY, int endX, int endY) {
		this.startX=startX;
		this.startY=startY;
		this.endX=endX;
		this.endY=endY;
	}

	@Override
	public int getWidth() {
		return Math.abs(endX-startX)*2;
	}

	@Override
	public int getHeight() {
		return Math.abs(endY-startY);
	}

	@Override
	public int getXLocation() {
		return startX;
	}

	@Override
	public int getYLocation() {
		return startY;
	}
	
	@Override
	public void draw(Drawing d) {
		int width=(endX-startX)*2;
		Line lineA=new Line(startX,startY,endX,endY);
		Line lineB=new Line(startX,startY,startX+width,startY);
		Line lineC=new Line(endX,endY,startX+width,startY);
		lineA.draw(d);
		lineB.draw(d);
		lineC.draw(d);
		
	}

	@Override
	public boolean pointInside(int xClick, int yClick) {
		int lowX=startX;
		if(endX<lowX){lowX=endX;}
		int highX=startX;
		if(endX>highX){highX=endX;}
		int lowY=startY;
		if(endY<lowY){lowY=endY;}
		int highY=startY;
		if(endY>highY){highY=endY;}
		return xClick>=lowX && xClick<=highX+getWidth() && yClick>=lowY && yClick<=highY;
	}

}
