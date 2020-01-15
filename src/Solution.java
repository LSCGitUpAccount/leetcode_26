public class Solution {
    public int removeDuplicates(int[] nums) {
        // 1. 判断数组的有效性
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }

        // 2.1 初始状态下:第一个元素肯定,可以被保留
        int can_save_value = nums[0];
        // 2.2 初始状态下:数组中索引为0的位置,记录着不重复性的元素
        int can_save_index = 0;

        // 3. 遍历剩余元素
        for (int i = 1; i < nums.length; i++) {
            // 3.1 如果 当前索引对应的元素值 与 可以被保留的值can_save 相等
            if (nums[i] == can_save_value) {
                // can_save值不需要改变
                // single_index值 也不需要改变
                continue;
            }

            // 3.2 如果 不相等 : 说明'当前索引对应的元素值'可以被保留 ; 而且（single_index+1）位置应该对这个值进行记录
            can_save_value = nums[i];
            can_save_index++;
            nums[can_save_index] = can_save_value;
        }

        // 4. 符合条件的数量 = can_save_index+1
        return can_save_index + 1;
    }
}
