#include<bits/stdc++.h>
#include<iostream>

using namespace std;

int main(){
	int t;
	cin >> t;
	while(t--){
		int c,m,x;
		cin >> c >> m >> x;
		int mini = min(c,m);
		int leftout = max(c,m)-mini +x;
		if(leftout<mini){
			cout << mini - (mini-leftout) << endl;
			return 0;
		}
		cout << mini << endl;
	}
}