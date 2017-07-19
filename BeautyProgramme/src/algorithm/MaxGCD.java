package algorithm;

public class MaxGCD {

	//最大公约数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int x=1684984164;
//		int y=916350;
		
		int x=1450;
		int y=360;
	
		long t1=System.nanoTime();//System.currentTimeMillis();
		int z1 = GCDOuJiLiDe(x,y);
		System.out.println("欧几里得-最大公约数："+z1+"\r执行耗时 : "+(System.nanoTime()-t1)+" 纳秒 ");
		
		long t2=System.nanoTime();
		int z2 = GCDSubtraction(x,y);
		System.out.println("大整数减法优化-最大公约数："+z2+"\r执行耗时 : "+(System.nanoTime()-t2)+" 纳秒 ");
				
		long t3=System.nanoTime();
		int z3 = GCDOptimize(x,y);
		System.out.println("二进制移位优化-最大公约数："+z3+"\r执行耗时 : "+(System.nanoTime()-t3)+" 纳秒 ");
			
	}
	
	
	/** 
	 * 最大公约数-欧几里得-辗转相除法：
	 * 令f(x,y)为x和y的最大公约数，
	 * 则
	 * f(x,y)=f(y,x%y)，
	 * 当y=0时，另一个即为最大公约数。
	 * */
	public static int GCDOuJiLiDe(int x,int y){		
		return (y==0)?x:GCDOuJiLiDe(y,x%y);
	}
	
	/** 
	 * 优化1，将大开销的取模运算换成整数减法运算
	 * 
	 * 令f(x,y)为x和y的最大公约数，而且f(x,y)=f(y,x)，可以换位
	 * 则
	 * f(x,y)=f(y,x-y)，
	 * 当y=0时，另一个即为最大公约数。
	 * 
	 * 且，当x<y时，要交换位置
	 * 
	 * 这种方法有时会堆栈溢出
	 * */
	public static int GCDSubtraction(int x,int y){	
		
		if(x<y){
			return GCDSubtraction(y,x);
		}
		if(y==0){
			return x;
		}else{
			return GCDSubtraction(y,x-y);
		}				
	}
	
	/** 
	 * 优化2，多管齐下处理迭代次数多的问题
	 * 算法详情在 P152
	 * 
	 * */
	public static int GCDOptimize(int x,int y){	
		
		if(x<y){
			return GCDOptimize(y,x);
		}
		if(y==0){
			return x;
		}else{
			
			if(IsEven(x)){				
				if(IsEven(y)){
					return (GCDOptimize(x>>1,y>>1) <<1 );
				}else{
					return GCDOptimize(x>>1,y);
				}	
			}else{
				if(IsEven(y)){
					return GCDOptimize(x,y>>1);
				}else{
					return GCDOptimize(y,x-y);
				}
			}			
		}				
	}

	/**判断是否是偶数,支持负数*/
	public static boolean IsEven(int x) {		
		return (x&1) == 0;
		/*& 是二进制与运算
		*只要是奇数，肯定可以转化成（1+偶数），
		*转化成二进制，最后一位肯定是1，
		*若是奇数，二进制 与运算 1最后一位肯定是1，
		*偶数肯定是0
		*/
	}

}
