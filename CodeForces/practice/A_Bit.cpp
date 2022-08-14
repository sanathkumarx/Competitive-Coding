#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    int out = 0;
    while(n--) {
        string statement;
        cin >> statement;
        if(statement.find('+') != string::npos){
            out++;
        } else if (statement.find("-") != string::npos){
            out--;
        }
    }
    cout << out << endl;
}