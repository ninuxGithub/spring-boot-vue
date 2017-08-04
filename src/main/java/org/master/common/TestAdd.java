package org.master.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAdd {

	public static void main(String[] args) {
		Integer[] arr = { 11, 2, 5, 6, 17, 18, 30, 8, 19, 35, 31, 43, 41, 24, 9, 23 };

		Map<String, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			List<Integer> list = new ArrayList<>();
			Integer a = arr[i];
			for (int j = 0; j < arr.length; j++) {
				if (j == i) {
					continue;
				}
				Integer b = arr[j];

				for (int m = 0; m < arr.length; m++) {
					if (m == i || m == j) {
						continue;
					}
					Integer c = arr[m];

					for (int n = 0; n < arr.length; n++) {
						if (n == i || n == j || n == m) {
							continue;
						}
						Integer d = arr[n];

						Integer sum = a + b + c + d;
						//key:2589 list:[2, 5, 8, 9]
						// {
						// key:6181930 list:[6, 18, 19, 30]
						// key:6171931 list:[6, 17, 19, 31]
						// }
						//key:25611 list:[2, 5, 6, 11]===>24
						// {
						// key:8182324 list:[8, 18, 23, 24]
						// key:8171830 list:[8, 17, 18, 30]
						// key:9172324 list:[9, 17, 23, 24]
						// }
						
						
						//key:8182324 list:[8, 18, 23, 24]==>73
						//key:17354143 list:[17, 35, 41, 43]===>136
						//key:9193031 list:[9, 19, 30, 31]==>89
						boolean flag= valide(new Integer[]{2, 5, 6, 11,17, 35, 41, 43,8, 18, 23, 24}, a,b,c,d);
						if(!flag){
							continue;
						}
						
						
						//修改这个值--使用程序去完成计算【24,73,136,89】
						if (sum == 89) {
							list.add(a);
							list.add(b);
							list.add(c);
							list.add(d);
							Collections.sort(list);
							String key = getKey(list);
							map.put(key, list);
							list = new ArrayList<>();
						}
					}

				}

			}
		}

		for (String key : map.keySet()) {
			System.out.println("key:" + key + " list:" + map.get(key));
		}
	}

	private static boolean valide(Integer[] arrays, Integer a, Integer b, Integer c, Integer d) {
		for(int i=0; i<arrays.length; i++){
			if(a==arrays[i] || b==arrays[i] ||c==arrays[i]||d==arrays[i]){
				return false;
			}
		}
		return true;
	}

	private static String getKey(List<Integer> list) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		return sb.toString();
	}

}
