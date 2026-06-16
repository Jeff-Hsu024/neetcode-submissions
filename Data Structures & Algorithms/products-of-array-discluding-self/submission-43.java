class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];

        // 2 4 6 8
        // 1 2 8 48
        l[0] = 1;
        for (int i = 1; i < l.length; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        r[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = l[i] * r[i];
        }

        return res;
    }
}
