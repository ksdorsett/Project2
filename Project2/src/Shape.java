import csci348.drawings.Drawing;

public abstract class Shape {
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract int getXLocation();
	public abstract int getYLocation();
	public abstract void draw(Drawing d);
	public abstract boolean pointInside(int x,int y);

}
