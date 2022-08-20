#include <bits/stdc++.h>

using namespace std;

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif

int main() {
    int n;
    cin >> n;
    set<int> reachables;
    while(n>0 && reachables.find(n) == reachables.end()) {
        debug(n);
        reachables.insert(n);
        n = n+1;
        while(n%10==0){
            n /=10;
        }
    }
    cout << reachables.size();
    return 0;
}