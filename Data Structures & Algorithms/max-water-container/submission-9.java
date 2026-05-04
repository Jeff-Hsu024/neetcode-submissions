class Solution {
    public int maxArea(int[] heights) {
        int res = 0;

        int l = 0;
        int r = heights.length - 1;
        while (l < r) {
            int w = r - l;
            int h = Math.min(heights[l], heights[r]);
            int area = w * h;
            res = Math.max(res, area);

            if (heights[l] > heights[r]) {
                r = r - 1;
            } else {
                l = l + 1;
            }
        }


        return res;
    }
}
