import csci348.drawings.Drawing;

public class Box extends Shape{
	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public Box(int startX, int startY, int endX, int endY){
		this.startX=startX;
		this.startY=startY;
		this.endX=endX;
		this.endY=endY;
	}	


	@Override
	public int getWidth() {
		return Math.abs(endX=startX);
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
		Line lineA = new Line(startX,startY,endX,startY);
		Line lineB = new Line(startX,startY,startX,endY);
		Line lineC = new Line(endX,startY,endX,endY);
		Line lineD = new Line(startX,endY,endX,endY);
		lineA.draw(d);
		lineB.draw(d);
		lineC.draw(d);
		lineD.draw(d);
		
	}


	@Override
	public boolean pointInside(int xClick, int yClick) {
		return ((xClick>=startX && xClick<=endX)||
				(xClick<=startX && xClick>=endX))&&
				((yClick>=startY && yClick<=endY)||
				(yClick<=startY && yClick>=endY));
	}
}
