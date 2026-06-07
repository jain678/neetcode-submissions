class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == endWord || !wordList.contains(endWord)) return 0;

        Set<String> st = new HashSet<>(wordList);
        int n = wordList.size();
        int m = wordList.get(0).length();

        List<Integer>[] adj = new ArrayList[n];
        for(int i= 0; i< n; i++){
            adj[i]= new ArrayList<>();
        }
        int res = 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()){
            res++;
            int size=q.size();
            for(int j=0; j< size; j++){
                String s = q.poll();
                if( s.equals(endWord)) return res;
                for(int i = 0 ; i< s.length(); i++){

                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == s.charAt(i)) continue;
                        String nei = s.substring(0, i) + c + s.substring(i+1);

                        if(st.contains(nei)){
                            q.add(nei);
                            st.remove(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
