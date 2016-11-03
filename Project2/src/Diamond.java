import csci348.drawings.Drawing;

public class Diamond extends Shape{
	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public Diamond(int startX, int startY, int endX, int endY) {
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
		int thirdX=startX+((endX-startX)*2);
		int fourthY=endY-((endY-startY)*2);
		Line lineA=new Line(startX,startY,endX,endY);
		Line lineB=new Line(endX,endY,thirdX,startY);
		Line lineC=new Line(startX,startY,endX,fourthY);
		Line lineD=new Line(endX,fourthY,thirdX,startY);
		lineA.draw(d);
		lineB.draw(d);
		lineC.draw(d);
		lineD.draw(d);
		
	}

	@Override
	public boolean pointInside(int xClick, int yClick) {
		int thirdX=startX+((endX-startX)*2);
		int fourthY=endY-((endY-startY)*2);
		return ((yClick>=endY&&yClick<=fourthY)||
				(yClick<=endY&&yClick>=fourthY))&&
				((xClick>=startX&&xClick<=thirdX)||
				(xClick<=startX&&xClick>=thirdX));
				}

}
