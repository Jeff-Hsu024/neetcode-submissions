class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int l = 0;
        int r = heights.length - 1;
        while (l < r) {
            var w = r - l;
            var lh = heights[l];
            var rh = heights[r];
            var h = Math.min(lh, rh);
            var area = w * h;
            res = Math.max(res, area);
            if (lh < rh) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
