package leetcode.first;

import leetcode.tool.CommonTool;

/**
 * 排序后数组2个元素的最大间距
 *
 * @author sqh
 * @date 2018-12-18
 */
public class Code_164_MaximumGap {
    private static int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        } else {
            quickSort(nums, 0, nums.length - 1);
            int[] temp = new int[nums.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = nums[i + 1] - nums[i];
            }
            quickSort(temp, 0, temp.length - 1);
            return temp[temp.length - 1];
        }
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (arr == null || arr.length < 2) {
            return;
        }
        if (l < r) {
            int[] temp = partition(arr, l, r);
            quickSort(arr, l, temp[0] - 1);
//			for (int i = 0; i <= temp[0] - 1; i++) {
//				if (i == temp[0] - 1) {
//					System.out.print(arr[i] + "left is:" + l + "right is:" + r + "\n");
//				} else {
//					System.out.print(arr[i] + " ");
//				}
//			}
            quickSort(arr, temp[1] + 1, r);
//			for (int i = temp[1] + 1; i <= r; i++) {
//				if (i == r) {
//					System.out.print(arr[i] + "left is:" + l + "right is:" + r + "\n");
//				} else {
//					System.out.print(arr[i] + " ");
//				}
//			}
        }
    }

    private static int[] partition(int[] arr, int left, int right) {
        int small = left - 1, big = right;
//		int seedIndex = new Random().nextInt(right);
        int seedIndex = left + (int) (Math.random() * (right - left + 1));
//		System.out.println(seedIndex + " " + arr[seedIndex]);
        CommonTool.swap(arr, seedIndex, right);
        while (left < big) {
            if (arr[left] < arr[right]) {
                CommonTool.swap(arr, ++small, left++);
            } else if (arr[left] > arr[right]) {
                CommonTool.swap(arr, --big, left);
            } else {
                left++;
            }
        }
        CommonTool.swap(arr, right, big);
        int[] temp = {small + 1, big};
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = CommonTool.generatePositiveArray(10, 10);
        int res = maximumGap(arr);
        System.out.print(res);
    }
}
