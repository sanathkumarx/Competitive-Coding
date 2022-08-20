#include <bits/stdc++.h>

using namespace std;

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif

int main() {
    int n,m;
    cin >> n >> m;
    vector<vector<int>> counts(m, vector<int>(5, 0));
    for (int i = 0; i < n; i++)
    {
        string answer;
        cin >> answer;
        for(int j = 0; j < m; j++){
            counts.at(j).at(answer[j]-'A')++;
        }
        
    }
    debug(counts);
    int ans = 0;
    for(int i = 0; i < m; i++){
        int score;
        cin >> score;
        ans += *max_element(counts.at(i).begin(), counts.at(i).end())*score;
    }
    cout << ans << endl;
    return 0;
}