class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        Set<Character> set = new HashSet<>();
        var charArray = s.toCharArray();
        int l = 0;

        for (int r = 0; r < charArray.length; r++) {
            var c = charArray[r];
        
            while(set.contains(c)) {
                var oc = charArray[l];
                set.remove(oc);
                l = l + 1;
            }
            
            set.add(c);
            var len = r - l + 1;
            res = Math.max(res, len);
        }

        return res;
    }
}
