class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        Map<String, List<String>> m = new HashMap<>();
        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if(m.containsKey(sortedString)){
                m.get(sortedString).add(s);
            }            
            else{
                List<String> l = new ArrayList<>();
                l.add(s);
                m.put(sortedString, l);
            }
        }
        for(Map.Entry<String, List<String>> mp: m.entrySet()){
            ans.add(mp.getValue());
        }
        return ans;
    }
}
