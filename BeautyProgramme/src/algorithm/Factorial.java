package algorithm;

public class Factorial {

	//Ѱ�ҽ׳˽���У�ĩβ0�ĸ���
	public static void main(String[] args) {
		//������10!��N=10
		int x = FactorialOne(15);
		int y = FactorialTwo(12);
		System.out.println(x);
		System.out.println(y);
	}
	/**
	 * P126
	 * */
	public static int FactorialOne(int N){
		int ret = 0;//��ʽ�ֽ���5��ָ��
		
		for(int i=1;i<=N;i++){
			int j=i;
			
			while(j%5 == 0){//��N�к�5ȡģΪ0�����ܹ���5�����ģ�
				ret++;//�൱����һ��5.1
				j/=5;//j = j/5������j�����Ƿ������������ܱ�5����
			}
		}
		return ret;
	}
	
	public static int FactorialTwo(int N){
		int ret = 0;//��ʽ�ֽ���5��ָ��
		
		while(N!=0){
			ret += N/5;//ret = ret + N/5
			N/=5;//N = N/5
			//��Ϊ��������Int�����Զ���������λ
		}
		
		return ret;
	}

}
