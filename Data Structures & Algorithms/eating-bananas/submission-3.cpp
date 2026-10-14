class Solution {
public:
    int canEat(vector<int> &piles, int m){
        int cnt = 0;
        for(int i = 0; i<piles.size(); i++){
            if(piles[i] <= m)
            cnt++;
            else{
                int x = piles[i]/m;
                int y = piles[i]%m;
                if(y != 0) x++;
                cnt+=x;
            }
        }
        return cnt;
    }
    int minEatingSpeed(vector<int>& piles, int t) {
        int l = 1, h = *max_element(piles.begin(), piles.end());
        int ans = 0;
        while(l <= h){
            int m = (l+h)/2;
            int res = canEat(piles, m);
            if(res <= t){
                ans = m;
                h = m-1;
            }
            else {
                l = m+1;
            }
        }
        return ans;
    }
};
