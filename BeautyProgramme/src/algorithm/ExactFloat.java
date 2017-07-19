package algorithm;

public class ExactFloat {

	//精确浮点数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//0.285714(285714)
		String a = "3.64";
		String b = "64";
		String exactFloatStr = exactFloat(a,b);
		System.out.println(a+"("+b+")"+"无限小数表示为分数形式：");
		System.out.println(exactFloatStr);
	}
	
	//Math.pow(double  m,  double  n) 是求m的n次方的
	
	/**
	 * 无限循环小数的精确表示函数
	 *  a为小数部分，b为循环节
	 *  例如：0.3(3)=0.333333333……
	 *  a=0.3 b=3
	 *  表示为分数1/3
	 * */
	public static String exactFloat(String a,String b){
		int n = a.length()-2;
		int m = b.length();
		int ia = (int) (Float.parseFloat(a)*(Math.pow(10,n)));
		int ib = Integer.parseInt(b);
		
		int member = (int)( (Math.pow(10,m)-1) * ia + ib);//分子
		int denominator = (int)((Math.pow(10,m)-1)*Math.pow(10,n));//分母
		
		//求最大公约数，分子分母约分
		int memberReduce =  member/MaxGCD.GCDOptimize(member, denominator);
		int denominatorReduce = denominator/MaxGCD.GCDOptimize(member, denominator);
		
		return Integer.toString(memberReduce)+"/"+Integer.toString(denominatorReduce);
	}
}
