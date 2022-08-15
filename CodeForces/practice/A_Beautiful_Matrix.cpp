#include <bits/stdc++.h>

using namespace std;

#ifdef ONLINE_JUDGE
#define debug(...) 42
#else
#include "algo/debug.h"
#endif

int main() {
    int dimension = 5;

    for(int i = 0; i < dimension; i++){
        for (int j = 0; j < dimension; j++)
        {
            int num;
            cin >> num;
            if(num != 0 ){
                debug(num);
                int x = (i - 2);
                x = x < 0 ? x *= -1 : x;
                debug(x);
                int y = (j - 2);
                y = y < 0 ? y *= -1 : y;
                debug(y);
                cout << x + y << endl;
                break;
            }
        }
    }
    return 0;
}