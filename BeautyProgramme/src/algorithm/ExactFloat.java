package algorithm;

public class ExactFloat {

	//��ȷ������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//0.285714(285714)
		String a = "3.64";
		String b = "64";
		String exactFloatStr = exactFloat(a,b);
		System.out.println(a+"("+b+")"+"����С����ʾΪ������ʽ��");
		System.out.println(exactFloatStr);
	}
	
	//Math.pow(double  m,  double  n) ����m��n�η���
	
	/**
	 * ����ѭ��С���ľ�ȷ��ʾ����
	 *  aΪС�����֣�bΪѭ����
	 *  ���磺0.3(3)=0.333333333����
	 *  a=0.3 b=3
	 *  ��ʾΪ����1/3
	 * */
	public static String exactFloat(String a,String b){
		int n = a.length()-2;
		int m = b.length();
		int ia = (int) (Float.parseFloat(a)*(Math.pow(10,n)));
		int ib = Integer.parseInt(b);
		
		int member = (int)( (Math.pow(10,m)-1) * ia + ib);//����
		int denominator = (int)((Math.pow(10,m)-1)*Math.pow(10,n));//��ĸ
		
		//�����Լ�������ӷ�ĸԼ��
		int memberReduce =  member/MaxGCD.GCDOptimize(member, denominator);
		int denominatorReduce = denominator/MaxGCD.GCDOptimize(member, denominator);
		
		return Integer.toString(memberReduce)+"/"+Integer.toString(denominatorReduce);
	}
}
