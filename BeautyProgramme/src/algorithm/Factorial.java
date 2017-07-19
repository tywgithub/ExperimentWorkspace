package algorithm;

public class Factorial {

	//寻找阶乘结果中，末尾0的个数
	public static void main(String[] args) {
		//假设求10!，N=10
		int x = FactorialOne(15);
		int y = FactorialTwo(12);
		System.out.println(x);
		System.out.println(y);
	}
	/**
	 * P126
	 * */
	public static int FactorialOne(int N){
		int ret = 0;//因式分解中5的指数
		
		for(int i=1;i<=N;i++){
			int j=i;
			
			while(j%5 == 0){//求N中和5取模为0（即能够被5整除的）
				ret++;//相当于有一个5.1
				j/=5;//j = j/5，看看j自身是否包含多个数字能被5整除
			}
		}
		return ret;
	}
	
	public static int FactorialTwo(int N){
		int ret = 0;//因式分解中5的指数
		
		while(N!=0){
			ret += N/5;//ret = ret + N/5
			N/=5;//N = N/5
			//因为参数都是Int，会自动保留整数位
		}
		
		return ret;
	}

}
