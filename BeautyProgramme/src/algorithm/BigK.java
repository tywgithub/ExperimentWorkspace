package algorithm;

import java.util.HashMap;
import java.util.Map;

public class BigK {

	// 寻找K个数字中最大的几个，从很多数字中找到最大的几个，题目只需要找出，不要求进行排序
	public static void main(String[] args) {
		// 参数数组
		// 假设找出最大的3个
		int[] s = new int[] { 48, 6, 57, 88, 60, 42, 83, 73, 88, 85 };

		// 1、快速排序法：http://blog.csdn.net/morewindows/article/details/6684558
		quickSort(s, 0, s.length - 1);
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + ",");
		}
		System.out.println("最大3个：" + s[s.length - 1] + "," + s[s.length - 2] + "," + s[s.length - 3] + ",");
		
		//晕、其他的算法比较难实现
		
	}

	/**
	 * 方法1：快速排序法 适用于K比较小时 
	 * 1．先从数列中取出一个数作为基准数。
	 * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
	 * 3．再对左右区间重复第二步，直到各区间只有一个数。
	 */
	public static void quickSort(int s[], int l, int r) {
		if (l < r) {
			// Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
			int i = l, j = r, x = s[l];
			while (i < j) {
				while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
					j--;
				if (i < j)
					s[i++] = s[j];

				while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quickSort(s, l, i - 1); // 递归调用
			quickSort(s, i + 1, r);
		}
	}

	/**
	 * 方法2:只要求找到最大的K个数，不要求排序，那么避免对前K个数排序来获得更好的性能
	 * 算法思维参考P140
	 */
	//返回两个数组,(sa,sb),sa是元素都大于X的数组，sb是元素都小于X的数组，key为sa,sb
	public static Map<String,int[]> partition(int s[]){
		Map<String,int[]> sasb = new HashMap<String,int[]>();
		//初始化空数组
		int []sa =null;
		int []sb =null;
		
		//..........
		sasb.put("sa", sa);
		sasb.put("sb", sb);
		return sasb;
	}
	//GG 已经看不懂了
}
