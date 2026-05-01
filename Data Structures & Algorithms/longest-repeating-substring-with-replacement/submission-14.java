class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int l = 0;

        var charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxC = 0;

        for (int r = 0; r < s.length(); r++) {
            var c = charArray[r];
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
            maxC = Math.max(maxC, map.get(c));

            var windowLen = (r - l + 1);
            if (windowLen - maxC <= k) {
                res = Math.max(res, windowLen);
            } else {
                var removedC = charArray[l];
               
                map.put(removedC, map.get(removedC) - 1);

                l = l + 1;
            }
        }

        return res;
    }
}
