#include <bits/stdc++.h>

using namespace std;

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif

string cleanStr(string str) {
    str.erase(remove(str.begin(), str.end(), '0'), str.end());
    return str;
}

int main()
{
    int n, k;
    cin >> n >> k;
    string str;
    cin >> str;
    debug(n, k, str);
    char c = 'a';
    while(k && c <= 'z') {
        for (size_t j = 0; j < 26; j++)
        {
            for (size_t i = 0; i < n; i++)
            {
                if(str[i] == c) {
                    str[i] = '0';
                    k--; 
                    if(k == 0 ) {
                      cout << cleanStr(str) << endl;
                      return 0;
                    }
                }
            }
            c++;
        }
    }
    cout << cleanStr(str) << endl;
    return 0;
}