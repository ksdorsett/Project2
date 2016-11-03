import csci348.drawings.Drawing;

public class Arrow extends Line{
	
	public Arrow(int startX,int startY, int endX,int endY){
		super(startX, startY, endX, endY);
	}
	
	@Override
	public void draw(Drawing d) {
		int divider = 10;
		int XDist= (getXEnd()-getXLocation())/divider;
		int YDist= (getYEnd()-getYLocation())/divider;
		int NX=getXEnd()-XDist;
		int NY=getYEnd()-YDist;
		Line lineA=new Line(getXLocation(), getYLocation(), getXEnd(), getYEnd());
		Line lineB=new Line(NX+YDist,NY-XDist,getXEnd(), getYEnd());
		Line lineC=new Line(NX-YDist,NY+XDist,getXEnd(), getYEnd());
		
		lineA.draw(d);
		lineB.draw(d);
		lineC.draw(d);
		
	}

}
