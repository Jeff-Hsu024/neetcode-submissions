class Solution {
    public int[] productExceptSelf(int[] nums) {
        var len = nums.length;

        int[] res = new int[len];

        int[] la = new int[len];
        la[0] = 1;
        for (int i = 1; i < len; i++) {
            la[i] = la[i - 1] * nums[i - 1];
        }

        int[] ra = new int[len];
        ra[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            ra[i] = ra[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            res[i] = la[i] * ra[i];
        }

        return res;
    }
}
