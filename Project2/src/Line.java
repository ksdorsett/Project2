import csci348.drawings.Drawing;

public class Line extends Shape{
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	
	public Line(int startX,int startY, int endX,int endY){
		this.startX=startX;
		this.startY=startY;
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
	
	public int getXEnd() {
		return endX;
	}

	public int getYEnd() {
		return endY;
	}

	@Override
	public void draw(Drawing d) {
		int x=startX;
		int y=startY;
		int w = endX - x ;
		int h = endY - y ;
		int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
		if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ;
		if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
		if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
		int longest = Math.abs(w) ;
		int shortest = Math.abs(h) ;
		if (!(longest>shortest)) {
			longest = Math.abs(h) ;
			shortest = Math.abs(w) ;
			if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
			dx2 = 0 ;
			}
		    int numerator = longest >> 1 ;
		    for (int i=0;i<=longest;i++) {
		        d.showPoint(x, y); ;
		        numerator += shortest ;
		        if (!(numerator<longest)) {
		            numerator -= longest ;
		            x += dx1 ;
		            y += dy1 ;
		        } else {
		            x += dx2 ;
		            y += dy2 ;
		        }
		    }
		}


	@Override
	public boolean pointInside(int xClick, int yClick) {
		return pointInside(xClick, yClick, 10);
	}
	public boolean pointInside(int xClick, int yClick, int spaceAround) {
		int x=startX;
		int y=startY;
		int w = endX - x ;
		int h = endY - y ;
		int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
		if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ;
		if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
		if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
		int longest = Math.abs(w) ;
		int shortest = Math.abs(h) ;
		if (!(longest>shortest)) {
			longest = Math.abs(h) ;
			shortest = Math.abs(w) ;
			if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
			dx2 = 0 ;
			}
		    int numerator = longest >> 1 ;
		    for (int i=0;i<=longest;i++) {
		        if((Math.sqrt((Math.pow(x-xClick, 2))+(Math.pow(y-yClick, 2)))<=spaceAround)){
		        	return true;
		        }
		        numerator += shortest ;
		        if (!(numerator<longest)) {
		            numerator -= longest ;
		            x += dx1 ;
		            y += dy1 ;
		        } else {
		            x += dx2 ;
		            y += dy2 ;
		        }
		    }
		return false;
	}
		
}
