#include <bits/stdc++.h>

using namespace std;

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif

int main() {
    unsigned long long int input;
    cin >> input;
    int nearly_lucky = 0;
    while(input) {
        int lucky = input % 10;
        debug(lucky);
        if(lucky == 7 || lucky == 4){
            nearly_lucky++;
        }
        debug(input);
        debug(nearly_lucky);
        input /= 10;
      
    }
    debug(nearly_lucky);
    if(nearly_lucky == 7 || nearly_lucky == 4 ) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }
    return 0;
}