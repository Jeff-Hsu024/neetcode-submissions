class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int l = 0;
        int r = heights.length -1;
        while (l < r) {
            var h = Math.min(heights[l], heights[r]);
            var w = r - l;
            var area = h * w;
            res = Math.max(res, area);

            if (heights[l] > heights[r]) {
                r = r -1;
            } else {
                l = l + 1;
            }
        }

        return res;
    }
}
