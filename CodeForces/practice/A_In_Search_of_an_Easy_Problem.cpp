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
    while(n--){
        int opinion;
        cin >> opinion;
        debug(opinion);
        if(opinion) {
            cout << "HARD" << endl;
            return 0;
        }
    }
    cout << "EASY" << endl;
    return 0;
}