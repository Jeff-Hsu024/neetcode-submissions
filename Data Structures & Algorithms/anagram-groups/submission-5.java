class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>();
            var target = strs[i];
            if (set.contains(target)) {
                continue;
            }
            list.add(target);
            for (int j = i + 1; j < strs.length; j++) {
                var compare = strs[j];
                var isAnagrams = isAnagramsHelper(target, compare);
                if (isAnagrams) {
                    set.add(compare);
                    list.add(compare);
                }
            }
            result.add(list);
        }
        return result;
    }

    private boolean isAnagramsHelper(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        for (int i = 0; i < s1Chars.length; i++) {
            var s1Char = s1Chars[i];
            var s2Char = s2Chars[i];
            if (s1Char != s2Char) {
                return false;
            }
        }

        return true;
    }
}
