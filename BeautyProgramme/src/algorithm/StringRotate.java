package algorithm;

public class StringRotate {

	//�ַ���λ������
	/**
	 * ���������ַ���s1,s2�����ж�s2�Ƿ��ܹ���s1��ѭ��λ�Ƶõ��ַ�������
	 * 
	 * */
	public static void main(String[] args) {
		char a[] = {'A','A','B','B','C','D'};
		char b[] = {'C','D','A','A'};
				
		System.out.println(rotateOne(a,b));
		
		System.out.println(rotateTwo(a,b));

	}
	/**
	 * �ⷨ1������ѭ����
	 * */
	public static boolean rotateOne(char a[],char b[]){
		int len = a.length;
		for(int i = 0;i<len;i++){//��������ѭ��λ�ƴ�����6λ����charѭ��6��
			
			char tempchar = a[0];//ȡ��һ���ַ�
			for(int j=0;j<(len-1);j++){//ѭ������ǰ�ַ�������һ�ַ����൱�ڰ���һλǰ��
				a[j] = a[j+1];
			}
			a[len-1]=tempchar;//���һ���ַ����ڵ�һ���ַ����൱�ڰ�ͷ�ŵ�β��
			
			if(String.valueOf(a).contains(String.valueOf(b))){//�ж�ѭ��λ�ƺ��String�Ƿ����Ŀ���ַ���
				return true;
			}			
		}
		return false;
	}
	
	/**
	 * �ⷨ2��
	 * S1ѭ��λ�ƿ���ת����S1S1,
	 * P216
	 * */
	public static boolean rotateTwo(char a[],char b[]){
		String aa = String.valueOf(a)+String.valueOf(a);
		if(aa.contains(String.valueOf(b))){
			return true;
		}
		return false;	
	}

}
