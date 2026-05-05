class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int l = 0;
        int r = heights.length - 1;
        while (l<r) {
            var w = r - l;
            var h = Math.min(heights[l], heights[r]);
            var area = w * h;
            res = Math.max(res, area);

            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }


        return res;
    }
}
