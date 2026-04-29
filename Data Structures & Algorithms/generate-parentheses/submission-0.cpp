class Solution {
public:
    bool isValid(string s){
        stack<char> st;
        for(int i = 0 ; i< s.length(); i++){
            if(s[i] == '('){
                st.push(s[i]);
            }
            else{
                if(st.empty())
                return false;
                else
                st.pop();
            }
        }
        return st.size() == 0;
    }
    void solve(string &s, vector<string> &ans, int i,int n){
        if(i == n){
            if(isValid(s))
            ans.push_back(s);
            return;
        }
        unordered_set<char> st;
        for(int j = i; j < n; j++){
            if(st.count(s[j])) continue;

            st.insert(s[j]);
            swap(s[i], s[j]);
            solve(s, ans, i+1, n);
            swap(s[i], s[j]);
        }
        return;
    }
    vector<string> generateParenthesis(int n) {
        string s = "";
        for(int i = 0 ; i< n;  i++){
            s += "()";
        }
        vector<string> ans;
        solve(s, ans, 0, n*2);
        return ans;
    }
};
