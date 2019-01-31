package leetcode;

public class Code_035_Search_Insert_Position {
    public static int searchInsert(int[] nums, int target) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
            }
        }
        if (index < 0 && nums.length > 1) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < target && nums[i + 1] > target) {
                    index = i + 1;
                    //break;
                } else if (nums[0] > target) {
                    index = 0;
                    //break;
                } else if (nums[nums.length - 1] < target) {
                    index = nums.length;
                    //break;
                }
            }
        } else if (nums.length == 1) {
            if (nums[0] < target) {
                index = 1;
            } else {
                index = 0;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int index = searchInsert(arr, 2);
        System.out.print(index);
    }
}
