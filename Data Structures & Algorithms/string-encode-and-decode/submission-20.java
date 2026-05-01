class Solution {
    private final String salt = "salt!!@@sqws";
    private final String spilt = ".";

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        };
        StringBuilder sb = new StringBuilder();

        for (var str : strs) {
            sb.append(encodeStr(str)).append(spilt);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        String[] parts = str.split("\\.");

        List<String> decoded = new ArrayList<>();

        for (var part : parts) {
            decoded.add(decodeStr(part));
        }

        return decoded;
    }

    public String encodeStr(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(salt);
        for (var c : s.toCharArray()) {
            sb.append(c).append(salt);
        }
        return sb.toString();
    }

    public String decodeStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (var part : s.split(salt)) {
            sb.append(part);
        }

        return sb.toString();
    }
}
