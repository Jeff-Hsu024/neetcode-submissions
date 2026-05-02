class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            int w = r - l;
            int h = Math.min(heights[l], heights[r]);
            var area = w * h;
            max = Math.max(max, area);

            if (heights[l] < heights[r]) {
                l = l + 1;
            } else {
                r = r - 1;
            }
        }

        return max;
    }
}
