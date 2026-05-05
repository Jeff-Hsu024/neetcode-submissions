class Solution {
    public int[] productExceptSelf(int[] nums) {
        var len = nums.length;
        int[] res = new int[len];

        int[] l = new int[len];
        l[0] = 1;
        for (int i = 1; i < len; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }

        int[] r = new int[len];
        r[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            res[i] = l[i] * r[i];
        }
        return res;
    }
}
