class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                sb.append((char) ((chars[i] - chars[i-1] + 26) % 26 + 'a'));
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<String>());
            }
            map.get(sb.toString()).add(s);
        }
        List<List<String>> answer = new ArrayList<>();
        for (String key : map.keySet()) {
            answer.add(map.get(key));
        }
        return answer;
    }
}