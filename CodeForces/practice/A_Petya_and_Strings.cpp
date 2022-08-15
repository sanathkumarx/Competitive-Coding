#include <bits/stdc++.h>

using namespace std;

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif

int main() {
    string str1, str2;
    cin >> str1 >> str2;
    for (int i = 0; i < str1.length(); i++) {
        int c1, c2;
        c1 = (int)str1[i];
        c2 = (int)str2[i];
        c1 = c1 > 96 ? c1 - 32 : c1;
        c2 = c2 > 96 ? c2 - 32 : c2; 
        if(c1>c2){
            cout << 1 << endl; 
            break;
        } else if ( c1 < c2 ){
            cout << -1 << endl;
            break;
        } else {
            if(i == str1.length()-1){
                cout << 0 << endl;
            }
            continue;
        }       
    }
    return 0;
}