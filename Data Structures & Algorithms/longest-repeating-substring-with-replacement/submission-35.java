class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
   
        Map<Character, Integer> map = new HashMap<>();
        var chars = s.toCharArray();
        
        int l = 0;
        int most = 0;

        for (int r = 0; r < chars.length; r++) {
            var len = r - l + 1;
            var c = chars[r];
            
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
            most = Math.max(most, map.get(c));

            if (len - most <= k) {
                res = Math.max(len, res);
            } else {
                map.put(chars[l], map.get(chars[l]) - 1);
                l = l + 1;
            }
        }

        return res;
    }
}
