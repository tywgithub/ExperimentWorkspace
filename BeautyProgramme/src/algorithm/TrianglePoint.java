package algorithm;

public class TrianglePoint {

	//判断点D是否在一个三角形ABC内
	public static void main(String[] args) {
		
		point A = new point(0,0);
		point B = new point(3,0);
		point C = new point(0,4);
		point D = new point(1,1.5);
				
		System.out.println(isInTriangle(A,B,C,D));
		
	}
	
	//点类，二维坐标
	static public class point{
		point(double xx,double yy){
			this.setX(xx);
			this.setY(yy);
		}
		double x;
		double y;
		
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}		
	}

	//计算三角形面积
	public static double area(point A,point B,point C){
		
		double a,b,c;//定义三条边长
		
		//两点间距离公式
		a = Math.sqrt((A.getX()-B.getX())*(A.getX()-B.getX()) + (A.getY()-B.getY())*(A.getY()-B.getY()));
		b = Math.sqrt((B.getX()-C.getX())*(B.getX()-C.getX()) + (B.getY()-C.getY())*(B.getY()-C.getY()));
		c = Math.sqrt((C.getX()-A.getX())*(C.getX()-A.getX()) + (C.getY()-A.getY())*(C.getY()-A.getY()));	
		//周长的一半
		double p = (a+b+c)/2;		
		return Math.sqrt((p-a)*(p-b)*(p-c)*p);//根据边长求三角形面积，海伦公式
	}
	
	//判断点D是否在三角形ABC内
	public static boolean isInTriangle(point A,point B,point C,point D){
		if(area(A,B,D)+area(D,B,C)+area(C,A,D)<=area(A,B,C)){//这里会有精度问题，差.0000000几的这种错误，但是不影响编程逻辑，可以四舍五入toString后再比较
			return true;
		}else					
		return false;
	}
	
}
