class Solution {
    public int maxArea(int[] heights) {
        // x = end - start (index)
        // y = end or start (value)
        int max = 0;
        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            var area = Math.min(heights[l], heights[r]) * (r - l);
            if (area > max) {
                max = area;
            }
            if (heights[l] <= heights[r]) {
                l = l + 1;
            } else {
                r = r - 1;
            }
        }

        return max;
    }
}

