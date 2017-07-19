package algorithm;

public class MaxGCD {

	//���Լ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int x=1684984164;
//		int y=916350;
		
		int x=1450;
		int y=360;
	
		long t1=System.nanoTime();//System.currentTimeMillis();
		int z1 = GCDOuJiLiDe(x,y);
		System.out.println("ŷ�����-���Լ����"+z1+"\rִ�к�ʱ : "+(System.nanoTime()-t1)+" ���� ");
		
		long t2=System.nanoTime();
		int z2 = GCDSubtraction(x,y);
		System.out.println("�����������Ż�-���Լ����"+z2+"\rִ�к�ʱ : "+(System.nanoTime()-t2)+" ���� ");
				
		long t3=System.nanoTime();
		int z3 = GCDOptimize(x,y);
		System.out.println("��������λ�Ż�-���Լ����"+z3+"\rִ�к�ʱ : "+(System.nanoTime()-t3)+" ���� ");
			
	}
	
	
	/** 
	 * ���Լ��-ŷ�����-շת�������
	 * ��f(x,y)Ϊx��y�����Լ����
	 * ��
	 * f(x,y)=f(y,x%y)��
	 * ��y=0ʱ����һ����Ϊ���Լ����
	 * */
	public static int GCDOuJiLiDe(int x,int y){		
		return (y==0)?x:GCDOuJiLiDe(y,x%y);
	}
	
	/** 
	 * �Ż�1����������ȡģ���㻻��������������
	 * 
	 * ��f(x,y)Ϊx��y�����Լ��������f(x,y)=f(y,x)�����Ի�λ
	 * ��
	 * f(x,y)=f(y,x-y)��
	 * ��y=0ʱ����һ����Ϊ���Լ����
	 * 
	 * �ң���x<yʱ��Ҫ����λ��
	 * 
	 * ���ַ�����ʱ���ջ���
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
	 * �Ż�2��������´�����������������
	 * �㷨������ P152
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

	/**�ж��Ƿ���ż��,֧�ָ���*/
	public static boolean IsEven(int x) {		
		return (x&1) == 0;
		/*& �Ƕ�����������
		*ֻҪ���������϶�����ת���ɣ�1+ż������
		*ת���ɶ����ƣ����һλ�϶���1��
		*���������������� ������ 1���һλ�϶���1��
		*ż���϶���0
		*/
	}

}
