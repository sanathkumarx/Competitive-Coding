#include <bits/stdc++.h>

using namespace std;

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif


int main() {
    // u_long ans = 0;xx/
    int t; 
    cin >> t;
    // int segmax[8] = {0, 0, 1, 7, 7, 7, 9, 9}
    while (t--) {
        int n;
        cin >> n;
        debug(n);
        // long ans = 0;
        // long decimal = 1000000000;
        string ans = "";
        while(n > 0) {
            if(n == 3 ) {
                ans += "7";
                n -=3;
                continue;
            }
            if(n >= 2) {
                ans += "1";
                n -= 2;
                continue;
            }

            // if(n >= 6) {
            //     n -= 6;
            //     ans = ans + "9";
            //     // ans += 9 * decimal;
            //     // decimal /=10;
            //     // cout << 9 << endl;
            //     continue;
            // }
            // if(n >= 3) {
            //     n -= 4;
            //     // ans += 7 * decimal;
            //     // decimal /= 10;
            //     // cout << 7 << endl;
            //     ans += "7";
            //     continue;
            // }
            // if(n >= 2) {
            //     n -= 2;
            //     // ans += 1 * decimal;
            //     // decimal /= 10;
            //     // cout << 2 << endl;
            //     ans += "1";
            //     continue;
            // }
            break;
        }
        reverse(ans.begin(), ans.end());
        debug(ans);
        cout << ans << endl;
    }
    return 0;
}