class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int res = 0;
        int start = 0;
        var charArray = s.toCharArray();

        // p w w k e w
        // p w
        // k e w

        for (int i = 0; i < charArray.length; i++) {
            var c = charArray[i];
            while (set.contains(c)) {

                set.remove(charArray[start]);
                start = start + 1;
            }

            set.add(c);
            res = Math.max(i - start + 1, res);
        }

        return res;
    }
}
