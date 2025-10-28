import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map from sorted word -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            // Convert word to a sorted char array
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // Add to map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        
        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}
