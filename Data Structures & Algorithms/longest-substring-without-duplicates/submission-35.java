class Solution {
    public int lengthOfLongestSubstring(String s) {
        var chars = s.toCharArray();
        int res = 0;
        int l = 0;

        Set<Character> set = new HashSet<>();
        for (int r = 0; r < chars.length; r++) {
            var c = chars[r];
            while (set.contains(c)) {
                    set.remove(chars[l]);
                    l = l + 1;
            }
                set.add(c);
                var len = r - l + 1;
                res = Math.max(res, len);
            
            // if (!set.contains(c)) {
            //     set.add(c);
            //     var len = r - l + 1;
            //     res = Math.max(res, len);

            // } else {
            //     while (set.contains(c)) {
            //         set.remove(chars[l]);
            //         l = l + 1;
            //     }

            //     set.add(c);
            // }
        }

        return res;
    }
}
