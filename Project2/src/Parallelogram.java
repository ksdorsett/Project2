import csci348.drawings.Drawing;

public class Parallelogram extends Shape{
	private int startX;
	private int startY;
	private int midX;
	private int midY;
	private int endX;
	private int endY;
	
	public Parallelogram(int startX,int startY, int midX, int midY, int endX,int endY){
		this.startX=startX;
		this.startY=startY;
		this.midX=midX;
		this.midY=midY;
		this.endX=endX;
		this.endY=endY;
	}

	@Override
	public int getWidth() {
		return Math.abs(endX-startX);
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
		int thirdX=startX+endX-midX;
		int thirdY=startY+endY-midY;
		Line lineA=new Line(startX,startY,midX,midY);
		Line lineB=new Line(midX,midY,endX,endY);
		Line lineC=new Line(startX,startY,thirdX,thirdY);
		Line lineD=new Line(thirdX,thirdY,endX,endY);
		lineA.draw(d);
		lineB.draw(d);
		lineC.draw(d);
		lineD.draw(d);
		
	}

	@Override
	public boolean pointInside(int xClick, int yClick) {
		int lowX=startX;
		if(midX<lowX){lowX=midX;}
		if(endX<lowX){lowX=endX;}
		int highX=startX;
		if(midX>highX){highX=midX;}
		if(endX>highX){highX=endX;}
		int lowY=startY;
		if(midY<lowY){lowY=midY;}
		if(endY<lowY){lowY=endY;}
		int highY=startY;
		if(midY>highY){highY=midY;}
		if(endY>highY){highY=endY;}
		return xClick>=lowX && xClick<=highX && yClick>=lowY && yClick<=highY;
	}

}
