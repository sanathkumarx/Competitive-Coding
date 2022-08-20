#include <bits/stdc++.h>

using namespace std;

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif

int main() {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    double cspecial = m/(double)b;
    double cnormal = a;
    int ans1 = 0;
    int ans2 = 0;
    debug(cspecial, cnormal);
        ans1 += ((int)(n / m)) * b;
        debug(ans1);
        if(n % m != 0) {
            if((a * ((int)(n%m))) < b) {
                ans1 += a * ((int)(n%m));
            } else {
                ans1 += b;
            }
        }
        ans2 += n * a;
    if(ans1 < ans2 ) {
        cout << ans1;
    } else {
        cout << ans2;
    }
    return 0;
}