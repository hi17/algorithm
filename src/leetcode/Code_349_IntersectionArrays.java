package leetcode;

import tool.CommonTool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 2个数组的交集
 *
 * @author sqh
 * @date 2018/12/18
 */
public class Code_349_IntersectionArrays {
	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<Integer>();
		// nums1去除重复元素
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		List<Integer> resList = new ArrayList<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				resList.add(nums2[i]);
				// 移除已经找到的元素
				set.remove(nums2[i]);
			}
		}
		int[] res = new int[resList.size()];
		for (int i = 0; i < resList.size(); i++) {
			res[i] = resList.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr1 = CommonTool.generateArray(10, 3);
		int[] arr2 = CommonTool.generateArray(10, 3);
		int[] res = intersection(arr1, arr2);
		CommonTool.printArray(res);
	}
}