import csci348.drawings.Drawing;

public class Circle extends Shape{
	private int radius;
	private int x;
	private int y;
	private int lineWidth;
	
	public Circle(int radius,int x,int y){
		this.radius=radius;
		this.x=x;
		this.y=y;
		this.lineWidth=1;
	}
	public Circle(int radius,int x,int y, int lineWidth){
		this.radius=radius;
		this.x=x;
		this.y=y;
		this.lineWidth=lineWidth;
	}
	
	public int getRadius(){
		return radius;
	}
	
	public int getLineWidth(){
		return lineWidth;
	}
	
	public int getMidX(){
		return x+radius;
	}
	
	public int getMidY(){
		return y+radius;
	}

	@Override
	public int getWidth() {
		return radius*2;
	}

	@Override
	public int getHeight() {
		return radius*2;
	}

	@Override
	public int getXLocation() {
		return x;
	}

	@Override
	public int getYLocation() {
		return y;
	}

	@Override
	public void draw(Drawing d) {
		for(int i=x;i<=x+getWidth();i++){
			for(int j=y;j<=y+getHeight();j++){
				if((Math.sqrt((Math.pow(getMidX()-i, 2))+(Math.pow(getMidY()-j, 2)))<=radius)
						&&((Math.sqrt((Math.pow(getMidX()-i, 2))+(Math.pow(getMidY()-j, 2)))>radius-lineWidth))){
					d.showPoint(i, j);
				}
			}
		}
		
	}
	@Override
	public boolean pointInside(int xClick, int yClick) {
		return (Math.sqrt((Math.pow(getMidX()-xClick, 2))+(Math.pow(getMidY()-yClick, 2)))<=radius);
	}

}
