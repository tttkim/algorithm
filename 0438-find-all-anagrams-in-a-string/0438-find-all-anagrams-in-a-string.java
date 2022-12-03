class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
            
        HashMap<Character, Integer> pmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        int start = 0;
        int end = 0;
        while (end < p.length()) {
            if (!pmap.containsKey(p.charAt(end))) {
                pmap.put(p.charAt(end), 1);
            } else {
                pmap.put(p.charAt(end), pmap.get(p.charAt(end))+1);
            }
            if (!smap.containsKey(s.charAt(end))) {
                smap.put(s.charAt(end), 1);
            } else {
                smap.put(s.charAt(end), smap.get(s.charAt(end))+1);
            }
            end++;
        }
        List<Integer> answer = new ArrayList<Integer>();
        while (end < s.length()) {
            if (checkAnagram(smap, pmap)) {
                answer.add(start);
            }
            char key = s.charAt(start);
            if (smap.containsKey(key)) {
                if (smap.get(key) == 1)
                    smap.remove(key);
                else
                    smap.put(key, smap.get(key)-1);
            }
            key = s.charAt(end);
            if (smap.containsKey(key)) {
                smap.put(key, smap.get(key)+1);
            } else {
                smap.put(key, 1);
            }
            start++;
            end++;
        }
        if (checkAnagram(smap, pmap)) {
                answer.add(start);
            }
        
        return answer;
    }
    
    public boolean checkAnagram(Map<Character, Integer> smap, Map<Character, Integer> pmap) {
        for (char key : pmap.keySet()) {

            if (!smap.containsKey(key))
                return false;
            if (!smap.get(key).equals(pmap.get(key))){
                return false;
            }
                
        }
        return true;
    }
}