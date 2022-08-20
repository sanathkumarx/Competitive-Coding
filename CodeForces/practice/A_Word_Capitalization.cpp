#include <bits/stdc++.h>

using namespace std;

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif

int main() {
    string str;
    cin >> str;
    if(str[0] >= 97) {
        str[0] = str[0] - 32;
    }
    cout << str << endl;
    return 0;
}