class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if (t.length() > s.length()) {
            return res;
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (var c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> win = new HashMap<>();

        int l = 0;
        var chars = s.toCharArray();

        int need = t.length();
        int collect = 0;
        int minlength = s.length() + 1;

        // start end
        int[] result = new int[] {-1, -1};

        for (int r = 0; r < s.length(); r++) {
            var c = chars[r];
            win.put(c, win.getOrDefault(c, 0) + 1);
            if (tMap.containsKey(c) && tMap.get(c) >= win.get(c)) {
                collect = collect + 1;
            }

            while (need == collect) {
                int len = r - l + 1;
                if (len < minlength) {
                    minlength = len;
                    result = new int[] {l, r};
                }

                var tookoff = chars[l];
                if (tMap.containsKey(tookoff) && tMap.get(tookoff) == win.get(tookoff)) {
                    collect = collect - 1;
                }

                win.put(tookoff, win.get(tookoff) - 1);
                l = l + 1;
            }
        }

        if (result[0] == -1) {
            return "";
        }

        return s.substring(result[0], result[1] + 1);
    }
}
