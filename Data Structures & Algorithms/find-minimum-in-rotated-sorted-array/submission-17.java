class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            // 如果這一段已經是排好序的（左小右大），那最左邊的一定最小
            if (nums[l] < nums[r]) {
                return nums[l];
            }

            int m = l + (r - l) / 2;
            
            // 跟右邊比！
            if (nums[m] > nums[r]) {
                // 中間比右邊大，代表最小值一定在右半邊（不含 m）
                l = m + 1;
            } else {
                // 中間比右邊小，代表 m 已經在低樓梯了
                // m 可能是最小值，所以收縮範圍時要包含 m
                r = m;
            }
        }

        return nums[l]; // 最後 l 和 r 相遇的地方就是最小值
    }
}