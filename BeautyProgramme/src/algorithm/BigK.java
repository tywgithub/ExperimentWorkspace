package algorithm;

import java.util.HashMap;
import java.util.Map;

public class BigK {

	// Ѱ��K�����������ļ������Ӻܶ��������ҵ����ļ�������Ŀֻ��Ҫ�ҳ�����Ҫ���������
	public static void main(String[] args) {
		// ��������
		// �����ҳ�����3��
		int[] s = new int[] { 48, 6, 57, 88, 60, 42, 83, 73, 88, 85 };

		// 1���������򷨣�http://blog.csdn.net/morewindows/article/details/6684558
		quickSort(s, 0, s.length - 1);
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + ",");
		}
		System.out.println("���3����" + s[s.length - 1] + "," + s[s.length - 2] + "," + s[s.length - 3] + ",");
		
		//�Ρ��������㷨�Ƚ���ʵ��
		
	}

	/**
	 * ����1���������� ������K�Ƚ�Сʱ 
	 * 1���ȴ�������ȡ��һ������Ϊ��׼����
	 * 2���������̣���������������ȫ�ŵ������ұߣ�С�ڻ����������ȫ�ŵ�������ߡ�
	 * 3���ٶ����������ظ��ڶ�����ֱ��������ֻ��һ������
	 */
	public static void quickSort(int s[], int l, int r) {
		if (l < r) {
			// Swap(s[l], s[(l + r) / 2]); //���м��������͵�һ�������� �μ�ע1
			int i = l, j = r, x = s[l];
			while (i < j) {
				while (i < j && s[j] >= x) // ���������ҵ�һ��С��x����
					j--;
				if (i < j)
					s[i++] = s[j];

				while (i < j && s[i] < x) // ���������ҵ�һ�����ڵ���x����
					i++;
				if (i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quickSort(s, l, i - 1); // �ݹ����
			quickSort(s, i + 1, r);
		}
	}

	/**
	 * ����2:ֻҪ���ҵ�����K��������Ҫ��������ô�����ǰK������������ø��õ�����
	 * �㷨˼ά�ο�P140
	 */
	//������������,(sa,sb),sa��Ԫ�ض�����X�����飬sb��Ԫ�ض�С��X�����飬keyΪsa,sb
	public static Map<String,int[]> partition(int s[]){
		Map<String,int[]> sasb = new HashMap<String,int[]>();
		//��ʼ��������
		int []sa =null;
		int []sb =null;
		
		//..........
		sasb.put("sa", sa);
		sasb.put("sb", sb);
		return sasb;
	}
	//GG �Ѿ���������
}
