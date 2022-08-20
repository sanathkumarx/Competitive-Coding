#include <bits/stdc++.h>

using namespace std;

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif

int main() {
    int n, k;
    cin >> n >> k;
    while(k--) {
        n%10 ==0 ? n /= 10 : n--;
    }
    cout << n << endl;
    return 0;
}