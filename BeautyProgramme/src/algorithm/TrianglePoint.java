package algorithm;

public class TrianglePoint {

	//�жϵ�D�Ƿ���һ��������ABC��
	public static void main(String[] args) {
		
		point A = new point(0,0);
		point B = new point(3,0);
		point C = new point(0,4);
		point D = new point(1,1.5);
				
		System.out.println(isInTriangle(A,B,C,D));
		
	}
	
	//���࣬��ά����
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

	//�������������
	public static double area(point A,point B,point C){
		
		double a,b,c;//���������߳�
		
		//�������빫ʽ
		a = Math.sqrt((A.getX()-B.getX())*(A.getX()-B.getX()) + (A.getY()-B.getY())*(A.getY()-B.getY()));
		b = Math.sqrt((B.getX()-C.getX())*(B.getX()-C.getX()) + (B.getY()-C.getY())*(B.getY()-C.getY()));
		c = Math.sqrt((C.getX()-A.getX())*(C.getX()-A.getX()) + (C.getY()-A.getY())*(C.getY()-A.getY()));	
		//�ܳ���һ��
		double p = (a+b+c)/2;		
		return Math.sqrt((p-a)*(p-b)*(p-c)*p);//���ݱ߳�����������������׹�ʽ
	}
	
	//�жϵ�D�Ƿ���������ABC��
	public static boolean isInTriangle(point A,point B,point C,point D){
		if(area(A,B,D)+area(D,B,C)+area(C,A,D)<=area(A,B,C)){//������о������⣬��.0000000�������ִ��󣬵��ǲ�Ӱ�����߼���������������toString���ٱȽ�
			return true;
		}else					
		return false;
	}
	
}
