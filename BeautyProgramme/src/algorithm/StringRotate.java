package algorithm;

public class StringRotate {

	//字符串位移问题
	/**
	 * 给定两个字符串s1,s2，求判定s2是否能够被s1做循环位移得到字符串包含
	 * 
	 * */
	public static void main(String[] args) {
		char a[] = {'A','A','B','B','C','D'};
		char b[] = {'C','D','A','A'};
				
		System.out.println(rotateOne(a,b));
		
		System.out.println(rotateTwo(a,b));

	}
	/**
	 * 解法1：常规循环法
	 * */
	public static boolean rotateOne(char a[],char b[]){
		int len = a.length;
		for(int i = 0;i<len;i++){//最外层控制循环位移次数，6位长的char循环6次
			
			char tempchar = a[0];//取第一个字符
			for(int j=0;j<(len-1);j++){//循环将当前字符等于下一字符，相当于把下一位前移
				a[j] = a[j+1];
			}
			a[len-1]=tempchar;//最后一个字符等于第一个字符，相当于把头放到尾部
			
			if(String.valueOf(a).contains(String.valueOf(b))){//判断循环位移后的String是否包含目标字符串
				return true;
			}			
		}
		return false;
	}
	
	/**
	 * 解法2：
	 * S1循环位移可以转化成S1S1,
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
